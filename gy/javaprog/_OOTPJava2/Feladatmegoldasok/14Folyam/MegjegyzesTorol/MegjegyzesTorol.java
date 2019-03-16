/*
 * Feladatmegold�sok/14. fejezet
 * MegjegyzesTorol.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
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
      // Addig megy, am�g a karOlvas met�dus EOFException kiv�telt nem dob:
      while (true) {
        kar1 = karOlvas();
        while (kar1 != '/') {
          dest.write(kar1);
          kar1 = karOlvas();
        }
        kar2 = karOlvas();

        // Ha sorv�gi megjegyz�s kezd�dik, akkor a sort v�gig beolvassuk,
        // de csak a sorv�gjelet �rjuk fel a dest-be:
        if (kar2=='/') {
          source.readLine();
          dest.write("\r\n");
        }
        // Ha hossz� megjegyz�s kezd�dik, akkor a megjegyz�s v�g�ig
        // beolvassuk a karaktereket, �s nem �runk semmit a dest-be:
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
          // Nem megjegyz�s:
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

  // A k�t f�jl megnyit�sa
  private void megnyit() {
    try {
      sourceFile = new File("work/Proba.java");
      destFile = new File("work/Temp.txt");
      source = new BufferedReader(new FileReader(sourceFile));
      dest = new FileWriter(destFile);
    }
    catch (FileNotFoundException ex) {
      System.out.println("Nincs ilyen f�jl: "+sourceFile);
      System.exit(0);
    }
    catch (IOException ex) {
      System.out.println("I/O hiba!");
    }
  }

  // A k�t f�jl bez�r�sa
  private void bezar() {
    try {
      source.close();
      dest.close();
    }
    catch (IOException ex) {
      System.out.println(ex);
    }
  }

  // Egy karakter olvas�sa.
  // F�jl v�g�n�l EOFException kiv�telt dob "mesters�gesen":
  int karOlvas() throws IOException, EOFException {
    int kar = source.read();
    if (kar == -1)
      throw new EOFException("F�jl v�ge!");
    return kar;
  }

  public static void main(String[] args) {
    new MegjegyzesTorol();
  }
}
