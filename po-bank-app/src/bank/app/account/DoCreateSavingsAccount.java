package bank.app.account;

import bank.Account;
import bank.account.BalanceTooLowException;
import bank.account.InvalidWithdrawalException;
import bank.account.NegativeAmountException;
import bank.app.exceptions.InvalidWithdrawalUIException;
import bank.app.exceptions.NegativeDepositUIException;
import bank.app.exceptions.NoBalanceWithdrawalUIException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Command for creating savings accounts.
 */
class DoCreateSavingsAccount extends Command<Account> {

  /** @param receiver */
  DoCreateSavingsAccount(Account receiver) {
    super(Label.CREATE_SAVINGS_ACCOUNT, receiver);
    addRealField("amount", Prompt.amount());
    addRealField("rate", Prompt.rate());
    addIntegerField("duration", Prompt.duration());
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() throws CommandException {
    try {
      _receiver.createSavingsAccount(realField("amount"), realField("rate"), integerField("duration"));
    } catch (InvalidWithdrawalException e) {
      throw new InvalidWithdrawalUIException(e.getNumber(), e.getAmount());
    } catch (NegativeAmountException e) {
      throw new NegativeDepositUIException(e.getAmount());
    } catch (BalanceTooLowException e) {
      throw new NoBalanceWithdrawalUIException(e.getBalance(), e.getAmount());
    }
  }
}
