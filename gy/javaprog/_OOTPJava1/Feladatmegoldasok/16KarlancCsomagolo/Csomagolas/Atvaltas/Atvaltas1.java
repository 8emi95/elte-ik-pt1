/*
 * Feladatmegoldások/16. fejezet
 * Atvaltas1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Atvaltas1 {
  /* Átváltja a szövegben lévõ elsõ dollárösszeget forintösszegre.
   * A visszaadott érték a megváltoztatott szöveg:
   */
  static String elsoDollarToForint(String str) {
    final double ARFOLYAM = 280;  // 1 $ == 280 Ft
    boolean van = false;
    int szamKezd=0, szamVeg=0;
    String szamStr = "";
    while (!van && szamKezd<str.length()) {
      // Megkeresi a következõ számot:
      while (szamKezd<str.length() && !Character.isDigit(str.charAt(szamKezd)))
        szamKezd++;
      if (szamKezd==str.length())  // nem volt benne szám
        return str;
      szamVeg = szamKezd;
      while (szamVeg<str.length() && Character.isDigit(str.charAt(szamVeg)))
        szamVeg++;
      szamStr = str.substring(szamKezd,szamVeg);

      // Ha a szám után a " $" szerepel, akkor ez dollárösszeg:
      if (szamVeg+1<str.length() && str.charAt(szamVeg)==' ' && str.charAt(szamVeg+1)=='$')
        van = true;
      // egyébként keresés tovább:
      else
        szamKezd=szamVeg;
    }
    if (!van)
      return str;

    // Átváltás:
    double szam = Double.parseDouble(szamStr);
    szam *= ARFOLYAM;
    szamStr = Format.right(szam,0,2);
    StringBuffer sb = new StringBuffer(str);
    sb.delete(szamKezd,szamVeg+2);
    sb.insert(szamKezd,szamStr+" Ft");
    return sb.toString();
  }

  /* Átváltja a szövegben lévõ összes dollárösszeget forintösszegre.
   * A visszaadott érték a megváltoztatott szöveg:
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
      szoveg = Console.readLine("Szöveg: ");
      ujSzoveg = dollarToForint(szoveg);
      if (ujSzoveg.equals(szoveg))
        System.out.println("Nincs benne dollárösszeg! Újra!");
    } while (ujSzoveg.equals(szoveg));
    System.out.println("Új szöveg: "+ujSzoveg);
  }
}
