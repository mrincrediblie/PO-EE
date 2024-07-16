package bank.client;

/**
 * This exception represents a duplicate client problem.
 */
public class DuplicateClientException extends ClientException {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202111230910L;

  /** The holder name */
  private String _name;

  /**
   * @param number the client number
   * @param name   the client name
   */
  public DuplicateClientException(int number, String name) {
    super(number);
    _name = name;
  }

  /**
   * @return the holder name
   */
  public String getHolderName() {
    return _name;
  }

}
