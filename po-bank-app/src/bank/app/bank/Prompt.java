package bank.app.bank;

/**
 * Interaction prompts.
 */
interface Prompt {

  /**
   * @return prompt for account id.
   */
  static String accountNumber() {
    return "Número de conta: ";
  }

  /**
   * @return string prompting for an account holder's id.
   */
  static String clientNumber() {
    return "Identificador do titular: ";
  }

  /**
   * @return prompt for name.
   */
  static String holderName() {
    return "Nome do titular: ";
  }

  /**
   * @return prompt for initial account balance.
   */
  static String initialBalance() {
    return "Saldo inicial: ";
  }

}
