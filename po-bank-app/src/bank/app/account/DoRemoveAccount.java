package bank.app.account;

import bank.Account;
import bank.Bank;
import bank.account.InvalidRemovalException;
import bank.app.exceptions.InvalidRemovalUIException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Remove a this account from the bank. The menu closes.
 */
class DoRemoveAccount extends Command<Account> {

  /** The bank the account belongs to. */
  private Bank _bank;

  /**
   * @param receiver the target account.
   * @param bank     the bank the account belongs to.
   */
  DoRemoveAccount(Account receiver, Bank bank) {
    super(true, Label.REMOVE_ACCOUNT, receiver);
    _bank = bank;
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() throws CommandException {
    try {
      _bank.removeAccount(_receiver);
    } catch (InvalidRemovalException e) {
      throw new InvalidRemovalUIException(e.getNumber(), e.getAmount());
    }
  }

}
