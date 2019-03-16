/*
 * Feladatmegold�sok/18. fejezet
 * Projekt: Queue
 * Csomag: -
 * QueueApp.java (f�oszt�ly)
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import extra.Console;
import extra.util.IQueue;
import extra.util.*;

public class QueueApp {
  public static void run(IQueue q) {
    System.out.println("\n"+q.getClass().getName()+" tesztel�se:");
    char c;
    do {
      c = Character.toUpperCase(
        Console.readChar("E-�rkezik/S-sorraker�l/V-v�ge: "));
      switch (c){
        case 'E': q.put(Console.readLine("N�v: "));
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
