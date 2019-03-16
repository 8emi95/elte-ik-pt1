/*
 * Mintaprogramok/21. fejezet
 * TreeMapUser.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2004.08.01.
 */

import java.util.*;
import java.text.DateFormat;

class User {                                               //1
  private String userName;   // felhaszn�l�n�v
  private String password;   // jelsz�
  private Date lastVisited;  // a legut�bbi bel�p�s id�pontja

  public User(String userName, String password) {
    this.userName = userName;
    this.password = password;
    this.lastVisited = new Date(); // mai d�tum
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
    users.put("Bendeg�z", new User("Bendeg�z", "anyuk�d"));
    users.put("Erzs�bet", new User("Erzs�bet", "kim�st"));
    users.put("Naspolya", new User("Naspolya", "eddmeg"));

    System.out.println("Felhaszn�l�k sz�ma: " +
                       users.size());                      //3
    // Felhaszn�l�nevek list�z�sa:
    System.out.println("\nFelhaszn�l�nevek:");             //4
    Iterator iter = users.keySet().iterator();
    while (iter.hasNext())
      System.out.println(iter.next());

    // Felhaszn�l�k adatai:
    System.out.println("\nFelhaszn�l�k adatai:");          //5
    Collection values = users.values();
    iter = values.iterator();
    while (iter.hasNext())
      System.out.println(iter.next());

    // Megadott felhaszn�l� jelszav�nak ki�r�sa:
    String userName = "Bendeg�z";                          //6
    User user = (User)users.get(userName);
    if (user == null)
      System.out.println("\nNincs " + userName);
    else {
      System.out.println("\n" + userName +
        " jelszava: " + user.getPassword() +
        ", legut�bbi l�togat�sa: " + user.getLastVisited());
    }
  }
}
