/*
 * Feladatmegold�sok/14. fejezet
 * MinMaxHenger2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class MinMaxHenger2 {
  public static void main (String args[]) {
    double atmero, magassag;
    atmero = Console.readDouble("1. hord�\n�tm�r�: ");
    if (atmero != 0) {
      magassag = Console.readDouble("magass�g: ");
      double terfogat = Math.pow(atmero/2,2) * Math.PI * magassag;
      double min=terfogat, max=terfogat;
      double minAtm=atmero, minMag=magassag, maxAtm=atmero, maxMag=magassag;
      int sorszam=1, minSorsz=1, maxSorsz=1;

      while ((atmero = Console.readDouble((sorszam+1)+". hord�\n�tm�r�: "))!=0) {
        sorszam++;
        magassag = Console.readDouble("magass�g: ");
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
      System.out.println("A legkevesebb bor a "+minSorsz+". hord�ba f�r.");
      System.out.println("�tm�r�je : "+minAtm);
      System.out.println("Magass�ga: "+minMag);
      System.out.println("T�rfogata: "+Format.left(min,0,2)+'\n');
      System.out.println("A legt�bb bor a "+maxSorsz+". hord�ba f�r.");
      System.out.println("�tm�r�je : "+maxAtm);
      System.out.println("Magass�ga: "+maxMag);
      System.out.println("T�rfogata: "+Format.left(max,0,2));
    }
    else
      System.out.println("\nNem volt bevitel!");
  }
}
