package bank.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

/**
 * User interface exception invalid withdrawal operations.
 */
public class InvalidRemovalUIException extends CommandException {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202010211636L;

  /**
   * @param account Account number.
   * @param balance Balance.
   */
  public InvalidRemovalUIException(int account, double balance) {
    super(Messages.errorRemovingAccount(account, balance));
  }

}
