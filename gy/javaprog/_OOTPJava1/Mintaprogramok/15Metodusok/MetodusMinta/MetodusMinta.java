/*
 * Mintaprogramok/15. fejezet
 * MetodusMinta.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

public class MetodusMinta {                             //1

  public static void main(String[] args) {              //2
    vonalhuz();                                         //3
    int szam;                                           //4

    while ((szam=Console.readInt("Szám: ")) != 0) {     //5
      System.out.println("Jegyek száma: "+
        jegyekSzama(szam));                             //6
      vonalhuz();                                       //7
    }                                                   //8
    vonalhuz();                                         //9
  }                                                     //10

  static void vonalhuz() {                              //11
    for (int i=1; i<=20; i++)                           //12
      System.out.print('-');                            //13
    System.out.println();                               //14
  }                                                     //15

  static int jegyekSzama(int n) {                       //16
    int result = 0;                                     //17
    do {                                                //18
      n /= 10;                                          //19
      result++;                                         //20
    } while (n !=0);                                    //21
    return result;                                      //22
  }                                                     //23
}                                                       //24
