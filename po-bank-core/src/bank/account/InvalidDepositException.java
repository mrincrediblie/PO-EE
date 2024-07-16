package bank.account;

/**
 * Exception for unsuccessful deposit operations.
 */
public class InvalidDepositException extends AccountOperationException {
  
  /** Serial number. */
  private static final long serialVersionUID = 202111230910L;

  /**
   * @param number account number
   * @param amount
   */
  public InvalidDepositException(int number, double amount) {
    super(number, amount);
  }

}