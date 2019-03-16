/* 
 * Feladatmegoldások/16. fejezet
 * Ekezetcsere.java 
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Ekezetcsere {
  static String ekezetNelkul(String szoveg) {
    final String EKEZETES     = "áÁéÉíÍóÓõÕüÜûÛ";
    final String NEM_EKEZETES = "aAeEiIoOoOuUuU";
    for (int i=0; i<EKEZETES.length(); i++) {
      szoveg = szoveg.replace(EKEZETES.charAt(i),NEM_EKEZETES.charAt(i));
    }
    return szoveg;
  }

  public static void main(String[] args) {
    /* Elvileg mûködhetne, de az operációs rendszer nem kezeli az unikód karaktereket.
     * A println az ékezeteket nem írja ki helyesen.
     */
    String nev = "Éliás Tóbiás";
    System.out.println(nev+"  "+ekezetNelkul(nev));
  }
}
