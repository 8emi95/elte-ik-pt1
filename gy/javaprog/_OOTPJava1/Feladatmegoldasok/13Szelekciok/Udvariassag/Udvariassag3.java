/*
 * Feladatmegold�sok/13. fejezet
 * Udvariassag3.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Udvariassag3 {
  public static void main(String[] args) {
    final int AKTEV = 2001;
    int kor1 = AKTEV-Console.readInt("Zs�fi sz�let�si �ve: ");
    int kor2 = AKTEV-Console.readInt("Kati sz�let�si �ve: ");
    int kor3 = AKTEV-Console.readInt("Juli sz�let�si �ve: ");

    String nev1 = "Zs�fi";
    String nev2 = "Kati";
    String nev3 = "Juli";

    if (kor1 < kor2) {
      //kor1 �s kor2 cser�je
      int segedKor=kor1;
      kor1=kor2;
      kor2=segedKor;

      //nev1 �s nev2 cser�je
      String segedNev=nev1;
      nev1=nev2;
      nev2=segedNev;
    }
    if (kor1 < kor3) {
      //kor1 �s kor3 cser�je
      int segedKor=kor1;
      kor1=kor3;
      kor3=segedKor;

      //nev1 �s nev3 cser�je
      String segedNev=nev1;
      nev1=nev3;
      nev3=segedNev;
    }
    if (kor2 < kor3) {
      //kor2 �s kor3 cser�je
      int segedKor=kor2;
      kor2=kor3;
      kor3=segedKor;

      //nev2 �s nev3 cser�je
      String segedNev=nev2;
      nev2=nev3;
      nev3=segedNev;
    }
    System.out.println(nev1+", "+nev2+", "+nev3);
  }
}
