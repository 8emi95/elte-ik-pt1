/*
 * Feladatmegold�sok/14. fejezet
 * TabToSpace.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;

public class TabToSpace {
  public static void main(String[] args) {
    if (args.length==0) {
      System.out.println("Nincs param�ter!");
      System.exit(0);
    }

    int n = 0;
    try {
      // n a TAB hely�re besz�rand� sz�k�z�k sz�ma:
      n = Integer.parseInt(args[0]);
    }
    catch (NumberFormatException ex) {
      System.out.println("A param�ter nem eg�sz sz�m!");
      System.exit(0);
    }

    // A forr�sf�jlt karakterenk�nt olvassuk, �s k�zben �runk egy �j f�jlt.
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
      // Sorban az �sszes mit karaktert kicser�lj�k a mire String-re.
      while (fr.ready()) {
        c = (char)fr.read();
        if (c == mit)
          fw.write(mire);
        else
          fw.write(c);
      }
      fr.close();
      fw.close();

      // source t�rl�se, dest �tnevez�se source-ra:
      source.delete();
      dest.renameTo(source);
    }
    catch (FileNotFoundException e) {
      System.out.println("Nem l�tezik a '"+source+"' �llom�ny!");
    }
    catch (IOException e) {
      System.out.println(e);
    }
  }
}
