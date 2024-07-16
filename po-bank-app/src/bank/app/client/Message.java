package bank.app.client;

/**
 * Information and error messages.
 */
interface Message {

  /**
   * @param id the duplicate holder's id.
   * @return error string
   */
  static String duplicateHolder(int id) {
    return "Um cliente com a identificação " + id + " já existe.";
  }
  
}
