package bank.app.savings;

/**
 * Information and error messages.
 */
interface Message {

  /**
   * @param balance the account's balance
   * @return string showing the account's balance
   */
  static String showBalance(double balance) {
    return "Saldo corrente: " + balance;
  }

}
