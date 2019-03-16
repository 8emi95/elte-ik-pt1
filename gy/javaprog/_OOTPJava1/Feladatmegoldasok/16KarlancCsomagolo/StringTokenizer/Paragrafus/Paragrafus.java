/* 
 * Feladatmegoldások/16. fejezet
 * Paragrafus.java 
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */
 
import extra.*;
import java.util.*;

public class Paragrafus {
  public static void main(String[] args) {
    String paragrafus = Console.readLine("Paragrafus: ");
    StringTokenizer pt = new StringTokenizer(paragrafus,".!?",true);

    String mondat;
    while (pt.hasMoreTokens()) {
      mondat = pt.nextToken();
      if (pt.hasMoreTokens())
        mondat = (mondat+pt.nextToken()).trim();
      System.out.print(mondat);
      StringTokenizer mt = new StringTokenizer(mondat);
      System.out.println(" ("+mt.countTokens()+")");
    }
  }
}

