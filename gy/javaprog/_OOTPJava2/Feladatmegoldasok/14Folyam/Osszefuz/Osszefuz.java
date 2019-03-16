/*
 * Feladatmegold�sok/14. fejezet
 * Osszefuz.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;

public class Osszefuz {
 public static void main (String args[]) {
   String fSource1Path = "c:/autoexec.bat";
   String fSource2Path = "c:/config.sys";
   String fDestPath = "c:/javaprog/work/autoconfig.txt";

   try {
     // F�jlok nyit�sa:
     FileInputStream fSource1 = new FileInputStream(fSource1Path);
     FileInputStream fSource2 = new FileInputStream(fSource2Path);
     FileOutputStream fDest = new FileOutputStream(fDestPath);

     int b;
     // Az autoexec.bat f�jl m�sol�sa a c�lf�jlba:
     while ((b = fSource1.read()) != -1) {
       fDest.write(b);
     }
     // A config.sys f�jl m�sol�sa a c�lf�jlba:
     while ((b = fSource2.read()) != -1) {
       fDest.write(b);
     }

     // �sszes f�jl lez�r�sa:
     fSource1.close();
     fSource2.close();
     fDest.close();
   }
   catch (FileNotFoundException ex) {
     System.out.println("Nem l�tezik mindk�t forr�s�llom�ny!");
   }
   catch (IOException e) {
     System.out.println(e.getMessage());
   }

   // Ellen�rizz�k, hogy a c�l hossza j�-e:
   long hossz1 = new File(fSource1Path).length();
   long hossz2 = new File(fSource2Path).length();
   long hossz3 = new File(fDestPath).length();
   if (hossz1+hossz2== hossz3)
     System.out.println("A hossz egyezik.");
    else
     System.out.println("A hossz nem egyezik!");

 } // main
} // Osszefuz
