package bank.app.bank;

import bank.Account;
import bank.Bank;
import bank.account.NoSuchAccountException;
import bank.app.account.Menu;
import bank.app.exceptions.InvalidAccountIdException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Open account menu.
 */
class DoOpenMenuAccount extends Command<Bank> {

  /** @param receiver */
  DoOpenMenuAccount(Bank receiver) {
    super(Label.OPEN_MENU_ACCOUNT, receiver);
    addIntegerField("id", Prompt.accountNumber());
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() throws CommandException {
    try {
      Account account = _receiver.account(integerField("id"));
      Menu menu = new Menu(account, _receiver);
      menu.open();
    } catch (NoSuchAccountException e) {
      throw new InvalidAccountIdException(e.getNumber());
    }
  }

}
