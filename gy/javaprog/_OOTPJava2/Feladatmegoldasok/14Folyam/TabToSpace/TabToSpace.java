/*
 * Feladatmegoldások/14. fejezet
 * TabToSpace.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;

public class TabToSpace {
  public static void main(String[] args) {
    if (args.length==0) {
      System.out.println("Nincs paraméter!");
      System.exit(0);
    }

    int n = 0;
    try {
      // n a TAB helyére beszúrandó szóközök száma:
      n = Integer.parseInt(args[0]);
    }
    catch (NumberFormatException ex) {
      System.out.println("A paraméter nem egész szám!");
      System.exit(0);
    }

    // A forrásfájlt karakterenként olvassuk, és közben írunk egy új fájlt.
    File source = new File("work/Szoveg.txt");
    File dest = new File("work/Temp.txt");
    char mit = '\t';
    String mire = "";
    for (int i = 0; i < n; i++)
      mire = mire + " ";

    FileReader fr = null;
    FileWriter fw = null;
    try {
      fr = new FileReader(source);
      fw = new FileWriter(dest);
      char c;
      // Sorban az összes mit karaktert kicseréljük a mire String-re.
      while (fr.ready()) {
        c = (char)fr.read();
        if (c == mit)
          fw.write(mire);
        else
          fw.write(c);
      }
      fr.close();
      fw.close();

      // source törlése, dest átnevezése source-ra:
      source.delete();
      dest.renameTo(source);
    }
    catch (FileNotFoundException e) {
      System.out.println("Nem létezik a '"+source+"' állomány!");
    }
    catch (IOException e) {
      System.out.println(e);
    }
  }
}
