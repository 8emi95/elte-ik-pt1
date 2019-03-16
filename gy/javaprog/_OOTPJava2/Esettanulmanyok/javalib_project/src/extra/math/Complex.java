/*
 * javalib könyvtár
 *
 * Csomag: extra.math
 * Complex.java

 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2003.01.01.
 */

package extra.math;

public class Complex {
  private double re; // a komplex szám valós része
  private double im; // a komplex szám képzetes része

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

  // Konjugált:
  public Complex conj() {
    return new Complex(re, -im);
  }

  // Abszolút négyzet:
  public double absSquare() {
    return re * re + im * im;
  }

  // Abszolút érték:
  public double getAbs() {
    return Math.sqrt(absSquare());
  }

  // Argumentum:
  public double getArg() throws ArithmeticException {
    if (this.absSquare() == 0)
      throw new ArithmeticException("\nA nulla argumentuma nincs értelmezve!");
    double x = re / getAbs();
    double y = im / getAbs();
    return (y >= 0) ? Math.acos(x) : 2 * Math.PI - Math.acos(x);
  }

  public void setAbsAndArg(double abs, double arg) throws ArithmeticException {
    if (abs == 0)
      throw new ArithmeticException("\nA nullához nem rendelhetõ argumentum!");
    this.re = abs * Math.cos(arg);
    this.im = abs * Math.sin(arg);
  }

  // Összeadás. A c komplex szám hozzáadása this-hez:
  public Complex add(Complex c) {
    return new Complex(re + c.re, im + c.im);
  }

  // Kivonás. A c komplex szám kivonása this-bõl:
  public Complex subtract(Complex c) {
    return new Complex(re - c.re, im - c.im);
  }

  // Szorzás. A this megszorzása c valós számmal:
  public Complex multiply(double c) {
    return multiply(new Complex(c, 0));
  }

  // Szorzás. A this megszorzása c komplex számmal:
  public Complex multiply(Complex c) {
    return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
  }

  // Osztás. A this osztása c komplex számmal:
  public Complex divide(Complex c) throws ArithmeticException {
    if (this.absSquare() == 0)
      throw new ArithmeticException("\nA nullával való osztás nincs értelmezve!");
    return (multiply(c.conj())).multiply(1 / c.absSquare());
  }

  // Szöveges megjelenés:
  public String toString() {
    return re + " + " + im + " * i";
  }

  // Egyenlõség:
  public boolean equals(Object obj) {
    return ((re == ((Complex) obj).re) && (im == ((Complex) obj).im));
  }
}
