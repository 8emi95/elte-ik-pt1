/* 
 * Mintaprogramok/11. fejezet
 * LongToFloat.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */
 
public class LongToFloat {
  public static void main(String[] args) {
     long lon = 1234567890123456789L;
     float f;
     f = lon;
     System.out.println(f);    // 1.234567894E18
  }
}
