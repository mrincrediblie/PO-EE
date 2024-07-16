package bank.account;

/**
 * Exception for unsuccessful withdrawal operations.
 */
public class InvalidWithdrawalException extends AccountOperationException {
  
  /** Serial number. */
  private static final long serialVersionUID = 202111230910L;

  /**
   * @param number account number
   * @param amount
   */
  public InvalidWithdrawalException(int number, double amount) {
    super(number, amount);
  }

}
