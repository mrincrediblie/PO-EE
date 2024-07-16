package bank.account;

/**
 * Exception for negative amounts.
 */
public class NegativeAmountException extends AccountOperationException {
  
  /** Serial number. */
  private static final long serialVersionUID = 202111230910L;

  /**
   * @param number the account number
   * @param amount the invalid amount
   */
  public NegativeAmountException(int number, double amount) {
    super(number, amount);
  }

}
