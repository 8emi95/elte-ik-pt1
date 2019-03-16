/* 
 * Feladatmegold�sok/16. fejezet
 * SzoCsere.java 
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class SzoCsere {

  static void szoCsere(StringBuffer miben, String mit, String mire) {
    int poz = miben.toString().indexOf(mit);
    while (poz != -1) {
      miben.delete(poz,poz+mit.length());
      miben.insert(poz,mire);
      poz = miben.toString().indexOf(mit,poz+mire.length());
    }
  }
  
  public static void main(String[] args) {
    StringBuffer mondat = new StringBuffer("Egy kutya nem kutya dedede");
    szoCsere(mondat,"kutya","kutyabaj");
    System.out.println(mondat);
  }
}
