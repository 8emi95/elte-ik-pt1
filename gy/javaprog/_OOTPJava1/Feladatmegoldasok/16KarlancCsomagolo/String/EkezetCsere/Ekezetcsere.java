/* 
 * Feladatmegold�sok/16. fejezet
 * Ekezetcsere.java 
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Ekezetcsere {
  static String ekezetNelkul(String szoveg) {
    final String EKEZETES     = "��������������";
    final String NEM_EKEZETES = "aAeEiIoOoOuUuU";
    for (int i=0; i<EKEZETES.length(); i++) {
      szoveg = szoveg.replace(EKEZETES.charAt(i),NEM_EKEZETES.charAt(i));
    }
    return szoveg;
  }

  public static void main(String[] args) {
    /* Elvileg m�k�dhetne, de az oper�ci�s rendszer nem kezeli az unik�d karaktereket.
     * A println az �kezeteket nem �rja ki helyesen.
     */
    String nev = "�li�s T�bi�s";
    System.out.println(nev+"  "+ekezetNelkul(nev));
  }
}
