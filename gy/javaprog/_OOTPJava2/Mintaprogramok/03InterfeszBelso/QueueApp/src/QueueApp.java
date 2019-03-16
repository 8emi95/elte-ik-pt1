/*
 * Mintaprogramok/3. fejezet
 * Projekt: QueueApp
 * QueueApp.java (F�oszt�ly)
 *
 * A t�bbi oszt�ly a javalib k�nyvt�r extra.util csomagj�ban van.
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

// QueueApp.java
import extra.Console;
import extra.util.*;

public class QueueApp {
  public void processQueue(ICleverQueue q) {
    char c;
    do {
      c = Character.toUpperCase(
        Console.readChar("E(rkezik)/S(orra ker�l)/T(�r�l h�rmat)/V(�ge): "));
      switch (c){
        case 'E': q.put(Console.readLine("N�v: "));
                  System.out.println("Sor: "+q);
                  break;
        case 'S': if (!q.isEmpty())
                    System.out.println(q.get());
                  System.out.println("Sor: "+q);
                  break;
        case 'T': q.remove(3);
                  System.out.println("Sor: "+q);
                  break;
      }
    } while (c != 'V');
  }

  public static void main (String args[]) {
    new QueueApp().processQueue(new CleverQueue());
  } // main
} // QueueApp
