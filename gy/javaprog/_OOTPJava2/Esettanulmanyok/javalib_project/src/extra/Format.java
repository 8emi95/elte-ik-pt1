/*
 * javalib könyvtár
 * Csomag: extra
 * Format.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 1. kötet
 * 2002.09.01.
 *
 * Szövegek igazítása:
 *
 * String left(String str, int len)       // balra igazít, levág
 * String right(String str, int len)      // jobbra igazít, levág
 * String leftNocut(String str, int len)  // balra igazít, nem vág le
 * String rightNoCut(String str, int len) // jobbra igazít, nem vág le
 *
 * Számok igazítása (értékes jegyet sosem vág le):
 *
 * String left(long num, int len)
 * String right(long num, int len)
 * String left(double num, int len, int frac)
 * String right(double num, int len, int frac)
 */

package extra;
import java.text.*;
import java.util.*;

public class Format {
  // Az osztályból nem lehet példányt létrehozni:
  private Format() {
  }

  /* Mindig tizedes lesz. Locale.HU (magyar környezet)
   * esetén tizedesvesszõ lenne, és keverednének a kiírások.
   */
  private static NumberFormat nf =
      NumberFormat.getInstance(Locale.US);

  /* ---------------------------------------------------------------
   * String igazítása balra, adott hosszra.
   * Ha rövidebb, akkor jobbról szóközökkel kiegészíti, ha
   * hosszabb, akkor jobbról levágja:
   */
  public static String left(String str, int len) {
    StringBuffer sb = new StringBuffer(str);
    for (int i = str.length(); i < len; i++)
      sb.append(' ');
    return sb.toString().substring(0,len);
  }

 /* ---------------------------------------------------------------
   * String igazítása balra, adott hosszra.
   * Ha rövidebb, akkor jobbról szóközökkel kiegészíti.
   * Nem vágja le jobbról:
   */
  public static String leftNocut(String str, int len) {
    StringBuffer sb = new StringBuffer(str);
    for (int i = str.length(); i < len; i++)
      sb.append(' ');
    return sb.toString();
  }

  /* ---------------------------------------------------------------
   * String igazítása jobbra, adott hosszra.
   * Ha rövidebb, akkor balról szóközökkel kiegészíti, ha
   * hosszabb, akkor balról levágja:
   */
  public static String right(String str, int len) {
    StringBuffer sb = new StringBuffer(str);
    for (int i = str.length(); i < len; i++)
      sb.insert(0,' ');

    return sb.toString().substring(sb.length()-len);
  }

  /* ---------------------------------------------------------------
   * String igazítása jobbra, adott hosszra.
   * Ha rövidebb, akkor balról szóközökkel kiegészíti.
   * Nem vágja le balról:
   */
  public static String rightNocut(String str, int len) {
    StringBuffer sb = new StringBuffer(str);
    for (int i = str.length(); i < len; i++)
      sb.insert(0,' ');

    return sb.toString();
  }

  /* ---------------------------------------------------------------
   * long szám konvertálása Stringgé. Igazítás balra, len hosszon.
   * Ha rövidebb, akkor balról szóközökkel kiegészíti.
   * Értékes jegyeket nem vág le:
   */
  public static String left(long num, int len) {
    nf.setGroupingUsed(false);
    nf.setMaximumFractionDigits(0);
    return leftNocut(nf.format(num),len);
  }

  /* ---------------------------------------------------------------
   * long szám konvertálása Stringgé. Igazítás jobbra, len hosszon.
   * Ha rövidebb, akkor balról szóközökkel kiegészíti.
   * Értékes jegyeket nem vág le:
   */

  public static String right(long num, int len) {
    nf.setGroupingUsed(false);
    nf.setMaximumFractionDigits(0);
    return rightNocut(nf.format(num),len);
  }

  /* ---------------------------------------------------------------
   * double szám konvertálása Stringgé. Igazítás balra, len hosszon,
   * frac tizedesre. Értékes jegyeket nem vág le:
   */
  public static String left(double num, int len, int frac) {
    nf.setGroupingUsed(false);         // nincs tagolás
    nf.setMaximumFractionDigits(frac); // pontosan frac tizedes
    nf.setMinimumFractionDigits(frac);
    return leftNocut(nf.format(num),len);
  }

  // ---------------------------------------------------------------
  // double szám konvertálása Stringgé. Igazítás jobbra, len hosszon
  // frac tizedesre. Értékes jegyeket nem vág le:
  public static String right(double num, int len, int frac) {
    nf.setGroupingUsed(false);         // nincs tagolás
    nf.setMaximumFractionDigits(frac); // pontosan frac tizedes
    nf.setMinimumFractionDigits(frac);
    return rightNocut(nf.format(num),len);
  }
}
