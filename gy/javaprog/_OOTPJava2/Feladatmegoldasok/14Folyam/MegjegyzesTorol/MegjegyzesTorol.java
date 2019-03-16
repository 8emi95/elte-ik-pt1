/*
 * Feladatmegoldások/14. fejezet
 * MegjegyzesTorol.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class MegjegyzesTorol {
  private File sourceFile, destFile;
  private BufferedReader source = null;
  private FileWriter dest = null;

  public MegjegyzesTorol() {
    megnyit();
    int kar1, kar2;
    boolean megjVege = false;
    try {
      // Addig megy, amíg a karOlvas metódus EOFException kivételt nem dob:
      while (true) {
        kar1 = karOlvas();
        while (kar1 != '/') {
          dest.write(kar1);
          kar1 = karOlvas();
        }
        kar2 = karOlvas();

        // Ha sorvégi megjegyzés kezdõdik, akkor a sort végig beolvassuk,
        // de csak a sorvégjelet írjuk fel a dest-be:
        if (kar2=='/') {
          source.readLine();
          dest.write("\r\n");
        }
        // Ha hosszú megjegyzés kezdõdik, akkor a megjegyzés végéig
        // beolvassuk a karaktereket, és nem írunk semmit a dest-be:
        else if (kar2=='*') {
          megjVege = false;
          while (!megjVege) {
            do {
              kar1 = karOlvas();
            } while (kar1!='*');
            kar2 = karOlvas();
            megjVege = kar2 == '/';
          }
        }
        else {
          // Nem megjegyzés:
          dest.write(kar1);
          dest.write(kar2);
        }
      } // while true
    } // try
    catch (EOFException ex) {
      bezar();
      sourceFile.delete();
      destFile.renameTo(sourceFile);
    }
    catch (IOException ex) {
      System.out.println("I/O hiba!");
    }
  } // MegjegyzesTorol konstruktor

  // A két fájl megnyitása
  private void megnyit() {
    try {
      sourceFile = new File("work/Proba.java");
      destFile = new File("work/Temp.txt");
      source = new BufferedReader(new FileReader(sourceFile));
      dest = new FileWriter(destFile);
    }
    catch (FileNotFoundException ex) {
      System.out.println("Nincs ilyen fájl: "+sourceFile);
      System.exit(0);
    }
    catch (IOException ex) {
      System.out.println("I/O hiba!");
    }
  }

  // A két fájl bezárása
  private void bezar() {
    try {
      source.close();
      dest.close();
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }

  // Egy karakter olvasása.
  // Fájl végénél EOFException kivételt dob "mesterségesen":
  int karOlvas() throws IOException, EOFException {
    int kar = source.read();
    if (kar == -1)
      throw new EOFException("Fájl vége!");
    return kar;
  }

  public static void main(String[] args) {
    new MegjegyzesTorol();
  }
}
