/* 
 * Feladatmegoldások/15. fejezet
 * Eljarasok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

public class Eljarasok {

  // a) feladat:
  static void parosSzamKiir(int alsoHatar, int felsoHatar) {
    if (alsoHatar > felsoHatar) {
      int seged=alsoHatar; alsoHatar=felsoHatar; felsoHatar=seged;
    }  
    if (alsoHatar%2==1)
      alsoHatar++;
    for (int i=alsoHatar; i<=felsoHatar; i+=2)
      System.out.print(i+" ");
    System.out.println();    
  }
  
  // b) feladat:
  static void sor(int hossz, char kar) {
    for (int i=0; i<hossz; i++)
      System.out.print(kar);
    System.out.println();    
  }
  
  // c) feladat:
  static void teglalap(int szel, int mag, char kar) {
    for (int i=0; i<mag; i++)
      sor(szel,kar);
  }
 
  public static void main (String args[]) {
    parosSzamKiir(11,30);           //a
    parosSzamKiir(30,11);           //a
    sor(30,(char)205);              //b
    teglalap(11,3,'@');             //c
  }
}
