package bank.account;

/**
 * Balance is lower than amount being withdrawn.
 */
public class BalanceTooLowException extends AccountOperationException {

  /** Serial number. */
  private static final long serialVersionUID = 202111230910L;

  /** Current balance */
  private final double _balance;

  /**
   * @param number  account number
   * @param balance
   * @param amount
   */
  public BalanceTooLowException(int number, double balance, double amount) {
    super(number, amount);
    _balance = balance;
  }

  /**
   * @return the balance
   */
  public double getBalance() {
    return _balance;
  }

}
