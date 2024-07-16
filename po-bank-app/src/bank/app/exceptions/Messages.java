package bank.app.exceptions;

/**
 * Prompts and error messages.
 */
interface Messages {

  /**
   * @param entryType bad entry type.
   * @return string communication an error.
   */
  static String noSuchEntry(String entryType) {
    return "Não existe nenhuma entidade com o descritor '" + entryType + "'.";
  }

  /**
   * @param id the missing holder's id.
   * @return string communication an error.
   */
  static String noSuchClient(int id) {
    return "Não existe nenhum titular com o número " + id + ".";
  }

  /**
   * @param error error description (the balance as a string)
   * @return error string
   */
  static String errorRemovingAccount(String error) {
    return "Não é possível remover a conta. Saldo é " + error;
  }

  /**
   * @param account
   * @param amount
   * @return error string
   */
  static String errorRemovingAccount(int account, double amount) {
    return "Não é possível remover a conta " + account + ": saldo é " + amount;
  }

  /**
   * @return error string
   */
  static String errorShowingSavingsAccounts() {
    return "A conta não tem contas poupança";
  }

  /**
   * @param error
   * @return error string
   */
  static String errorExecutingOperation(String error) {
    return "Erro ao executar operação " + error;
  }

  /**
   * @return error string
   */
  static String errorShowingSavingsAccount() {
    return "Não existe nenhuma conta poupança com o identificador indicado";
  }

  /**
   * @param amount
   * @param account
   * @return invalid deposit message
   */
  static String invalidDeposit(int account, double amount) {
    return String.format("Depósito de %g inválido na conta %d.", amount, account);
  }

  /**
   * @param amount invalid negative amount
   * @return invalid deposit message
   */
  static String invalidNegativeAmountDeposit(double amount) {
    return "Depósito inválido: tentativa de depositar " + amount;
  }

  /**
   * @return invalid withdrawal message
   */
  static String invalidWithdrawal() {
    return "Levantamento inválido";
  }

  /**
   * @param amount invalid negative amount
   * @return invalid withdrawal message
   */
  static String invalidNegativeAmountWithdrawal(double amount) {
    return "Levantamento inválido: tentativa de levantar " + amount;
  }

  /**
   * @param balance
   * @param amount
   * @return invalid withdrawal message
   */
  static String notEnoughBalance(double balance, double amount) {
    return "Levantamento inválido: tentativa de levantar " + amount + " (saldo " + balance + ")";
  }

  /**
   * @param id the account's id
   * @return error string
   */
  static String errorSelectingAccount(int id) {
    return "Não existe uma conta com o número " + id + ".";
  }

  /**
   * @param error
   * @return the string describing an exception concerning an unknown holder id.
   */
  static String errorDuplicateClient(int id) {
    return "Já existe um titular com o número " + id + ".";
  }

  /**
   * @param account
   * @param amount
   * @return invalid withdrawal message
   */
  static String invalidWithdrawal(int account, double amount) {
    return String.format("Levantamento de %f inválido da conta %d.", amount, account);
  }

  /**
   * @return error string
   */
  static String errorSelectingSavingsAccount(int id) {
    return "Não existe nenhuma conta poupança com o identificador " + id + ".";
  }

}
