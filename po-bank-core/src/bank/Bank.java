package bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import bank.account.InvalidRemovalException;
import bank.account.NoSuchAccountException;
import bank.client.Client;
import bank.client.DuplicateClientException;
import bank.client.NoSuchClientException;

/**
 * Banks have clients and accounts. New clients can open new accounts or join
 * existing accounts.
 */
public class Bank implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202010211636L;

  /** Bank name. */
  private String _name;

  /** Account holders. */
  private Map<Integer, Client> _clients = new HashMap<>();

  /** Bank accounts. */
  private Map<Integer, Account> _accounts = new HashMap<>();

  /** Account counter. */
  private int _accountNumber = 0;

  /**
   * Constructor.
   * 
   * @param name bank name.
   */
  public Bank(String name) {
    _name = name;
  }

  /**
   * @return the name of the bank.
   */
  public final String getName() {
    return _name;
  }

  /** @see java.lang.Object#equals(java.lang.Object) */
  @Override
  public final boolean equals(Object o) {
    return o instanceof Bank bank && _name.equals(bank.getName());
  }

  /**
   * Create and register account.
   * 
   * @param amount initial balance for the account.
   * 
   * @return the new account.
   */
  public Account createAccount(double amount) {
    Account account = new Account(_accountNumber++, amount);
    _accounts.put(account.getNumber(), account);
    return account;
  }

  /**
   * Remove an account. An account can only be removed if its total balance is
   * zero. If it is not possible to remove an account, an exception is thrown.
   * 
   * @param account the account to be removed.
   * @throws InvalidRemovalException
   */
  public final void removeAccount(Account account) throws InvalidRemovalException {
    if (!account.canBeRemoved())
      throw new InvalidRemovalException(account.getNumber(), account.totalBalance());
    _accounts.remove(account.getNumber());
  }

  /**
   * @param number the account number.
   * @return the account
   * @throws NoSuchAccountException
   */
  public Account account(int number) throws NoSuchAccountException {
    Account account = _accounts.get(number);
    if (account == null)
      throw new NoSuchAccountException(number);
    return account;
  }

  /**
   * Return all the accounts as an unmodifiable collection.
   * 
   * @return a collection with all the accounts.
   */
  public Collection<Account> accounts() {
    return Collections.unmodifiableCollection(_accounts.values());
  }

  /**
   * @param number the client number
   * @param name   the client name
   * @throws DuplicateClientException
   */
  public void registerClient(int number, String name) throws DuplicateClientException {
    if (_clients.containsKey(number))
      throw new DuplicateClientException(number, name);
    _clients.put(number, new Client(number, name));
  }

  /**
   * @param number the client number
   * @throws NoSuchClientException
   */
  public void removeClient(int number) throws NoSuchClientException {
    client(number); // just to ensure it exists
    _clients.remove(number);
  }

  /**
   * Return all the account holders as an unmodifiable collection.
   * 
   * @return a collection with all the account holders.
   */
  public Collection<Client> clients() {
    return Collections.unmodifiableCollection(_clients.values());
  }

  /**
   * @param number the client number
   * @return the account holder
   * @throws NoSuchClientException
   */
  public Client client(int number) throws NoSuchClientException {
    Client client = _clients.get(number);
    if (client == null)
      throw new NoSuchClientException(number);
    return client;
  }

  /**
   * Simple function to parse basic information about accounts and holders.
   * 
   * ACCOUNT:account_number
   * 
   * HOLDER:holder_number:holder_name
   *
   * @param filename input file
   */
  public void importFile(String filename) {
    if (filename == null || filename.equals(""))
      return;

    try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
      String s;
      while ((s = in.readLine()) != null) {
        String line = new String(s.getBytes(), "UTF-8");
        if (line.charAt(0) == '#')
          continue;

        String[] fields = line.split(":");
        switch (fields[0]) {
        case "ACCOUNT" -> createAccount(Double.parseDouble(fields[1]));
        case "HOLDER" -> registerClient(Integer.parseInt(fields[1]), fields[2]);
        default -> throw new BadEntryException(fields[0]);
        }
      }
    } catch (DuplicateClientException | BadEntryException | IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * @param bank
   * @param filename
   * @throws IOException
   **/
  public void save(String filename) throws IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
      out.writeObject(this);
    }
  }

  /**
   * @param filename
   * @throws IOException
   * @throws ClassNotFoundException
   * @return a new bank recovered from file.
   **/
  public static Bank load(String filename) throws IOException, ClassNotFoundException {
    if (filename == null || filename.equals(""))
      return null;

    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
      return (Bank) in.readObject();
    }
  }

}
