package bank.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

/**
 * User exception for presenting bad dates.
 */
public class InvalidDateException extends CommandException {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202010211636L;

  /** @param date The invalid date. */
  public InvalidDateException(int date) {
    super("Data inválida: " + date);
  }

}
