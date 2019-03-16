/*
 * Feladatmegold�sok/17. fejezet
 * Complex1.java
 * (Angster Erzs�bet �s Seres Iv�n)
 *
 * A forr�sk�d tartalma:
 * Complex oszt�ly: komplex m�veletek
 * Complex1 oszt�ly: tesztel�s
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2003.01.01.
 */

class Complex {
  private double re; // a komplex sz�m val�s r�sze
  private double im; // a komplex sz�m k�pzetes r�sze

  public Complex(double re, double im) {
    this.re = re;
    this.im = im;
  }

  public double getRe() {
    return re;
  }

  public double getIm() {
    return im;
  }

  public void setRe(double re) {
    this.re = re;
  }

  public void setIm(double im) {
    this.im = im;
  }

  // Konjug�lt:
  public Complex conj() {
    return new Complex(re, -im);
  }

  // Abszol�t n�gyzet:
  public double absSquare() {
    return re * re + im * im;
  }

  // Abszol�t �rt�k:
  public double getAbs() {
    return Math.sqrt(absSquare());
  }

  // Argumentum:
  public double getArg() throws ArithmeticException {
    if (this.absSquare() == 0)
      throw new ArithmeticException("\nA nulla argumentuma nincs �rtelmezve!");
    double x = re / getAbs();
    double y = im / getAbs();
    return (y >= 0) ? Math.acos(x) : 2 * Math.PI - Math.acos(x);
  }

  public void setAbsAndArg(double abs, double arg) throws ArithmeticException {
    if (abs == 0)
      throw new ArithmeticException("\nA null�hoz nem rendelhet� argumentum!");
    this.re = abs * Math.cos(arg);
    this.im = abs * Math.sin(arg);
  }

  // �sszead�s. A c komplex sz�m hozz�ad�sa this-hez:
  public Complex add(Complex c) {
    return new Complex(re + c.re, im + c.im);
  }

  // Kivon�s. A c komplex sz�m kivon�sa this-b�l:
  public Complex subtract(Complex c) {
    return new Complex(re - c.re, im - c.im);
  }

  // Szorz�s. A this megszorz�sa c val�s sz�mmal:
  public Complex multiply(double c) {
    return multiply(new Complex(c, 0));
  }

  // Szorz�s. A this megszorz�sa c komplex sz�mmal:
  public Complex multiply(Complex c) {
    return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
  }

  // Oszt�s. A this oszt�sa c komplex sz�mmal:
  public Complex divide(Complex c) throws ArithmeticException {
    if (this.absSquare() == 0)
      throw new ArithmeticException("\nA null�val val� oszt�s nincs �rtelmezve!");
    return (multiply(c.conj())).multiply(1 / c.absSquare());
  }

  // Sz�veges megjelen�s:
  public String toString() {
    return re + " + " + im + " * i";
  }

  // Egyenl�s�g:
  public boolean equals(Object obj) {
    return ((re == ((Complex) obj).re) && (im == ((Complex) obj).im));
  }
}

// A komplex sz�m tesztel�se:
public class Complex1 {
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
