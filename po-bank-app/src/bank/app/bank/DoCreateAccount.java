package bank.app.bank;

import bank.Account;
import bank.Bank;
import pt.tecnico.uilib.menus.Command;

/**
 * Create a new account.
 */
class DoCreateAccount extends Command<Bank> {

  /** @param receiver */
  DoCreateAccount(Bank receiver) {
    super(Label.CREATE_ACCOUNT, receiver);
    addRealField("amount", Prompt.initialBalance());
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() {
    Account account = _receiver.createAccount(realField("amount"));
    _display.popup(Message.accountCreated(account.getNumber()));
  }
  
}
