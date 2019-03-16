/*
 * Mintaprogramok/21. fejezet
 * TreeSetLotto.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

public class TreeSetLotto {
  public static void main(String[] args) {
    // A nyerok halmaz �ssze�ll�t�sa (kis elemsz�m eset�n):
    TreeSet nyerok = new TreeSet();                        //1
    nyerok.add(new Integer(5));
    nyerok.add(new Integer(13));
    nyerok.add(new Integer(33));
    nyerok.add(new Integer(34));
    nyerok.add(new Integer(35));

    // tipp �ssze�ll�t�sa az args t�mbb�l:
    TreeSet tipp = new TreeSet();                          //2
    try {
      for (int i=0; i<args.length; i++)
        tipp.add(new Integer(args[i]));
    }
    catch (NumberFormatException ex) {
      System.out.println("A param�ter nem eg�sz sz�m!");
      return;
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
      return;
    }

    System.out.println("Nyer�sz�mok: "+nyerok);           //3
    System.out.println("Tipp: "+tipp);
    TreeSet talalat = new TreeSet(nyerok);
    talalat.retainAll(tipp);
    System.out.println("Tal�latok sz�ma: "+talalat.size());
    System.out.println("Tal�latok: "+talalat);
  }
}
