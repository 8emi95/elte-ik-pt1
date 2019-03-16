/*
 * Feladatmegoldások/13. fejezet
 * Udvariassag3.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Udvariassag3 {
  public static void main(String[] args) {
    final int AKTEV = 2001;
    int kor1 = AKTEV-Console.readInt("Zsófi születési éve: ");
    int kor2 = AKTEV-Console.readInt("Kati születési éve: ");
    int kor3 = AKTEV-Console.readInt("Juli születési éve: ");

    String nev1 = "Zsófi";
    String nev2 = "Kati";
    String nev3 = "Juli";

    if (kor1 < kor2) {
      //kor1 és kor2 cseréje
      int segedKor=kor1;
      kor1=kor2;
      kor2=segedKor;

      //nev1 és nev2 cseréje
      String segedNev=nev1;
      nev1=nev2;
      nev2=segedNev;
    }
    if (kor1 < kor3) {
      //kor1 és kor3 cseréje
      int segedKor=kor1;
      kor1=kor3;
      kor3=segedKor;

      //nev1 és nev3 cseréje
      String segedNev=nev1;
      nev1=nev3;
      nev3=segedNev;
    }
    if (kor2 < kor3) {
      //kor2 és kor3 cseréje
      int segedKor=kor2;
      kor2=kor3;
      kor3=segedKor;

      //nev2 és nev3 cseréje
      String segedNev=nev2;
      nev2=nev3;
      nev3=segedNev;
    }
    System.out.println(nev1+", "+nev2+", "+nev3);
  }
}
