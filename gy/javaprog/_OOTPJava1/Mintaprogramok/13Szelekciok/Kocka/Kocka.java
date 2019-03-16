/*
 * Mintaprogramok/13. fejezet
 * Kocka.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class Kocka {
  public static void main(String[] args) {
    int dobas = Console.readInt("Dobj! 1-6: ");

    switch (dobas) {
      case 1:
      case 2:
      case 3:
        System.out.println("Gyenge!");
        break;
      case 4:
        System.out.println("Nem rossz!");
        break;
      case 5:
        System.out.println("Eg�sz j�!");
        break;
      case 6:
        System.out.println("Fantasztikus!");
        break;
      default:
        System.out.println("�rv�nytelen dob�s!");
    }
  }
}
