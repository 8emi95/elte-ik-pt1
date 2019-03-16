/*
 * Feladatmegoldások/19. fejezet
 * NemzetkoziLista.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

public class NemzetkoziLista {

  // a) Összes nemzetközi környezet:
  static void kornyezetLista() {
    System.out.println("Összes nemzetközi környezet:");
    Locale[] nemzetek = Locale.getAvailableLocales();
    int sorsz=0;
    for (int i = 0; i < nemzetek.length; i++) {
      Locale n = (Locale)nemzetek[i];
      if (!n.getISO3Country().equals(""))
        System.out.println(++sorsz +".\t"+n.getLanguage()+
        "\t"+n.getISO3Language()+"\t"+n.getDisplayLanguage());
    }
  }

  // b) Összes nyelv:
  static void nyelvLista() {
    System.out.println("Összes nyelv:");
    Locale[] nemzetek = Locale.getAvailableLocales();
    Vector nyelvek = new Vector();

    for (int i = 0; i < nemzetek.length; i++) {
      String nyelv = nemzetek[i].getDisplayLanguage();
      if (!nyelvek.contains(nyelv))
        nyelvek.add(nyelv);
    }
    int sorsz=0;
    for (int i = 0; i < nyelvek.size(); i++) {
      System.out.println(++sorsz+".\t"+nyelvek.get(i));
    }
  }

  // c) Összes idõzóna:
  static void idozonaLista() {
    // Összes idõzóna azonosító:
    System.out.println("\n\nÖsszes idõzóna azonosító:");
    String[] idozonak = TimeZone.getAvailableIDs();
    int sorsz=0;
    for (int i = 0; i < idozonak.length; i++) {
      String iz = idozonak[i];
      if (!iz.equals(""))
        System.out.println(++sorsz +".\t"+iz);
    }
  }

  public static void main(String[] args) {
    kornyezetLista();
    nyelvLista();
    idozonaLista();
  }
}
