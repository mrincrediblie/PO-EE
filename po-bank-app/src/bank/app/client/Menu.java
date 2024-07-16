package bank.app.client;

import bank.client.Client;

/**
 * This class represents the Menu for BankAccounts.
 */
public class Menu extends pt.tecnico.uilib.menus.Menu {

  /** @param h */
  public Menu(Client h) {
    super(Label.TITLE, //
//        new Command<Holder>(MenuEntries.ADD_TO_ACCOUNT, h) {
//          protected final void execute() {
//            BankAccount acc = entity().getBank().getAccount(Form.requestInteger(Messages.requestAccount()));
//            if (acc != null)
//              acc.addHolder(entity());
//            else
//              _display.popup(bank.messages.bank.Messages.errorSelectingAccount(n.value()));
//          }
//        }, //
        new DoChangeName(h) // TODO (alunos)
    );
  }
}
