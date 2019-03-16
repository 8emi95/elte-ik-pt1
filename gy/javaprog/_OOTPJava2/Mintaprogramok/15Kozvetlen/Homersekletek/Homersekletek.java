/*
 * Mintaprogramok/15. fejezet
 * Homersekletek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;
import extra.*;

public class Homersekletek {

  static void felvisz() {
    try {
      DataOutputStream havihom = new DataOutputStream(
        new FileOutputStream("work/HaviHomers.dat"));      //1
      for (int i=0; i<31; i++) {                           //2
        double hom = (int)(Math.random()*100)/10.0+10;
        havihom.writeDouble(hom);
      }
      havihom.close();
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }

  static void kerdez() {
    try {
      RandomAccessFile havihom =
         new RandomAccessFile("work/HaviHomers.dat","r");  //3

      System.out.println("Hõmérsékletek a hónapban");      //4
      int i=0;
      double osszeg = 0;
      try {
        while (true) {
          double hom = havihom.readDouble();
          i++;
          osszeg += hom;
          if (i%8==0) System.out.println();
          System.out.print(i+": "+hom+"\t");
        }
      }
      catch (EOFException ex) {
        System.out.println("\nÁtlaghõmerséklet 2 tizedesre: "+
                      ((int)(osszeg/31*100)/100.0));
      }

      System.out.println("\n\nKérdezzen 0 végjelig!");
      long poz;
      while ((poz = Console.readInt("\nNap: ")) != 0) {
        try {
          havihom.seek(8*(poz-1));                         //5
          System.out.println(havihom.readDouble());
        }
        catch (IOException e) {
          System.out.println("Nem jó nap!");
        }
      }
      havihom.close();
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }

  public static void main(String[] args) {
    felvisz();
    kerdez();
  }
}

/*
//4-tõl az olvasás így egyszerûbb lenne, csak akkor nem lenne példa az EOFException-re:
for (int i=0; i<havihom.length()/8; i++) {
  if (i%8==0) System.out.println();
  System.out.print(i+1+": "+
      havihom.readDouble()+"\t");
}
*/
