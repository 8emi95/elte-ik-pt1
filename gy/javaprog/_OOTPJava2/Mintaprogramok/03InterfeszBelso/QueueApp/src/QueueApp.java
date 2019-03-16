/*
 * Mintaprogramok/3. fejezet
 * Projekt: QueueApp
 * QueueApp.java (Fõosztály)
 *
 * A többi osztály a javalib könyvtár extra.util csomagjában van.
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
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
        Console.readChar("E(rkezik)/S(orra kerül)/T(öröl hármat)/V(ége): "));
      switch (c){
        case 'E': q.put(Console.readLine("Név: "));
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
