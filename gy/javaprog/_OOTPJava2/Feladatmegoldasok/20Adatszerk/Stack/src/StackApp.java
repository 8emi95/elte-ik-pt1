/*
 * Feladatmegoldások/20. fejezet
 * Projekt: Stack
 * Csomag: -
 * StackApp.java (fõosztály)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2003.04.01.
 */

import extra.Console;
import extra.util.IStack;
import extra.util.*;

public class StackApp {
  public static void run(IStack s) {
    System.out.println("\n"+s.getClass().getName()+" tesztelése:");
    char c;
    do {
      c = Character.toUpperCase(
        Console.readChar("B-Betesz / K-Kivesz / F-Felsõ / V-vége: "));
      switch (c){
        case 'B': s.push(Console.readLine("Név: "));
                  System.out.println("Verem: "+s);
                  break;
        case 'K': if (!s.isEmpty()) {
                    System.out.println(s.pop());
                    System.out.println("Verem: " + s);
                  }
                  else
                    System.out.println("A verem üres!");
                  break;
        case 'F': if (!s.isEmpty()) {
                    System.out.println(s.top());
                    System.out.println("Verem: " + s);
                  }
                  else
                    System.out.println("A verem üres!");
                  break;
      }
    } while (c != 'V');
  }

  public static void main(String args[]) {
    new StackApp().run(new ArrayStack());
    new StackApp().run(new LinkedListStack());
  }
}
