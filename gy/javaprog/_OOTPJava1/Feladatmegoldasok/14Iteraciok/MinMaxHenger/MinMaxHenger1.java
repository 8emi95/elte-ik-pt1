/*
 * Feladatmegoldások/14. fejezet
 * MinMaxHenger1.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class MinMaxHenger1 {
  public static void main (String args[]) {
    double atmero, magassag;
    double minAtm=0, minMag=0, maxAtm=0, maxMag=0;
    double min=1E6, max=0;
    /* Feltételezzük, hogy az átmérõ és magasság bevitelekor pozitív
     * értékeket adnak meg, és van 1 milliónál kisebb térfogatú hordó:
     */
    int sorszam=0, minSorsz=0, maxSorsz=0;
    while ((atmero = Console.readDouble((sorszam+1)+". hordó\nátmérõ: "))!=0) {
      sorszam++;
      magassag = Console.readDouble("magasság: ");
      double terfogat = Math.pow(atmero/2,2) * Math.PI * magassag;
      if (terfogat < min) {
        min = terfogat;
        minSorsz = sorszam;
        minAtm = atmero;
        minMag = magassag;
      }
      if (terfogat > max) {
        max = terfogat;
        maxSorsz = sorszam;
        maxAtm = atmero;
        maxMag = magassag;
      }
    }
    System.out.println();
    if (sorszam > 0) {
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
      System.out.println("Nem volt bevitel!");
  }
}
