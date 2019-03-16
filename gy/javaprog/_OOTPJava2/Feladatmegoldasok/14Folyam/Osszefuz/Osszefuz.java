/*
 * Feladatmegoldások/14. fejezet
 * Osszefuz.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class Osszefuz {
 public static void main (String args[]) {
   String fSource1Path = "c:/autoexec.bat";
   String fSource2Path = "c:/config.sys";
   String fDestPath = "c:/javaprog/work/autoconfig.txt";

   try {
     // Fájlok nyitása:
     FileInputStream fSource1 = new FileInputStream(fSource1Path);
     FileInputStream fSource2 = new FileInputStream(fSource2Path);
     FileOutputStream fDest = new FileOutputStream(fDestPath);

     int b;
     // Az autoexec.bat fájl másolása a célfájlba:
     while ((b = fSource1.read()) != -1) {
       fDest.write(b);
     }
     // A config.sys fájl másolása a célfájlba:
     while ((b = fSource2.read()) != -1) {
       fDest.write(b);
     }

     // Összes fájl lezárása:
     fSource1.close();
     fSource2.close();
     fDest.close();
   }
   catch (FileNotFoundException ex) {
     System.out.println("Nem létezik mindkét forrásállomány!");
   }
   catch (IOException e) {
     System.out.println(e.getMessage());
   }

   // Ellenõrizzük, hogy a cél hossza jó-e:
   long hossz1 = new File(fSource1Path).length();
   long hossz2 = new File(fSource2Path).length();
   long hossz3 = new File(fDestPath).length();
   if (hossz1+hossz2== hossz3)
     System.out.println("A hossz egyezik.");
    else
     System.out.println("A hossz nem egyezik!");

 } // main
} // Osszefuz
