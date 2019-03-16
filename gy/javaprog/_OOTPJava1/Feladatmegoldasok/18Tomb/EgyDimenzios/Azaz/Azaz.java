/*
 * Feladatmegold�sok/18. fejezet
 * Azaz.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

class Szam {
  private static String[] egyesek = {"","egy","kett�","h�rom","n�gy",
    "�t","hat","h�t","nyolc","kilenc"};
  private static String[] tizesek = {"","tizen","huszon","harminc","negyven",
    "�tven","hatvan","hetven","nyolcvan","kilencven"};
  private static String[] ezresek = {"","ezer","milli�","milli�rd","billi�",
    "ezer","trilli�","ezer","kvadrilli�","ezerkvadrilli�","kvintilli�"};
  private long szam;

  // Konstruktor:
  public Szam(long szam) {
    this.szam = szam;
  }

  /* Visszaadja a sz�m index. jegy�t:
   */
  public int jegy(int index) {
    long n=szam;
    for (int i=0; i<index; i++)
      n=n/10;
    return (int)(n%10);
  }

  /* Visszaadja a jegyek sz�m�t:
   */
  public int jegyekSzama() {
    return (szam+"").length();
  }

  /* Visszaadja a sz�m jegyh�rmasainak sz�m�t:
   */
  public int jegyHarmasokSzama() {
    return (jegyekSzama()-1)/3+1;
  }

  /* Visszaadja a sz�m adott indexu h�rmas csoportj�t.
     Pl. Ha szam=8640546, csoport(0)=546, csoport(1)=640, csoport(2)=8
   */
  public int jegyHarmas(int index) {
    long n=szam;
    for (int i=0; i<index; i++)
      n=n/1000;
    return (int)(n%1000);
  }

  /* Visszaadja egy 1000-n�l kisebb sz�m sz�veges form�j�t:
   */
  public static String szoveg1000(int n) {
    Szam szam = new Szam(n);
    String szoveg = egyesek[szam.jegy(0)];
    if (szam.jegyekSzama()>1) {
      if (szam.jegy(0)==0 && szam.jegy(1)==1)
        szoveg="tiz";
      else if (szam.jegy(0)==0 && szam.jegy(1)==2)
        szoveg="husz";
      else
        szoveg=tizesek[szam.jegy(1)] + szoveg;
    }
    if (szam.jegyekSzama()==3)
      szoveg = egyesek[szam.jegy(2)]+"sz�z"+szoveg;
    return szoveg;
  }

  /* Visszaadja a sz�m sz�veges, kimondott form�j�t,
     P�ld�ul: 5601 - �tezerhatsz�zegy
   */
  public String szoveg() {
    StringBuffer szoveg=new StringBuffer();
    for (int i=jegyHarmasokSzama()-1; i>=0; i--) {
      int n=jegyHarmas(i);
      szoveg.append(szoveg1000(n));
      if (n!=0)
        szoveg.append(ezresek[i]);
    }
    char elso = Character.toUpperCase(szoveg.charAt(0));
    szoveg.setCharAt(0,elso);
    return szoveg.toString();
  }

  /* Visszaadja a sz�m sz�veges alakj�t.
     P�ld�ul: 600 - "600"
   */
  public String toString() {
    return szam+"";
  }
}

public class Azaz {

  public static void main(String[] args) {
    Szam szam;
    while (true) {
      long n = Console.readLong("Sz�m: ");
      if (n==0) break;
      szam=new Szam(n);

      System.out.println("A sz�m: "+szam);
      System.out.println("A sz�m jegyeinek sz�ma: "+szam.jegyekSzama());

      System.out.println("Sz�mjegyek ki�r�sa sorban:");
      for (int i=szam.jegyekSzama()-1; i>=0; i--)
        System.out.print(szam.jegy(i)+" "); // i a helyi�rt�k
      System.out.println();

      System.out.println("Sz�mh�rmasok ki�r�sa:");
      for (int i=szam.jegyekSzama()/3; i>=0; i--)
        System.out.println(szam.jegyHarmas(i)+" ");

      System.out.println("Sz�m sz�veggel: "+szam.szoveg());
    }
  }
}
