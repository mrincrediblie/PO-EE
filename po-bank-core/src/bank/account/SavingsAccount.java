package bank.account;

import java.time.Duration;
import java.time.LocalDate;

import bank.Account;

/**
 * Class for savings accounts. Savings accounts have a minimum time period.
 */
public class SavingsAccount extends DepositAccount {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202111230910L;

  /** The bank account associated with this savings account. */
  private Account _account;

  /** The account's time period. */
  private int _duration;

  /**
   * @param number   the account number.
   * @param amount   the initial balance.
   * @param rate     the account's interest rate.
   * @param duration the account's duration in days.
   * @param account  the associated bank account.
   */
  public SavingsAccount(int number, double amount, double rate, int duration, Account account) {
    super(number, rate, amount);
    _account = account;
    _duration = duration;
  }

  /**
   * Get the account's duration.
   * 
   * @return the account's duration.
   */
  final public int getDuration() {
    return _duration;
  }

  /**
   * Close savings account. The balance of the account is added to the bank
   * account associated with the savings account (which is then removed from the
   * list of savings accounts). This method considers interest only after the time
   * associated with the savings account has finished (otherwise, only the initial
   * balance is deposited in the bank account).
   */
  public void close() {
    try {
      if (Duration.between(getCreationDate(), LocalDate.now()).toDays() >= _duration)
        _account.deposit(getBalance() * (1 + getRate()));
      else
        _account.deposit(getBalance());
    } catch (InvalidDepositException | NegativeAmountException e) {
      // never happens
    }
  }

  /**
   * Savings accounts can only be initialized: they cannot be the object of
   * deposit operations.
   * 
   * @param amount the amount to be deposited (ignored).
   * @throws InvalidDepositException since it is not possible to make deposits in
   *                                 savings accounts.
   */
  @Override
  public void deposit(double amount) throws InvalidDepositException {
    throw new InvalidDepositException(_account.getNumber(), amount);
  }

  /**
   * Withdrawals cannot be performed on savings accounts.
   * 
   * @param amount the amount to be withdrawn (ignored).
   * @throws InvalidWithdrawalException since it is not possible to perform
   *                                    withdrawals from savings accounts.
   */
  @Override
  public void withdraw(double amount) throws InvalidWithdrawalException {
    throw new InvalidWithdrawalException(getNumber(), amount);
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "<savings-account initial='" + getCreationDate() + "' timelimit='" + _duration + "' balance='" + getBalance()
        + "'/>";
  }

}
