package bank.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

/**
 * User interface exception invalid withdrawal operations.
 */
public class InvalidAccountIdException extends CommandException {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202010211636L;

  /** @param account */
  public InvalidAccountIdException(int account) {
    super(Messages.errorSelectingAccount(account));
  }

}
