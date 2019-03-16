/*
 * Feladatmegold�sok/19. fejezet
 * NemzetkoziLista.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

public class NemzetkoziLista {

  // a) �sszes nemzetk�zi k�rnyezet:
  static void kornyezetLista() {
    System.out.println("�sszes nemzetk�zi k�rnyezet:");
    Locale[] nemzetek = Locale.getAvailableLocales();
    int sorsz=0;
    for (int i = 0; i < nemzetek.length; i++) {
      Locale n = (Locale)nemzetek[i];
      if (!n.getISO3Country().equals(""))
        System.out.println(++sorsz +".\t"+n.getLanguage()+
        "\t"+n.getISO3Language()+"\t"+n.getDisplayLanguage());
    }
  }

  // b) �sszes nyelv:
  static void nyelvLista() {
    System.out.println("�sszes nyelv:");
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

  // c) �sszes id�z�na:
  static void idozonaLista() {
    // �sszes id�z�na azonos�t�:
    System.out.println("\n\n�sszes id�z�na azonos�t�:");
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
