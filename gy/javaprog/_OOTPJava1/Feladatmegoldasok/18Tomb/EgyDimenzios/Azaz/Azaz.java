/*
 * Feladatmegoldások/18. fejezet
 * Azaz.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

class Szam {
  private static String[] egyesek = {"","egy","kettõ","három","négy",
    "öt","hat","hét","nyolc","kilenc"};
  private static String[] tizesek = {"","tizen","huszon","harminc","negyven",
    "ötven","hatvan","hetven","nyolcvan","kilencven"};
  private static String[] ezresek = {"","ezer","millió","milliárd","billió",
    "ezer","trillió","ezer","kvadrillió","ezerkvadrillió","kvintillió"};
  private long szam;

  // Konstruktor:
  public Szam(long szam) {
    this.szam = szam;
  }

  /* Visszaadja a szám index. jegyét:
   */
  public int jegy(int index) {
    long n=szam;
    for (int i=0; i<index; i++)
      n=n/10;
    return (int)(n%10);
  }

  /* Visszaadja a jegyek számát:
   */
  public int jegyekSzama() {
    return (szam+"").length();
  }

  /* Visszaadja a szám jegyhármasainak számát:
   */
  public int jegyHarmasokSzama() {
    return (jegyekSzama()-1)/3+1;
  }

  /* Visszaadja a szám adott indexu hármas csoportját.
     Pl. Ha szam=8640546, csoport(0)=546, csoport(1)=640, csoport(2)=8
   */
  public int jegyHarmas(int index) {
    long n=szam;
    for (int i=0; i<index; i++)
      n=n/1000;
    return (int)(n%1000);
  }

  /* Visszaadja egy 1000-nél kisebb szám szöveges formáját:
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
      szoveg = egyesek[szam.jegy(2)]+"száz"+szoveg;
    return szoveg;
  }

  /* Visszaadja a szám szöveges, kimondott formáját,
     Például: 5601 - Ötezerhatszázegy
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

  /* Visszaadja a szám szöveges alakját.
     Például: 600 - "600"
   */
  public String toString() {
    return szam+"";
  }
}

public class Azaz {

  public static void main(String[] args) {
    Szam szam;
    while (true) {
      long n = Console.readLong("Szám: ");
      if (n==0) break;
      szam=new Szam(n);

      System.out.println("A szám: "+szam);
      System.out.println("A szám jegyeinek száma: "+szam.jegyekSzama());

      System.out.println("Számjegyek kiírása sorban:");
      for (int i=szam.jegyekSzama()-1; i>=0; i--)
        System.out.print(szam.jegy(i)+" "); // i a helyiérték
      System.out.println();

      System.out.println("Számhármasok kiírása:");
      for (int i=szam.jegyekSzama()/3; i>=0; i--)
        System.out.println(szam.jegyHarmas(i)+" ");

      System.out.println("Szám szöveggel: "+szam.szoveg());
    }
  }
}
