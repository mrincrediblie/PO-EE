package bank.app.bank;

import bank.Bank;
import bank.app.exceptions.DuplicateClientIdException;
import bank.client.DuplicateClientException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Register a new client (account holder).
 */
class DoRegisterClient extends Command<Bank> {

  /** @param receiver */
  DoRegisterClient(Bank receiver) {
    super(Label.REGISTER_CLIENT, receiver);
    addIntegerField("id", Prompt.clientNumber());
    addStringField("name", Prompt.holderName());
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() throws CommandException {
    try {
      int id = integerField("id");
      String name = stringField("name");
      _receiver.registerClient(id, name);
      _display.popup(Message.clientCreated(id, name));
    } catch (DuplicateClientException e) {
      throw new DuplicateClientIdException(e.getNumber());
    }
  }

}
