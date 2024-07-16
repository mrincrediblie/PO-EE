package bank.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

/**
 * User interface exception invalid withdrawal operations.
 */
public class InvalidSavingsAccountIdException extends CommandException {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202010211636L;

  /** @param id Account number. */
  public InvalidSavingsAccountIdException(int id) {
    super(Messages.errorSelectingSavingsAccount(id));
  }

}
