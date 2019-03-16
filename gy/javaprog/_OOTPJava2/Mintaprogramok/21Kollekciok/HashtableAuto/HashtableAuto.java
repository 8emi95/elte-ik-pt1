/*
 * Mintaprogramok/21. fejezet
 * HashtableAuto.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2004.08.01.
 */

import java.util.*;

public class HashtableAuto {
  public static void main(String[] args) {
    Hashtable autok = new Hashtable();

    autok.put("BIT-442","Piros Romeo");
    autok.put("SIT-999","Fehér Merci");
    autok.put("CAR-152","Zöld Mazda");

    // A teljes térkép összes bejegyzésének kiírása:
    System.out.println(autok);

    // Kulcsok, értékek kiírása:
    System.out.println("Kulcsok: "+autok.keySet());
    System.out.println("Értékek: "+autok.values());

    // Adott kulcsú bejegyzés keresése:
    String rendszam = "CAR-152";
    if (autok.containsKey(rendszam))
      System.out.println(rendszam+" megvan, "+
          autok.get(rendszam));

    // Csere:
    autok.put(rendszam,"Fekete Trabant");

    // Kiírás iterátorral:
    Iterator iter = autok.keySet().iterator();
    int n = 0;
    while (iter.hasNext()) {
      Object key = iter.next();
      System.out.println(++n + ". " + autok.get(key));
    }
  }
}
