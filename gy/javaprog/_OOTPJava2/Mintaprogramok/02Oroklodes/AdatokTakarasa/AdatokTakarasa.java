/*
 * Mintaprogramok/2. fejezet
 * AdatokTakarasa.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

class C1 {
  static String s = "C1 ";
  int a = 1;
  int b = 10;
}

class C2 extends C1 {
  int a = 2;
}

class C3 extends C2 {
  static String s = "C3 ";
  int b = 30;
  public void kiir1() { System.out.println(C1.s+C2.s+C3.s); }
  //public void kiir2() { System.out.println(C1.a+C2.a+C3.a); }
  public void kiir3() { System.out.println(super.a+a); }
  public void kiir4() { System.out.println(super.b+b); }
}

public class AdatokTakarasa {
  public static void main (String args[]) {
    new C3().kiir1();
    new C3().kiir3();
    new C3().kiir4();
  }
}

/* Output:
C1 C1 C3
4
40
*/

