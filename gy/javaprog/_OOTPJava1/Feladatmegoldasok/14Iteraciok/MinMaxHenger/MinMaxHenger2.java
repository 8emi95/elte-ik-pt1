/*
 * Feladatmegoldások/14. fejezet
 * MinMaxHenger2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class MinMaxHenger2 {
  public static void main (String args[]) {
    double atmero, magassag;
    atmero = Console.readDouble("1. hordó\nátmérõ: ");
    if (atmero != 0) {
      magassag = Console.readDouble("magasság: ");
      double terfogat = Math.pow(atmero/2,2) * Math.PI * magassag;
      double min=terfogat, max=terfogat;
      double minAtm=atmero, minMag=magassag, maxAtm=atmero, maxMag=magassag;
      int sorszam=1, minSorsz=1, maxSorsz=1;

      while ((atmero = Console.readDouble((sorszam+1)+". hordó\nátmérõ: "))!=0) {
        sorszam++;
        magassag = Console.readDouble("magasság: ");
        terfogat = Math.pow(atmero/2,2) * Math.PI * magassag;
        if (terfogat < min) {
          min = terfogat;
          minSorsz = sorszam;
          minAtm = atmero;
          minMag = magassag;
        }
        else if (terfogat > max) {
          max = terfogat;
          maxSorsz = sorszam;
          maxAtm = atmero;
          maxMag = magassag;
        }
      }
      System.out.println();
      System.out.println("A legkevesebb bor a "+minSorsz+". hordóba fér.");
      System.out.println("Átmérõje : "+minAtm);
      System.out.println("Magassága: "+minMag);
      System.out.println("Térfogata: "+Format.left(min,0,2)+'\n');
      System.out.println("A legtöbb bor a "+maxSorsz+". hordóba fér.");
      System.out.println("Átmérõje : "+maxAtm);
      System.out.println("Magassága: "+maxMag);
      System.out.println("Térfogata: "+Format.left(max,0,2));
    }
    else
      System.out.println("\nNem volt bevitel!");
  }
}
