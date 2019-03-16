/*
 * Feladatmegoldások/18. fejezet
 * Projekt: Queue
 * Csomag: -
 * QueueApp.java (fõosztály)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.Console;
import extra.util.IQueue;
import extra.util.*;

public class QueueApp {
  public static void run(IQueue q) {
    System.out.println("\n"+q.getClass().getName()+" tesztelése:");
    char c;
    do {
      c = Character.toUpperCase(
        Console.readChar("E-érkezik/S-sorrakerül/V-vége: "));
      switch (c){
        case 'E': q.put(Console.readLine("Név: "));
                  System.out.println("Sor: "+q);
                  break;
        case 'S': if (!q.isEmpty())
                    System.out.println(q.get());
                  System.out.println("Sor: "+q);
                  break;
      }
    } while (c != 'V');
  }

  public static void main(String args[]) {
    new QueueApp().run(new ArrayQueue());
    new QueueApp().run(new LinkedListQueue());
  } // main
} // Sor
