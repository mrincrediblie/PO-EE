package bank.app.client;

/**
 * Interaction prompts.
 */
interface Prompt {

  /** @return prompt for account */
  static String accountNumber() {
    return "Número de conta: ";
  }

  /** @return prompt for name */
  static String name() {
    return "Nome: ";
  }

}
