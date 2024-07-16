package bank.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

/**
 * User interface exception invalid withdrawal operations.
 */
public class NegativeWithdrawalUIException extends CommandException {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202010211636L;

  /** @param amount */
  public NegativeWithdrawalUIException(double amount) {
    super(Messages.invalidNegativeAmountWithdrawal(amount));
  }

}
