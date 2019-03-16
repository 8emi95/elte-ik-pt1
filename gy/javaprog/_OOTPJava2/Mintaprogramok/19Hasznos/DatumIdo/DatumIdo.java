/*
 * Mintaprogramok/19. fejezet
 * DatumIdo.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.GregorianCalendar;
import java.util.Calendar;

public class DatumIdo {
  static void printCalendar(Calendar c) {
    System.out.println("D�tum: "+c.get(Calendar.YEAR)+"."+
           (c.get(Calendar.MONTH)+1)+"."+
           c.get(Calendar.DAY_OF_MONTH)+".");

    System.out.println("Az �v "+
           c.get(Calendar.DAY_OF_YEAR)+". napja");
    System.out.println("Az �v "+
           c.get(Calendar.WEEK_OF_YEAR)+". hete");

    System.out.print("Id�pont: "+
           c.get(Calendar.HOUR_OF_DAY)+":"+
           c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND));

    System.out.println(c.get(Calendar.AM_PM)==Calendar.PM?
           " D�lut�n":" D�lel�tt");
  }

  public static void main(String[] args) {
    GregorianCalendar naptar = new GregorianCalendar();

    System.out.println("Pontos id�:");
    printCalendar(naptar);

    // El�bbre igaz�tjuk az �r�t:
    naptar.add(Calendar.MINUTE,10);
    naptar.add(Calendar.SECOND,22);

    System.out.println("\n10 perc �s 22 m�sodperccel k�s�bb:");
    printCalendar(naptar);
  }
}
