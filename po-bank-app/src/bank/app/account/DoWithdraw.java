package bank.app.account;

import bank.Account;
import bank.account.BalanceTooLowException;
import bank.account.InvalidWithdrawalException;
import bank.account.NegativeAmountException;
import bank.app.exceptions.InvalidWithdrawalUIException;
import bank.app.exceptions.NegativeWithdrawalUIException;
import bank.app.exceptions.NoBalanceWithdrawalUIException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Withdrawal command.
 */
class DoWithdraw extends Command<Account> {

  /** @param account */
  DoWithdraw(Account account) {
    super(Label.WITHDRAW, account);
    addRealField("amount", Prompt.amount());
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() throws CommandException {
    try {
      _receiver.withdraw(realField("amount"));
    } catch (InvalidWithdrawalException e) {
      throw new InvalidWithdrawalUIException(e.getNumber(), e.getAmount());
    } catch (NegativeAmountException e) {
      throw new NegativeWithdrawalUIException(e.getAmount());
    } catch (BalanceTooLowException e) {
      throw new NoBalanceWithdrawalUIException(e.getBalance(), e.getAmount());
    }
  }
}
