/*
 * Feladatmegold�sok/14. fejezet
 * MinMaxHenger1.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class MinMaxHenger1 {
  public static void main (String args[]) {
    double atmero, magassag;
    double minAtm=0, minMag=0, maxAtm=0, maxMag=0;
    double min=1E6, max=0;
    /* Felt�telezz�k, hogy az �tm�r� �s magass�g bevitelekor pozit�v
     * �rt�keket adnak meg, �s van 1 milli�n�l kisebb t�rfogat� hord�:
     */
    int sorszam=0, minSorsz=0, maxSorsz=0;
    while ((atmero = Console.readDouble((sorszam+1)+". hord�\n�tm�r�: "))!=0) {
      sorszam++;
      magassag = Console.readDouble("magass�g: ");
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
      System.out.println("Nem volt bevitel!");
  }
}
