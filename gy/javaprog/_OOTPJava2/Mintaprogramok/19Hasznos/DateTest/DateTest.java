/*
 * Mintaprogramok/19. fejezet
 * DateTest.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.Date;

public class DateTest {
  public static void main(String[] args) {
    Date d = new Date();                                   //1
    System.out.println("Pontos idõ: "+d.getTime()+", "+d); //2
    d.setTime(d.getTime()-2*60*60*1000);                   //3
    System.out.println("2 órával ezelõtt: "+
                         d.getTime()+", "+d);              //4
  }
}
