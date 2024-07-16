package bank.app.account;

import bank.Account;
import bank.account.NoSuchSavingsAccountException;
import bank.account.SavingsAccount;
import bank.app.exceptions.InvalidSavingsAccountIdException;
import bank.app.savings.Menu;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Open menu for a specific savings account.
 */
class DoOpenMenuSavingsAccount extends Command<Account> {

  /** @param receiver */
  DoOpenMenuSavingsAccount(Account receiver) {
    super(Label.OPEN_MENU_SAVINGS_ACCOUNT, receiver);
    addIntegerField("id", Prompt.savingsAccountNumber());
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() throws CommandException {
    try {
      SavingsAccount account = _receiver.savingsAccount(integerField("id"));
      Menu menu = new Menu(account);
      menu.open();
    } catch (NoSuchSavingsAccountException e) {
      throw new InvalidSavingsAccountIdException(e.getNumber());
    }
  }
  
}
