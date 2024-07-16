package bank.client;

/**
 * Client does not exist.
 */
public class NoSuchClientException extends ClientException {
  
  /** Serial number. */
  private static final long serialVersionUID = 202111230910L;

  /**
   * @param number
   */
  public NoSuchClientException(int number) {
    super(number);
  }

}
