package bank.app.account;

import bank.Account;
import pt.tecnico.uilib.menus.Command;

/**
 * Command for showing all the holders of an account.
 */
class DoShowAccountHolders extends Command<Account> {

  /** @param receiver */
  DoShowAccountHolders(Account receiver) {
    super(Label.SHOW_ACCOUNT_HOLDERS, receiver);
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() {
    _display.popup(_receiver.holders());
  }

}
