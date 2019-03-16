/*
 * Mintaprogramok/16. fejezet
 * Csere.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class Csere {
  public static void main(String[] args) {
    StringBuffer szoveg =
      new StringBuffer(Console.readLine("Szöveg: "));   //1
    int poz = szoveg.toString().indexOf('&');           //2
    while (poz!=-1) {
      szoveg.replace(poz,poz+1,"and");                  //3
      poz = szoveg.toString().indexOf('&');             //4
    }
    System.out.println(szoveg);                         //5
  }
}
