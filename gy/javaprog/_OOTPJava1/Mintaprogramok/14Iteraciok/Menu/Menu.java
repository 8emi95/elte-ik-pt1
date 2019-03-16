/*
 * Mintaprogramok/14. fejezet
 * Menu.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.Console;

public class Menu {
  public static void main (String args[]) {
    char valasz;

    do {
      // Választási lehetõségek kiírása:
      System.out.print("E(gyik) / M(ásik) / V(ége)? ");

      // A felhasználó választ:
      valasz = Console.readChar();
      // Nagybetûre alakitás:
      valasz = Character.toUpperCase(valasz);

      // A kiválasztott funkció végrehajtása:
      switch (valasz) {
        case 'E':
          System.out.println("Egyik funkció végrehajtása\n");
          break;
        case 'M':
          System.out.println("Másik funkció végrehajtása\n");
          break;
      }
    } while (valasz!='V');
  }
}
