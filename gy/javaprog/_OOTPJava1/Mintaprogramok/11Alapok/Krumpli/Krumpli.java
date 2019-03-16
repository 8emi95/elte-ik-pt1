/*
 * Mintaprogramok/11. fejezet
 * Krumpli.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.

 * A program a cserk�szt�bor konyhaf�n�ke r�sz�re k�sz�lt.
 * A program bek�ri a l�tsz�mot, majd ki�rja a krumpli
 * sz�ks�ges mennyis�g�t.
 */

import extra.*; // az extra egy saj�t csomag, nem API

public class Krumpli {
  public static void main(String[] args) {
    int letszam;
    double fejadag=0.4, osszesen;

    // A letszam v�ltoz� bek�r�se konzolr�l:
    letszam = Console.readInt("L�tsz�m? ");

    // A sz�ks�ges mennyis�g kisz�m�t�sa �s ki�r�sa:
    osszesen = fejadag*letszam;
    System.out.print("A sz�ks�ges mennyis�g: ");
    System.out.println(letszam+" * "+fejadag+" kg = "
      +Format.left(osszesen,0,2)+" kg");
  }
}
