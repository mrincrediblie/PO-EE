package bank.account;

/**
 * Account does not exist.
 */
public class NoSuchSavingsAccountException extends AccountException {
  
  /** Serial number. */
  private static final long serialVersionUID = 202111230910L;

  /**
   * @param number
   */
  public NoSuchSavingsAccountException(int number) {
    super(number);
  }

}
