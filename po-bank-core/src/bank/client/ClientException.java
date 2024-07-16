package bank.client;

/**
 * Basic exception class for holder-related problems. Should not be instantiated
 * directly (thus, the abstract qualifier).
 */
public abstract class ClientException extends Exception {

  /** Serial number. */
  private static final long serialVersionUID = 202111230910L;

  /** The holder number. */
  private final int _number;

  /**
   * @param number
   */
  public ClientException(int number) {
    _number = number;
  }

  /**
   * @return the holder number.
   */
  public int getNumber() {
    return _number;
  }

}
