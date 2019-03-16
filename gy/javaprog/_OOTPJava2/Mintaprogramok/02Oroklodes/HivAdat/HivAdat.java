/*
 * Mintaprogramok/2. fejezet
 * HivAdat.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

class C1 {
  static String s = "C1";
  int a = 5;
}

class C2 extends C1 {
  int b = 10;
  void kiir() { System.out.println(s+" "+a+" "+b); }
}

public class HivAdat {
  public static void main (String args[]) {
    C2 obj = new C2();
    obj.kiir();
  }
}

