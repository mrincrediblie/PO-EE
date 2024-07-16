package bank.app.account;

import bank.Account;
import pt.tecnico.uilib.menus.Command;

/**
 * Class representing a command for showing the balance of an account.
 */
class DoShowCurrentAccountBalance extends Command<Account> {

  /** @param receiver */
  DoShowCurrentAccountBalance(Account receiver) {
    super(Label.SHOW_CURRENT_ACCOUNT_BALANCE, receiver);
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() {
    _display.popup(Message.currentAccountBalance(_receiver.currentAccountBalance()));
  }
}
