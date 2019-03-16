/*
 * Feladatmegoldások/12. fejezet
 * Szamla.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Szamla {
  public static void main(String[] args) {
    final int KRUMPLI_EAR = 70;
    final int HAGYMA_EAR = 98;
    final int PADLIZSAN_EAR = 200;

    double krumpli = Console.readDouble("Hány kiló krumplit kér? ");
    double hagyma = Console.readDouble("Hány kiló hagymát kér? ");
    double padlizsan = Console.readDouble("Hány kiló padlizsánt kér? ");

    double krumpliAr = krumpli * KRUMPLI_EAR;
    double hagymaAr = hagyma * HAGYMA_EAR;
    double padlizsanAr = padlizsan * PADLIZSAN_EAR;
    double osszesen = krumpliAr + hagymaAr + padlizsanAr;

    System.out.println();
    System.out.print  (Format.left("krumpli",10)+":"+Format.right(krumpli,5,1)+" kg * ");
    System.out.print  (Format.right(KRUMPLI_EAR,4)+" Ft/kg =");
    System.out.println(Format.right(krumpliAr,6,0)+" Ft");
    System.out.print  (Format.left("hagyma",10)+":"+Format.right(hagyma,5,1)+" kg * ");
    System.out.print  (Format.right(HAGYMA_EAR,4)+" Ft/kg =");
    System.out.println(Format.right(hagymaAr,6,0)+" Ft");
    System.out.print  (Format.left("padlizsán",10)+":"+Format.right(padlizsan,5,1)+" kg * ");
    System.out.print  (Format.right(PADLIZSAN_EAR,4)+" Ft/kg =");
    System.out.println(Format.right(padlizsanAr,6,0)+" Ft");
    System.out.println("------------------------------------------");
    System.out.println("Összesen"+Format.right(osszesen,32,0)+" Ft");
  }
}
