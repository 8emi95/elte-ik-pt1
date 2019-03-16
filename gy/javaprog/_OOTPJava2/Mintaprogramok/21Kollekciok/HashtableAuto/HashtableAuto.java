/*
 * Mintaprogramok/21. fejezet
 * HashtableAuto.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2004.08.01.
 */

import java.util.*;

public class HashtableAuto {
  public static void main(String[] args) {
    Hashtable autok = new Hashtable();

    autok.put("BIT-442","Piros Romeo");
    autok.put("SIT-999","Feh�r Merci");
    autok.put("CAR-152","Z�ld Mazda");

    // A teljes t�rk�p �sszes bejegyz�s�nek ki�r�sa:
    System.out.println(autok);

    // Kulcsok, �rt�kek ki�r�sa:
    System.out.println("Kulcsok: "+autok.keySet());
    System.out.println("�rt�kek: "+autok.values());

    // Adott kulcs� bejegyz�s keres�se:
    String rendszam = "CAR-152";
    if (autok.containsKey(rendszam))
      System.out.println(rendszam+" megvan, "+
          autok.get(rendszam));

    // Csere:
    autok.put(rendszam,"Fekete Trabant");

    // Ki�r�s iter�torral:
    Iterator iter = autok.keySet().iterator();
    int n = 0;
    while (iter.hasNext()) {
      Object key = iter.next();
      System.out.println(++n + ". " + autok.get(key));
    }
  }
}
