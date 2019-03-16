/* 
 * Mintaprogramok/18. fejezet
 * SzavazatKiertekeles.java 
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

class Szavazatok {
  private int katSzam;
  private int[][] szavazat;

  public Szavazatok(String[] versenyzokSzama) {
    System.out.println(versenyzokSzama.length);
    katSzam = versenyzokSzama.length;
    // Kateg�ri�k l�trehoz�sa:
    szavazat = new int[katSzam+1][]; // 0. kateg�ria nem haszn�latos
    for (int k=1; k<=katSzam; k++)
      // Kateg�ri�nk�nt a versenyz�k sz�m�nak megfelel� r�szt�mb l�trehoz�sa:
      szavazat[k] = new int[Integer.parseInt(versenyzokSzama[k-1])];
  }
  
  public void feldolgozas() {
    int kat, vsz;
    do {
      kat = Console.readInt("Kategoria : ");
      if (kat == 0)
        continue;
      if (kat<1 || kat>katSzam) {
        System.out.println("Rossz kategoria");
        continue;
      }
      vsz = Console.readInt("Verszenyzo: ");
      if (vsz<0 || vsz>=szavazat[kat].length) {
        System.out.println("Rossz versenyzo sorszam");
        continue;
      }
      szavazat[kat][vsz]++;     // a megfelel� �rt�k n�vel�se
    } while (kat != 0);
  }

  public void print() {
    for (int i=1; i<=katSzam; i++) {
      System.out.println("\nSzavazatok az "+i+". kategoriaban");
      // A versenyz�k sorsz�mainak ki�r�sa:
      System.out.print("Vers. sorszama: ");
      for (int j=0; j<szavazat[i].length; j++)
        System.out.print(Format.right(j,3));
      System.out.println();

      // A versenyz�k szavazatainak ki�r�sa:
      System.out.print("Szavazatok    : ");
      for (int j=0; j<szavazat[i].length; j++)
        System.out.print(Format.right(szavazat[i][j],3));
      System.out.println();
      System.out.println("Osszesen: "+kategoriaOssz(i)+" szavazat");
    }
  }

  public void gyoztesVersenyzok() {
    // Maxim�lis �rt�k meghat�roz�sa
    int max = 0;
    for (int i=1; i<szavazat.length; i++)
      for (int j=0; j<szavazat[i].length; j++)
        if (szavazat[i][j] > max)
          max = szavazat[i][j];

    // A gy�ztesek ki�r�sa
    System.out.println("Gyoztes versenyzok:");
    for (int i=1; i<szavazat.length; i++) {
      for (int j=0; j<szavazat[i].length; j++)
        if (szavazat[i][j] == max)
          System.out.println(i+". kategoriaban a "+j+". versenyzo");
      System.out.println();
    }
  }

  public int kategoriaOssz(int kat) {
    int sum = 0;
    for (int j=0; j<szavazat[kat].length; j++)
      sum += szavazat[kat][j];
    return sum;
  }

  public void gyoztesKategoriak() {
    int max = 0;
    for (int i=1; i<szavazat.length; i++)
      if (kategoriaOssz(i) > max)
        max = kategoriaOssz(i);


    System.out.println("Gyoztes kategoriak:");
    for (int i=1; i<szavazat.length; i++)
      if (kategoriaOssz(i) == max)
        System.out.print(i+" ");
    System.out.println();
  }
}

public class SzavazatKiertekeles {
  public static void main(String[] args) {
    Szavazatok szavazatok = new Szavazatok(args);

    szavazatok.feldolgozas();
    szavazatok.print();
    szavazatok.gyoztesVersenyzok();
    szavazatok.gyoztesKategoriak();
  }
}

