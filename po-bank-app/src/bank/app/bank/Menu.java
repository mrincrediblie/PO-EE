package bank.app.bank;

import bank.Bank;

/**
 * Bank menu.
 */
public class Menu extends pt.tecnico.uilib.menus.Menu {

  /** @param receiver the bank. */
  public Menu(Bank receiver) {
    super(Label.TITLE, //
        new DoRegisterClient(receiver), //
        new DoCreateAccount(receiver), //
        new DoShowAllClients(receiver), //
        new DoShowAllAccounts(receiver), //
        new DoOpenMenuClient(receiver), //
        new DoOpenMenuAccount(receiver) //
    );
  }
  
}
