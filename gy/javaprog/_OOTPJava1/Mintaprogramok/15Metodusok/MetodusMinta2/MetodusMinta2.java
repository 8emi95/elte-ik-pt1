/*
 * Mintaprogramok/15. fejezet
 * MetodusMinta2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class MetodusMinta2 {

  static void vonalhuz() {
    vonalhuz(20,'-');
  }

  static void vonalhuz(int hossz) {
    vonalhuz(hossz,'-');
  }

  static void vonalhuz(int hossz, char ch) {
    for (int i=1; i<=hossz; i++)
      System.out.print(ch);
    System.out.println();
  }

  static int jegyekSzama(int n) {
    int result = 0;
    do {
      n /= 10;
      result++;
    } while (n !=0);
    return result;
  }

  public static void main(String[] args) {
    vonalhuz(50,'@');
    final int szam;
    while ((szam=Console.readInt("Sz�m: ")) != 0) {
      System.out.println("Jegyek sz�ma: "+jegyekSzama(szam));
      vonalhuz();
    }
    vonalhuz(50,'\u0002');  // nevet� fejecsk�k
  }
}

