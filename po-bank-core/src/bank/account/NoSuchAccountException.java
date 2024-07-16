package bank.account;

/**
 * Account does not exist.
 */
public class NoSuchAccountException extends AccountException {

  /** Serial number. */
  private static final long serialVersionUID = 202111230910L;

  /**
   * @param number
   */
  public NoSuchAccountException(int number) {
    super(number);
  }

}
