/* 
 * Mintaprogramok/16. fejezet
 * ObjektumParameter.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

public class ObjektumParameter {

  static void szethuz(StringBuffer str) {
    for (int i=str.length()-1; i>0; i--)
      str.insert(i,' ');
    str = null;
  }

  public static void main(String[] args) {
    StringBuffer sb = new StringBuffer("Peace");
    szethuz(sb);              // sb = "P e a c e"
    System.out.println("*"+sb+"*");
  }
}

