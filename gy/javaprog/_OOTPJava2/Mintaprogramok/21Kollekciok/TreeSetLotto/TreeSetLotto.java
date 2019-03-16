/*
 * Mintaprogramok/21. fejezet
 * TreeSetLotto.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

public class TreeSetLotto {
  public static void main(String[] args) {
    // A nyerok halmaz összeállítása (kis elemszám esetén):
    TreeSet nyerok = new TreeSet();                        //1
    nyerok.add(new Integer(5));
    nyerok.add(new Integer(13));
    nyerok.add(new Integer(33));
    nyerok.add(new Integer(34));
    nyerok.add(new Integer(35));

    // tipp összeállítása az args tömbbõl:
    TreeSet tipp = new TreeSet();                          //2
    try {
      for (int i=0; i<args.length; i++)
        tipp.add(new Integer(args[i]));
    }
    catch (NumberFormatException ex) {
      System.out.println("A paraméter nem egész szám!");
      return;
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
      return;
    }

    System.out.println("Nyerõszámok: "+nyerok);           //3
    System.out.println("Tipp: "+tipp);
    TreeSet talalat = new TreeSet(nyerok);
    talalat.retainAll(tipp);
    System.out.println("Találatok száma: "+talalat.size());
    System.out.println("Találatok: "+talalat);
  }
}
