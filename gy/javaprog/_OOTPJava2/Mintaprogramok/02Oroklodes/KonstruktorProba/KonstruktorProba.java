/*
 * Mintaprogramok/2. fejezet
 * KonstruktorProba.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

class C1 {
  C1(int a) {}                                        //1
}

class C2 extends C1 {
  C2(int a, int b) {super(a);}                        //2
  C2(int a) {this(a,1);}                              //3
  C2() {this(2);}                                     //4
}

class C3 extends C2 {
  C3(int a, int b) {}                                 //5
  C3(int a) {this(a,3);}                              //6
}

class C4 extends C3 {
  int a;
  C4(int a) {super(a);}
//C4() {super();}                 // hiba: C3-ban nincs C3()
//C4() {}                         // hiba: C3-ban nincs C3()
//C4() {a=1; super(a)}            // hiba! super nem elsõ
//C4() {this(); super(5);}        // hiba! Kettõ nem lehet!
}

public class KonstruktorProba {
  public static void main (String args[]) {
    new C3(1);                                        //7
    // ...
  } // main
}
