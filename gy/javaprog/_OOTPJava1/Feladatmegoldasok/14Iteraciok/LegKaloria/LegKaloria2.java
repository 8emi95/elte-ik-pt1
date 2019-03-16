/*
 * Feladatmegold�sok/14. fejezet
 * LegKaloria2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2002.01.02.
 */

import extra.*;

public class  LegKaloria2 {
  public static void main(String[] args) {
    int napiKaloria = Console.readInt("1. nap kal�ri�ja: ");
    int min = napiKaloria , max = napiKaloria;
    String minNapok = "1. nap", maxNapok = "1. nap";
    for (int nap=2; nap<=7; nap++) {
      napiKaloria = Console.readInt(nap+". nap kal�ri�ja: ");
      if (napiKaloria<min) {
        min=napiKaloria;
        minNapok=nap+". nap";
      }
      else if (napiKaloria==min) {
        minNapok+="  "+nap+". nap";
      }
      if (napiKaloria>max) {
        max=napiKaloria;
        maxNapok=nap+". nap";
      }
      else if (napiKaloria==max) {
        maxNapok+="  "+nap+". nap";
      }
    }
    System.out.println("Minim�lis fogyaszt�s:"+min+" kal�ria ("+minNapok+")");
    System.out.println("Maxim�lis fogyaszt�s:"+max+" kal�ria ("+maxNapok+")");
  }
}