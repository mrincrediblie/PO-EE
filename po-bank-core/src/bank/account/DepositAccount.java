package bank.account;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This is an abstract class representing a deposit account. Subclasses refine
 * this class in accordance with the type of service provided by the bank. In
 * its most abstract form, a deposit account keeps track of the account's
 * balance, interest rate, deposit date and a deposit number. This number
 * uniquely identifies deposit accounts.
 */
abstract class DepositAccount implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202111230910L;

  /** The deposit account number. */
  private int _number;

  /** The deposit account balance. */
  private double _balance;

  /** The deposit account's creation date. */
  private LocalDate _creationDate;

  /** The deposit account's interest rate. */
  private double _rate;

  /**
   * Initialize a deposit account with a given interest rate and a given initial
   * amount. The number is taken from the internal shared counter _nextNumber. The
   * date is set to the current day.
   * 
   * @param number     the account number
   * @param rate   the deposit account interest rate.
   * @param amount the deposit account's initial balance.
   */
  public DepositAccount(int number, double rate, double amount) {
    _number = number;
    _balance = amount;
    _rate = rate;
    _creationDate = LocalDate.now();
  }

  /**
   * @param amount the amount to be deposited.
   * @throws InvalidDepositException if it not possible to perform the deposit.
   * @throws NegativeAmountException if the amount is not positive.
   */
  abstract public void deposit(double amount) throws InvalidDepositException, NegativeAmountException;

  /**
   * @param amount the amount to be withdrawn.
   * @throws InvalidWithdrawalException if the withdrawal is not possible.
   * @throws NegativeAmountException    if the amount is not positive.
   * @throws BalanceTooLowException
   */
  public abstract void withdraw(double amount)
      throws InvalidWithdrawalException, NegativeAmountException, BalanceTooLowException;

  /**
   * Add to the current balance (protected!).
   * 
   * @param amount the amount to increase (or decrease).
   */
  protected void addBalance(double amount) {
    _balance += amount;
  }

  /**
   * Returns the current balance.
   * 
   * @return the current balance.
   */
  public double getBalance() {
    return _balance;
  }

  /**
   * Returns the date of the deposit.
   * 
   * @return the date of the deposit.
   */
  final public LocalDate getCreationDate() {
    return _creationDate;
  }

  /**
   * Return the account rate.
   * 
   * @return the account rate
   */
  public final double getRate() {
    return _rate;
  }

  /**
   * Return the deposit account number.
   * 
   * @return the deposit account number
   */
  public final int getNumber() {
    return _number;
  }

  /** @see java.lang.Object#equals(java.lang.Object) */
  @Override
  public final boolean equals(Object o) {
    return o instanceof DepositAccount account && account.getNumber() == _number;
  }

}
