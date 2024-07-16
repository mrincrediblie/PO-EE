package bank.app;

import java.io.IOException;

import bank.Bank;
import bank.app.bank.Menu;
import pt.tecnico.uilib.Dialog;

/**
 * Interactive bank application.
 */
public class App {

  /** @param args */
  public static void main(String[] args) {
    try (var ui = Dialog.UI) {
      Bank bank = null;
      String stateFilename = System.getProperty("state");
      String importFilename = System.getProperty("import");

      /* Create (and, maybe, load the persistent state of) a Bank instance */
      if (args.length == 1) {
        bank = new Bank(args[0]);
      } else {
        if (stateFilename != null) {
          try {
            bank = Bank.load(stateFilename);
          } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro: " + stateFilename + " : " + e);
          }
        }
        if (bank == null)
          bank = new Bank("BPO");
      }

      /* Read an import file, if any, and add contents to the bank */
      bank.importFile(importFilename);

      /* Start the user interface with the Bank instance */
      // DAVID FIXME TODO UI.setTitle(bank.getName());
      Menu menu = new Menu(bank);
      menu.open();

      /* On exit, save file. */
      try {
        if (stateFilename != null)
          bank.save(stateFilename);
      } catch (IOException e) {
        System.err.println("Erro: " + stateFilename + " : " + e);
      }
    }
  }

}
