package bank.app.account;

/**
 * Interaction prompts.
 */
interface Prompt {

  /**
   * @return prompt for a savings account id.
   */
  static String savingsAccountNumber() {
    return "Número da conta-poupança: ";
  }

  /**
   * @return prompt for amount
   */
  static String amount() {
    return "Valor: ";
  }

  /**
   * @return interest rate
   */
  static String rate() {
    return "Taxa: ";
  }

  /**
   * @return request time period for savings account
   */
  static String duration() {
    return "Prazo: ";
  }

}
