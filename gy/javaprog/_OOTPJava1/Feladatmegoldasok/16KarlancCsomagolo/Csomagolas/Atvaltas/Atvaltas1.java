/*
 * Feladatmegold�sok/16. fejezet
 * Atvaltas1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Atvaltas1 {
  /* �tv�ltja a sz�vegben l�v� els� doll�r�sszeget forint�sszegre.
   * A visszaadott �rt�k a megv�ltoztatott sz�veg:
   */
  static String elsoDollarToForint(String str) {
    final double ARFOLYAM = 280;  // 1 $ == 280 Ft
    boolean van = false;
    int szamKezd=0, szamVeg=0;
    String szamStr = "";
    while (!van && szamKezd<str.length()) {
      // Megkeresi a k�vetkez� sz�mot:
      while (szamKezd<str.length() && !Character.isDigit(str.charAt(szamKezd)))
        szamKezd++;
      if (szamKezd==str.length())  // nem volt benne sz�m
        return str;
      szamVeg = szamKezd;
      while (szamVeg<str.length() && Character.isDigit(str.charAt(szamVeg)))
        szamVeg++;
      szamStr = str.substring(szamKezd,szamVeg);

      // Ha a sz�m ut�n a " $" szerepel, akkor ez doll�r�sszeg:
      if (szamVeg+1<str.length() && str.charAt(szamVeg)==' ' && str.charAt(szamVeg+1)=='$')
        van = true;
      // egy�bk�nt keres�s tov�bb:
      else
        szamKezd=szamVeg;
    }
    if (!van)
      return str;

    // �tv�lt�s:
    double szam = Double.parseDouble(szamStr);
    szam *= ARFOLYAM;
    szamStr = Format.right(szam,0,2);
    StringBuffer sb = new StringBuffer(str);
    sb.delete(szamKezd,szamVeg+2);
    sb.insert(szamKezd,szamStr+" Ft");
    return sb.toString();
  }

  /* �tv�ltja a sz�vegben l�v� �sszes doll�r�sszeget forint�sszegre.
   * A visszaadott �rt�k a megv�ltoztatott sz�veg:
   */
  static String dollarToForint(String str) {
    String forintStr;
    forintStr=elsoDollarToForint(str);
    while (!forintStr.equals(str))
      forintStr=elsoDollarToForint(str=forintStr);
    return forintStr;
  }

  public static void main(String[] args) {
    String szoveg, ujSzoveg;
    do {
      szoveg = Console.readLine("Sz�veg: ");
      ujSzoveg = dollarToForint(szoveg);
      if (ujSzoveg.equals(szoveg))
        System.out.println("Nincs benne doll�r�sszeg! �jra!");
    } while (ujSzoveg.equals(szoveg));
    System.out.println("�j sz�veg: "+ujSzoveg);
  }
}
