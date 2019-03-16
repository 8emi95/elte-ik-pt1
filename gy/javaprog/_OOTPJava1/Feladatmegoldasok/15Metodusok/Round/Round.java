/*
 * Feladatmegold�sok/15. fejezet
 * Round.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

public class Round {

  public static int round(float a) {
    return (int)Math.floor(a + 0.5F);
  }

  public static long round(double a) {
    return (long)Math.floor(a + 0.5D);
  }

  public static void main (String args[]) {
    final float SZAM = -4.25F;
    System.out.println(SZAM+" kerek�tve szerintem: "+round(SZAM));
    System.out.println(SZAM+" kerek�tve Math szerint: "+Math.round(SZAM));
  }
}
