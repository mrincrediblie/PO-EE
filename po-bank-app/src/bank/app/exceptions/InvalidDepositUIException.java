package bank.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

/**
 * User interface exception invalid withdrawal operations.
 */
public class InvalidDepositUIException extends CommandException {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202010211636L;

  /**
   * @param amount  Invalid amount.
   * @param account Invalid account.
   */
  public InvalidDepositUIException(int account, double amount) {
    super(Messages.invalidDeposit(account, amount));
  }

}
