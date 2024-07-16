package bank.app.bank;

/**
 * Information and error messages.
 */
interface Message {

  /**
   * @param error
   * @return the string describing an exception concerning an unknown holder id.
   */
  static String errorShowingHolder(String error) {
    return "Mostrar Titular: " + error;
  }

  /**
   * @param id
   * @return string describing holder creation success.
   */
  static String createdHolder(int id) {
    return "Titular criado: " + id;
  }

  /**
   * @param id
   * @param name
   * @return string describing holder creation success.
   */
  static String clientCreated(int id, String name) {
    return "Titular '" + name + "', id '" + id + "' criado";
  }

  /**
   * @param accountId the new account
   * @return account creation message
   */
  static String accountCreated(int accountId) {
    return "Conta criada: " + accountId;
  }

  /**
   * @param error error description
   * @return error string
   */
  static String errorCreatingAccount(String error) {
    return "Erro na criação de conta: " + error;
  }

  /**
   * @param error error description
   * @return error string
   */
  static String errorShowingAccount(String error) {
    return "Mostrar Conta: " + error;
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
   * @return Holder key.
   */
  static String holderKey() {
    return "HOLDER";
  }

  /**
   * @return Account key.
   */
  static String accountKey() {
    return "ACCOUNT";
  }

}
