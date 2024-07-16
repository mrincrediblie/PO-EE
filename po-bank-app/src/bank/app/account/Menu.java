package bank.app.account;

import bank.Account;
import bank.Bank;

/**
 * Menu for bank accounts.
 */
public class Menu extends pt.tecnico.uilib.menus.Menu {

  /**
   * @param receiver the bank account
   * @param bank     the bank this account belongs to.
   */
  public Menu(Account receiver, Bank bank) {
    super(Label.TITLE, //
        new DoDeposit(receiver), //
        new DoWithdraw(receiver), //
        new DoShowCurrentAccountBalance(receiver), //
        new DoShowTotalBalance(receiver), //
        new DoShowAccountHolders(receiver), //
        new DoCreateSavingsAccount(receiver), //
        new DoOpenMenuSavingsAccount(receiver), //
        new DoShowSavingsAccounts(receiver), //
        new DoRemoveAccount(receiver, bank) //
    );
  }
  
}
