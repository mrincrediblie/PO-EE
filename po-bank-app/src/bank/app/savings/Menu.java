package bank.app.savings;

import bank.account.SavingsAccount;

/**
 * Menu for savings accounts.
 */
public class Menu extends pt.tecnico.uilib.menus.Menu {

  /** @param receiver the savings account */
  public Menu(SavingsAccount receiver) {
    super(Label.TITLE, //
        new DoShowBalance(receiver), //
        new DoCloseAccount(receiver) //
    );
  }

}
