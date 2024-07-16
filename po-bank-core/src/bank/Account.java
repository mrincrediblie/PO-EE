package bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import bank.account.BalanceTooLowException;
import bank.account.CurrentAccount;
import bank.account.InvalidDepositException;
import bank.account.InvalidWithdrawalException;
import bank.account.NegativeAmountException;
import bank.account.NoSuchSavingsAccountException;
import bank.account.SavingsAccount;
import bank.client.Client;

/**
 * This class represents the relationship between a bank and its customers
 * (account holders). An account has one or more holders and has one current
 * account and 0 (zero) or more savings accounts.
 */
public class Account implements Comparable<Account>, Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202111230910L;

  /** Account counter. */
  private int _accountNumber = 0;

  /** This account number. */
  private int _number;

  /** The current account associated with this account. */
  private CurrentAccount _currentAccount;

  /** The list of savings accounts associated with this account. */
  private Map<Integer, SavingsAccount> _savingsAccounts = new TreeMap<>();

  /** The holders of this account. */
  private List<Client> _holders = new ArrayList<>();

  /**
   * @param number account number
   * @param amount initial amount for the current account.
   */
  public Account(int number, double amount) {
    _number = number;
    _currentAccount = new CurrentAccount(_accountNumber++, amount);
  }

  /**
   * @return the account number.
   */
  public final int getNumber() {
    return _number;
  }

  /**
   * Compares account numbers.
   */
  @Override
  public int compareTo(Account account) {
    return Integer.compare(_number, account.getNumber());
  }

  /**
   * Two accounts are considered equal when they have the same account number.
   */
  @Override
  public boolean equals(Object o) {
    return o instanceof Account account && account.getNumber() == _number;
  }

  /**
   * Makes a deposit in the current account.
   * 
   * @param amount the amount to be deposited.
   * @throws InvalidDepositException if it is not possible to make the deposit.
   * @throws NegativeAmountException if the amount is not positive.
   */
  public void deposit(double amount) throws InvalidDepositException, NegativeAmountException {
    _currentAccount.deposit(amount);
  }

  /**
   * Performs a withdrawal.
   * 
   * @param amount the amount to be withdrawn.
   * @throws InvalidWithdrawalException if it is not possible to withdraw the
   *                                    intended amount.
   * @throws NegativeAmountException    if the amount is not positive.
   * @throws BalanceTooLowException
   */
  public void withdraw(double amount)
      throws InvalidWithdrawalException, NegativeAmountException, BalanceTooLowException {
    _currentAccount.withdraw(amount);
  }

  /**
   * @return the amount in the current account.
   */
  public double currentAccountBalance() {
    return _currentAccount.getBalance();
  }

  /**
   * Returns the total balance for the account. This balance includes the current
   * account balance and the balances of all the savings accounts. The following
   * implementation uses an implicit iterator, but the same actions could be
   * performed using an explicit one.
   * 
   * @return the account balance.
   */
  public double totalBalance() {
    double total = currentAccountBalance();
    for (var account : _savingsAccounts.values())
      total += account.getBalance();
    return total;
  }

  /**
   * Returns the holders of the account.
   * 
   * @return a list with the holders of the account.
   */
  public List<Client> holders() {
    return Collections.unmodifiableList(_holders);
  }

  /**
   * @param amount
   * @param rate
   * @param duration duration in days
   * @throws BalanceTooLowException
   * @throws NegativeAmountException
   * @throws InvalidWithdrawalException
   */
  public final void addSavingsAccount(double amount, double rate, int duration)
      throws InvalidWithdrawalException, NegativeAmountException, BalanceTooLowException {
    withdraw(amount);
    int id = _accountNumber++;
    _savingsAccounts.put(id, new SavingsAccount(id, amount, rate, duration, this));
  }

  /**
   * @param amount
   * @param rate
   * @param time
   * @throws BalanceTooLowException
   * @throws NegativeAmountException
   * @throws InvalidWithdrawalException
   */
  public void createSavingsAccount(double amount, double rate, int time)
      throws InvalidWithdrawalException, NegativeAmountException, BalanceTooLowException {
    withdraw(amount);
    addSavingsAccount(amount, rate, time);
  }

  /**
   * Returns the savings accounts associated with the bank account.
   * 
   * @param number the account number
   * @return the savings account
   * @throws NoSuchSavingsAccountException
   */
  public SavingsAccount savingsAccount(int number) throws NoSuchSavingsAccountException {
    SavingsAccount account = _savingsAccounts.get(number);
    if (account == null)
      throw new NoSuchSavingsAccountException(number);
    return account;
  }

  /**
   * Returns the savings accounts associated with the bank account.
   * 
   * @return a list of savings deposits or null (if there are no savings deposits.
   */
  public Collection<SavingsAccount> savingsAccounts() {
    return Collections.unmodifiableCollection((_savingsAccounts.values()));
  }

  /**
   * Remove a given savings account.
   * 
   * @param account the savings account to be removed.
   * @return true if the account owns this savings account.
   */
  public void removeSavingsAccount(SavingsAccount account) {
    _savingsAccounts.remove(account.getNumber());
  }

  /**
   * Add an account holder.
   * 
   * @param holder the holder to be added.
   */
  public void addHolder(Client holder) {
    _holders.add(holder);
  }

  /**
   * Verifies whether an account can be removed. An account can be removed only
   * when its total balance is 0 (zero).
   * 
   * @return true, if the account can be removed; false, otherwise.
   */
  public final boolean canBeRemoved() {
    return totalBalance() == 0;
  }

  /**
   * String representation of the account: presents the account number and the
   * total balance.
   * 
   * @return a string representation of the account.
   */
  @Override
  public String toString() {
    return "<account number='" + _number + "' balance='" + totalBalance() + "'/>";
  }

}
