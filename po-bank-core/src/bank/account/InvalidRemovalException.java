package bank.account;

/**
 * Exception for unsuccessful removal operations.
 */
public class InvalidRemovalException extends AccountOperationException {

  /** Serial number. */
  private static final long serialVersionUID = 202111230910L;

  /**
   * @param number account number
   * @param amount
   */
  public InvalidRemovalException(int number, double amount) {
    super(number, amount);
  }

}