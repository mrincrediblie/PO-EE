package bank;

/**
 * Client id does not exist..
 */
public class BadEntryException extends Exception {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202111230910L;

  /** Bad entry. */
  private String _entry;
  
  /** @param entryType */
  public BadEntryException(String entry) {
    _entry = entry;
  }

  /** @return entry */
  public String getEntry() {
    return _entry;
  }
  
}
