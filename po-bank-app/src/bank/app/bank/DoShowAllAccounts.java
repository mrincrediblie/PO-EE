package bank.app.bank;

import bank.Bank;
import pt.tecnico.uilib.menus.Command;

/**
 * Show all accounts.
 */
class DoShowAllAccounts extends Command<Bank> {

  /** @param receiver */
  DoShowAllAccounts(Bank receiver) {
    super(Label.SHOW_ALL_ACCOUNTS, receiver);
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() {
    _display.popup(_receiver.accounts());
  }

}
