/*
 * Feladatmegold�sok/17. fejezet
 * Complex2.java
 * (Angster Erzs�bet �s Seres Iv�n)
 *
 * A Complex oszt�lyt betett�k az extra.math csomagba
 * Complex2 oszt�ly: tesztel�s
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2003.01.01.
 */

import extra.math.Complex;

class Complex2 {
  public static void main(String[] args) {
    Complex z1 = new Complex(2, 0);
    Complex z2 = new Complex(0, 3);

    System.out.println("z1 = " + z1);
    System.out.println("z2 = " + z2);
    System.out.println();

    System.out.println("z1 + z2 = " + z1.add(z2));
    System.out.println("z1 * z2 = " + z1.multiply(z2));
    System.out.println("z1 / z2 = " + z1.divide(z2));
    System.out.println();

    System.out.println("z1 megegyezik z2-vel? "
                           + ((z1.equals(z2)) ? "igen" : "nem"));
    System.out.println("z1 abszol�t �rt�ke = " + z1.getAbs());
    System.out.println("z1 argumentuma = " + z1.getArg());
    System.out.println("z2 abszol�t �rt�ke = " + z2.getAbs());
    System.out.println("z2 argumentuma = " + z2.getArg());
    System.out.println();

    z1 = new Complex(1, 1);
    z2 = new Complex(1, -1);
    double arg1 = z1.getArg();
    double arg2 = z2.getArg();
    double arg = z1.multiply(z2).getArg();
    System.out.println("z1 = " + z1);
    System.out.println("z2 = " + z2);
    System.out.println("z1 argumentuma = " + arg1);
    System.out.println("z2 argumentuma = " + arg2);
    System.out.println("z1 �s z2 szorzat�nak argumentuma = " + arg);
    System.out.println("z1 �s z2 argumentum�nak �sszege = " + (arg1 + arg2));
    System.out.println("A kett� k�l�nbs�ge (modulo 2-szer pi) = "
                        + ((arg - (arg1 + arg2)) % (2 * Math.PI)));
    System.out.println();

    z1 = new Complex(0, 0);
    System.out.println("z1 = " + z1);
    System.out.println("Mi t�rt�nik, ha a nulla argumentum�t k�rdezz�k?\n");
    System.out.println(z1.getArg());
  }
}
