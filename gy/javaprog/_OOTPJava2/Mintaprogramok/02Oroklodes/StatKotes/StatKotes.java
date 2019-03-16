/*
 * Mintaprogramok/2. fejezet
 * StatKotes.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

class C1 {
  void m1() { m2(); }
  static void m2() {
    System.out.println("C1.m2-ben vagyok!");
  }
}

class C2 extends C1 {
  static void m2() {
    System.out.println("C2.m2-ben vagyok!");
  }
}

public class StatKotes {
  public static void main (String args[]) {
    C1 obj1 = new C1();
    C2 obj2 = new C2();
    obj1.m2();   // -> C1.m2-ben vagyok!
    obj2.m2();   // -> C2.m2-ben vagyok!
    obj1.m1();   // -> C1.m2-ben vagyok!
    obj2.m1();   // -> C1.m2-ben vagyok!
  }
}
