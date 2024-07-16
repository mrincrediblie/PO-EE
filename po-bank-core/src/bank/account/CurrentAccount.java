package bank.account;

/**
 * Class for current accounts. These accounts allow withdrawals that do not
 * exceed the current balance. Current accounts have 0% (zero) interest rates.
 */
public class CurrentAccount extends DepositAccount {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202111230910L;

  /**
   * Initialize a current account, setting the initial balance.
   * 
   * @param number the account number.
   * @param amount the initial balance.
   */
  public CurrentAccount(int number, double amount) {
    super(number, 0.0d, amount);
  }

  /**
   * Add the given amount to the current balance (if the amount is positive).
   * 
   * @param amount the amount to be deposited.
   * @throws NegativeAmountException if the amount is not positive.
   */
  @Override
  public void deposit(double amount) throws NegativeAmountException {
    if (amount <= 0)
      throw new NegativeAmountException(getNumber(), amount);
    addBalance(amount);
  }

  /**
   * Withdraw a given amount: the balance must be grater or equal to the amount to
   * be withdrawn.
   * 
   * @param amount the amount to be withdrawn.
   * @throws NegativeAmountException
   * @throws BalanceTooLowException
   */
  @Override
  public void withdraw(double amount) throws NegativeAmountException, BalanceTooLowException {
    if (amount <= 0)
      throw new NegativeAmountException(getNumber(), amount);
    if (getBalance() < amount)
      throw new BalanceTooLowException(getNumber(), getBalance(), amount);
    addBalance(-amount);
  }

  /** @see java.lang.Object#toString() */
  @Override
  public String toString() {
    return "<current-account initial='" + getCreationDate() + "' balance='" + getBalance() + "'/>";
  }

}
