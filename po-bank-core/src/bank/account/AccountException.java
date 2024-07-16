package bank.account;

/**
 * Basic exception class for bank operations. Should not be instantiated
 * directly (thus, the abstract qualifier).
 */
public abstract class AccountException extends Exception {
  
  /** Serial number. */
  private static final long serialVersionUID = 202111230910L;

  /** The account */
  private final int _number;

  /**
   * @param number
   */
  public AccountException(int number) {
    _number = number;
  }

  /**
   * @return the account number
   */
  public int getNumber() {
    return _number;
  }

}
