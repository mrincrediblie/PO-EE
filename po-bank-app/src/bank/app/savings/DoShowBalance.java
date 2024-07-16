package bank.app.savings;

import bank.account.SavingsAccount;
import pt.tecnico.uilib.menus.Command;

/**
 * Show the account's balance.
 */
class DoShowBalance extends Command<SavingsAccount> {

  /** @param receiver */
  DoShowBalance(SavingsAccount receiver) {
    super(Label.SHOW_BALANCE, receiver);
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() {
    _display.popup(Message.showBalance(_receiver.getBalance()));
  }

}
