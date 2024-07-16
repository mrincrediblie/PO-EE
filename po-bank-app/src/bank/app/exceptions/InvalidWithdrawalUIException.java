package bank.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

/**
 * User interface exception invalid withdrawal operations.
 */
public class InvalidWithdrawalUIException extends CommandException {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202010211636L;

  /**
   * @param account Invalid account.
   * @param amount  Invalid amount.
   */
  public InvalidWithdrawalUIException(int account, double amount) {
    super(Messages.invalidWithdrawal(account, amount));
  }

}
