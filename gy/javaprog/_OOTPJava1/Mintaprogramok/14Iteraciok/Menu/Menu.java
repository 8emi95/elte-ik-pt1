/*
 * Mintaprogramok/14. fejezet
 * Menu.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.Console;

public class Menu {
  public static void main (String args[]) {
    char valasz;

    do {
      // V�laszt�si lehet�s�gek ki�r�sa:
      System.out.print("E(gyik) / M(�sik) / V(�ge)? ");

      // A felhaszn�l� v�laszt:
      valasz = Console.readChar();
      // Nagybet�re alakit�s:
      valasz = Character.toUpperCase(valasz);

      // A kiv�lasztott funkci� v�grehajt�sa:
      switch (valasz) {
        case 'E':
          System.out.println("Egyik funkci� v�grehajt�sa\n");
          break;
        case 'M':
          System.out.println("M�sik funkci� v�grehajt�sa\n");
          break;
      }
    } while (valasz!='V');
  }
}
