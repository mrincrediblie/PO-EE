package bank.app.account;

/**
 * Information and error messages.
 */
interface Message {

  /**
   * @return title for menu entry for getting the current account balance.
   */
  static String currentAccountBalance() {
    return "Saldo Corrente";
  }

  /**
   * @param balance
   * @return string describing the current balance of the accounts
   */
  static String currentAccountBalance(double balance) {
    return "Saldo corrente: " + balance;
  }

  /**
   * @return title for menu entry for getting the total balance.
   */
  static String totalBalance() {
    return "Saldo Total";
  }

  /**
   * @param balance
   * @return string describing the total balance of the accounts
   */
  static String totalBalance(double balance) {
    return "Saldo total: " + balance;
  }

}
