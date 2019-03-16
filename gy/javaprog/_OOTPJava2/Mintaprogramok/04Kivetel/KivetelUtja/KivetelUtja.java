// KivetelUtja.java                                //1
class Masik {                                      //2
  static void m2() {                               //3
    throw new RuntimeException("Rosszalkodas");    //4
  }                                                //5
}                                                  //6
                                                   //7
public class KivetelUtja {                         //8
  static void m1() {                               //9
    Masik.m2();                                    //10
  }                                                //11
  public static void main(String[] args) {         //12
    m1();                                          //13
  }                                                //14
}                                                  //15

/*
java.lang.RuntimeException: Rosszalkodas
        at Masik.m2(KivetelUtja.java:4)
        at KivetelUtja.m1(KivetelUtja.java:10)
        at KivetelUtja.main(KivetelUtja.java:13)
Exception in thread "main"
*/


/*
 * Azért van ez a végén, mert elrontaná a sorszámozást.
 *
 * Mintaprogramok/4. fejezet
 * KivetelUtja.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */
