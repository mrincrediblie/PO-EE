package bank.app.account;

import bank.Account;
import pt.tecnico.uilib.menus.Command;

/**
 * Command for showing the balance of an account.
 */
class DoShowTotalBalance extends Command<Account> {

  /** @param receiver */
  DoShowTotalBalance(Account receiver) {
    super(Label.SHOW_TOTAL_BALANCE, receiver);
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() {
    _display.popup(Message.totalBalance(_receiver.totalBalance()));
  }
  
}
