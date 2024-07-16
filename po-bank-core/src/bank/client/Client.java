package bank.client;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Class Holder contains information about holders of bank accounts. Each holder
 * is identified by a number. Note that this class is not comparable.
 */
public class Client implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202111230910L;

  /**
   * NUMBER_COMPARATOR allow comparing holders based on their numbers. This
   * version uses a lambda function instead of an explicit class, but the
   * functionality is the same.
   * 
   * @see java.util.Comparator
   */
  public static final Comparator<Client> NUMBER_COMPARATOR = //
      (h1, h2) -> h1._number - h2._number;

  /**
   * NAME_COMPARATOR allow comparing holders based on their names. This version
   * uses a lambda function instead of an explicit class, but the functionality is
   * the same.
   * 
   * @see java.util.Comparator
   */
  public static final Comparator<Client> NAME_COMPARATOR = //
      (h1, h2) -> h1.getName().compareToIgnoreCase(h2.getName());

  /** The holder's id. */
  private int _number;

  /** The holder's name. */
  private String _name;

  /**
   * Constructor (initializes id and name).
   * 
   * @param number the holder's id.
   * @param name   the holder's name.
   * @throws DuplicateClientException
   */
  public Client(int number, String name) throws DuplicateClientException {
    _number = number;
    _name = name;
  }

  /**
   * Constructor (initializes from array of String).
   * 
   * @param fields the holder's parameters.
   * @throws DuplicateClientException
   */
  public Client(String[] fields) throws DuplicateClientException {
    this(Integer.parseInt(fields[1]), fields[2]);
  }

  /**
   * @return the holder's id.
   */
  public final int getNumber() {
    return _number;
  }

  /**
   * @return the holder's name.
   */
  public String getName() {
    return _name;
  }

  /**
   * @param name the new name.
   */
  public final void setName(String name) {
    _name = name;
  }

  /** @see java.lang.Object#equals(java.lang.Object) */
  @Override
  public boolean equals(Object o) {
    return o instanceof Client holder && holder.getNumber() == _number;
  }

  /** @see java.lang.Object#toString() */
  @Override
  public String toString() {
    return "<holder name='" + _name + "' id='" + _number + "'/>";
  }

}
