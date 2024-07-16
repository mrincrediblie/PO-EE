package bank.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

/**
 * User interface exception invalid withdrawal operations.
 */
public class NoBalanceWithdrawalUIException extends CommandException {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202010211636L;

  /**
   * @param balance
   * @param amount
   */
  public NoBalanceWithdrawalUIException(double balance, double amount) {
    super(Messages.notEnoughBalance(balance, amount));
  }

}
