package bank.app.savings;

import bank.account.SavingsAccount;
import pt.tecnico.uilib.menus.Command;

/**
 * Close the account.
 */
class DoCloseAccount extends Command<SavingsAccount> {

  /** @param receiver */
  DoCloseAccount(SavingsAccount receiver) {
    super(Label.CLOSE_ACCOUNT, receiver);
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() {
    _receiver.close();
  }

}
