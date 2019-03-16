/*
 * Mintaprogramok/21. fejezet
 * TreeSetUser.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

class User implements Comparable {
  private String name;
  private String password;

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }
  public User(String name) {
    this(name,"");
  }
  public String getName() { return name; }
  public String getPassword() { return password; }
  public int compareTo(Object o) {
    return name.compareTo(((User)o).getName());
  }
  public String toString() {
    return "\n"+name+", "+password;
  }
}

public class TreeSetUser {
  public static void main(String[] args) {
    TreeSet users = new TreeSet();

    users.add(new User("Nagybuta","netuddmeg"));
    users.add(new User("Bendeg�z","anyukad"));
    users.add(new User("Erzs�bet","kim�st"));
    users.add(new User("Naspolya","eddmg"));

    System.out.println("Felhaszn�l�k sz�ma: "+users.size());

    // T�rp�k list�z�sa:
    if (users.contains(new User("Bendeg�z")))
      System.out.println("Van Bendeg�z");
  }
}
