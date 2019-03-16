/*
 * javalib k�nyvt�r
 *
 * Csomag: extra.math
 * Complex.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2003.01.01.
 */

package extra.math;

public class Complex {
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
