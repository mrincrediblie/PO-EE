package bank.app.bank;

import bank.Bank;
import bank.app.client.Menu;
import bank.app.exceptions.InvalidClientIdException;
import bank.client.Client;
import bank.client.NoSuchClientException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Open client menu.
 */
class DoOpenMenuClient extends Command<Bank> {

  /** @param receiver */
  DoOpenMenuClient(Bank receiver) {
    super(Label.OPEN_MENU_CLIENT, receiver);
    addIntegerField("id", Prompt.clientNumber());
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() throws CommandException {
    try {
      Client client = _receiver.client(integerField("id"));
      Menu menu = new Menu(client);
      menu.open();
    } catch (NoSuchClientException e) {
      throw new InvalidClientIdException(e.getNumber());
    }
  }

}
