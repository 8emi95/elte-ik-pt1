/*
 * Mintaprogramok/21. fejezet
 * TreeMapUser.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2004.08.01.
 */

import java.util.*;
import java.text.DateFormat;

class User {                                               //1
  private String userName;   // felhasználónév
  private String password;   // jelszó
  private Date lastVisited;  // a legutóbbi belépés idõpontja

  public User(String userName, String password) {
    this.userName = userName;
    this.password = password;
    this.lastVisited = new Date(); // mai dátum
  }
  public User(String userName) {
    this(userName,"");
  }
  public String getUserName() { return userName; }
  public String getPassword() { return password; }
  public String getLastVisited() {
    return DateFormat.getDateTimeInstance().
        format(lastVisited);
  }
  public void setLastVisited() {
    lastVisited = new Date();
  }
  public String toString() {
    return userName+", "+password+", "+getLastVisited();
  }
}

public class TreeMapUser {
  public static void main(String[] args) {
    TreeMap users = new TreeMap();                         //2

    users.put("Nagybuta", new User("NagyButa", "netuddmeg"));
    users.put("Bendegúz", new User("Bendegúz", "anyukád"));
    users.put("Erzsébet", new User("Erzsébet", "kimást"));
    users.put("Naspolya", new User("Naspolya", "eddmeg"));

    System.out.println("Felhasználók száma: " +
                       users.size());                      //3
    // Felhasználónevek listázása:
    System.out.println("\nFelhasználónevek:");             //4
    Iterator iter = users.keySet().iterator();
    while (iter.hasNext())
      System.out.println(iter.next());

    // Felhasználók adatai:
    System.out.println("\nFelhasználók adatai:");          //5
    Collection values = users.values();
    iter = values.iterator();
    while (iter.hasNext())
      System.out.println(iter.next());

    // Megadott felhasználó jelszavának kiírása:
    String userName = "Bendegúz";                          //6
    User user = (User)users.get(userName);
    if (user == null)
      System.out.println("\nNincs " + userName);
    else {
      System.out.println("\n" + userName +
        " jelszava: " + user.getPassword() +
        ", legutóbbi látogatása: " + user.getLastVisited());
    }
  }
}
