/*
 * Feladatmegold�sok/13. fejezet
 * EvszamOszthato.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class EvszamOszthato {
  public static void main(String[] args) {
    int evszam = Console.readInt("�vsz�m: ");
    if (evszam < 0)
      System.out.println("Negat�v, nem j� �vsz�m!");
    else {
      if (evszam%17==0)
        System.out.println(evszam + " oszthat� 17-tel.");
      else
        System.out.println(evszam + " nem oszthat� 17-tel.");
    }
  }
}
