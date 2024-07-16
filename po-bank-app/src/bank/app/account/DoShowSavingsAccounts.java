package bank.app.account;

import bank.Account;
import pt.tecnico.uilib.menus.Command;

/**
 * Command for showing all the savings accounts.
 */
class DoShowSavingsAccounts extends Command<Account> {

  /** @param receiver */
  DoShowSavingsAccounts(Account receiver) {
    super(Label.SHOW_SAVINGS_ACCOUNTS, receiver);
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() {
    _display.popup(_receiver.savingsAccounts());
  }

}
