package bank.app.bank;

import bank.Bank;
import pt.tecnico.uilib.menus.Command;

/**
 * Show all account holders.
 */
class DoShowAllClients extends Command<Bank> {

  /** @param receiver */
  DoShowAllClients(Bank receiver) {
    super(Label.SHOW_ALL_CLIENTS, receiver);
  }

  /** @see pt.tecnico.uilib.menu.Command#execute() */
  @Override
  protected final void execute() {
    _display.popup(_receiver.clients());
  }

}
