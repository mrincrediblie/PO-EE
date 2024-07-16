package bank.app.account;

import bank.Account;
import bank.account.InvalidDepositException;
import bank.account.NegativeAmountException;
import bank.app.exceptions.InvalidDepositUIException;
import bank.app.exceptions.NegativeDepositUIException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Command for making deposits.
 */
class DoDeposit extends Command<Account> {

  /** @param receiver */
  DoDeposit(Account receiver) {
    super(Label.DEPOSIT, receiver);
    addRealField("amount", Prompt.amount());
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() throws CommandException {
    try {
      _receiver.deposit(realField("amount"));
    } catch (InvalidDepositException e) {
      throw new InvalidDepositUIException(e.getNumber(), e.getAmount());
    } catch (NegativeAmountException e) {
      throw new NegativeDepositUIException(e.getAmount());
    }
  }
}
