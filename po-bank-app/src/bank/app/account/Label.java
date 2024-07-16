package bank.app.account;

/**
 * Titles for menu entries.
 */
interface Label {

  /** Menu title. */
  String TITLE = "Operações Conta";

  /** Entry for removing accounts. */
  String REMOVE_ACCOUNT = "Remover Conta";

  /** Entry for showing account holders. */
  String SHOW_ACCOUNT_HOLDERS = "Mostrar Titulares";

  /** Create a savings account in a bank account. */
  String CREATE_SAVINGS_ACCOUNT = "Adicionar conta-poupança";

  /** Entry for showing a specific savings account. */
  String OPEN_MENU_SAVINGS_ACCOUNT = "Ver conta-poupança";

  /** Entry for showing all savings accounts. */
  String SHOW_SAVINGS_ACCOUNTS = "Mostrar todas as contas-poupança";

  /** Entry for making deposits. */
  String DEPOSIT = "Depositar";

  /** Entry for making withdrawals. */
  String WITHDRAW = "Levantar";

  /** Entry for making withdrawals. */
  String SHOW_TOTAL_BALANCE = "Mostrar saldo total";

  /** Entry for making withdrawals. */
  String SHOW_CURRENT_ACCOUNT_BALANCE = "Mostrar saldo da conta à ordem";

}
