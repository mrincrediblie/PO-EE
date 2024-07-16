package bank.app.client;

import bank.client.Client;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Command for changing an account holder's name.
 */
class DoChangeName extends Command<Client> {

  /** @param receiver */
  DoChangeName(Client receiver) {
    super(Label.CHANGE_NAME, receiver);
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() throws CommandException {
    // TODO -- left as an exercise
  }
  
}
