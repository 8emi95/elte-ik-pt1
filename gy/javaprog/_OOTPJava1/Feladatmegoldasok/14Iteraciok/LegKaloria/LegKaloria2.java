/*
 * Feladatmegoldások/14. fejezet
 * LegKaloria2.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;

public class  LegKaloria2 {
  public static void main(String[] args) {
    int napiKaloria = Console.readInt("1. nap kalóriája: ");
    int min = napiKaloria , max = napiKaloria;
    String minNapok = "1. nap", maxNapok = "1. nap";
    for (int nap=2; nap<=7; nap++) {
      napiKaloria = Console.readInt(nap+". nap kalóriája: ");
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
    System.out.println("Minimális fogyasztás:"+min+" kalória ("+minNapok+")");
    System.out.println("Maximális fogyasztás:"+max+" kalória ("+maxNapok+")");
  }
}