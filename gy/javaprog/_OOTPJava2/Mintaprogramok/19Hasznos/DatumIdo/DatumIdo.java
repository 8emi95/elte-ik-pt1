/*
 * Mintaprogramok/19. fejezet
 * DatumIdo.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.GregorianCalendar;
import java.util.Calendar;

public class DatumIdo {
  static void printCalendar(Calendar c) {
    System.out.println("Dátum: "+c.get(Calendar.YEAR)+"."+
           (c.get(Calendar.MONTH)+1)+"."+
           c.get(Calendar.DAY_OF_MONTH)+".");

    System.out.println("Az év "+
           c.get(Calendar.DAY_OF_YEAR)+". napja");
    System.out.println("Az év "+
           c.get(Calendar.WEEK_OF_YEAR)+". hete");

    System.out.print("Idõpont: "+
           c.get(Calendar.HOUR_OF_DAY)+":"+
           c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND));

    System.out.println(c.get(Calendar.AM_PM)==Calendar.PM?
           " Délután":" Délelõtt");
  }

  public static void main(String[] args) {
    GregorianCalendar naptar = new GregorianCalendar();

    System.out.println("Pontos idõ:");
    printCalendar(naptar);

    // Elõbbre igazítjuk az órát:
    naptar.add(Calendar.MINUTE,10);
    naptar.add(Calendar.SECOND,22);

    System.out.println("\n10 perc és 22 másodperccel késõbb:");
    printCalendar(naptar);
  }
}
