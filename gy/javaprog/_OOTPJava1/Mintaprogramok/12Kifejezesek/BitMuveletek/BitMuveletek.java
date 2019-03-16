/*
 * Mintaprogramok/12. fejezet
 * BitMuveletek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

public class BitMuveletek {
  public static void main(String[] args) {
    int b=124;  // b=124 (01111100)
    System.out.println("~b   ="+~b);     // ~b   =-125(10000011)
    System.out.println("b|1  ="+(b|1));  // b|1  =125 (01111101)
    System.out.println("b&4  ="+(b&4));  // b&4  =4   (00000100)
    System.out.println("b^2  ="+(b^2));  // b^2  =126 (01111110)
    System.out.println("b<<1 ="+(b<<1)); // b<<1 =248 (11111000)
    System.out.println("b>>1 ="+(b>>1)); // b>>1 =62  (00111110)
    System.out.println("b>>>3="+(b>>>3));// b>>>3=15  (00001111)
  }
}
