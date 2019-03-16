/*
 * Feladatmegold�sok/19. fejezet
 * MelyikEvHoNap.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

public class MelyikEvHoNap {
  public static void main(String[] args) {
    GregorianCalendar c = new GregorianCalendar();
    c.setTime(new Date(106836795488L));
    System.out.println(c.get(Calendar.YEAR)+". "+
      (c.get(Calendar.MONTH)+1)+". "+c.get(Calendar.DAY_OF_MONTH)+".");
  }
}
