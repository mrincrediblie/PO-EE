package bank.account;

/**
 * Exception for unsuccessful operations on accounts.
 */
public abstract class AccountOperationException extends AccountException {
  
  /** Serial number. */
  private static final long serialVersionUID = 202111230910L;

  /** The amount involved in the operation. */
  private final double _amount;

  /**
   * @param number account number
   * @param amount
   */
  public AccountOperationException(int number, double amount) {
    super(number);
    _amount = amount;
  }

  /**
   * @return the amount
   */
  public double getAmount() {
    return _amount;
  }
  
}