/*
 * Feladatmegoldások/17. fejezet
 * Complex1.java
 * (Angster Erzsébet és Seres Iván)
 *
 * A forráskód tartalma:
 * Complex osztály: komplex mûveletek
 * Complex1 osztály: tesztelés
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2003.01.01.
 */

class Complex {
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

// A komplex szám tesztelése:
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
    System.out.println("z1 abszolút értéke = " + z1.getAbs());
    System.out.println("z1 argumentuma = " + z1.getArg());
    System.out.println("z2 abszolút értéke = " + z2.getAbs());
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
    System.out.println("z1 és z2 szorzatának argumentuma = " + arg);
    System.out.println("z1 és z2 argumentumának összege = " + (arg1 + arg2));
    System.out.println("A kettõ különbsége (modulo 2-szer pi) = "
                        + ((arg - (arg1 + arg2)) % (2 * Math.PI)));
    System.out.println();

    z1 = new Complex(0, 0);
    System.out.println("z1 = " + z1);
    System.out.println("Mi történik, ha a nulla argumentumát kérdezzük?\n");
    System.out.println(z1.getArg());
  }
}
