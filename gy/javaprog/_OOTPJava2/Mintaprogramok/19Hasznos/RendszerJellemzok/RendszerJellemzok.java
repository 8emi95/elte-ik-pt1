/*
 * Mintaprogramok/19. fejezet
 * RendszerJellemzok.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

public class RendszerJellemzok {
  public static void main(String[] args) {
    System.out.print("Java home konyvtár: ");
    System.out.println(System.getProperty("java.home"));

    System.out.print("Használó: ");
    System.out.println(System.getProperty("user.name"));

    System.out.print("Osztályútvonal: ");
    System.out.println(System.getProperty("java.class.path"));

    System.out.println("\nAz összes rendszerjellemzõ:");
    Properties prop = System.getProperties();
    StringTokenizer st = new StringTokenizer(prop.toString(),",");
    while (st.hasMoreTokens()) {
      System.out.println(st.nextToken());
    }


    // Rendszerjellemzõk csoportosítva:

    // A JRE verziója, szállítója, URL címe, home könyvtára:
    System.out.println("-------------JRE adatai:");
    System.out.println(System.getProperty("java.version"));
    System.out.println(System.getProperty("java.vendor"));
    System.out.println(System.getProperty("java.vendor.url"));
    System.out.println(System.getProperty("java.home"));

    // A Java VM adatai:
    System.out.println("\n-------------Java VM adatai:");
    // 6 db

    // A Java specifikáció adatai:
    System.out.println("\n-------------Java specifikáció adatai:");
    // 3 db

    // java.ext.dirs?
    System.out.println("\n-------------java.ext.dirs:");
    System.out.println(System.getProperty("java.ext.dirs"));

    // A class formátum verziója és a classpath:
    System.out.println("\n-------------A class formátum verziója és a classpath: *****");
    System.out.println(System.getProperty("java.class.version"));
    System.out.println(System.getProperty("java.class.path"));

    // Szeparátorok:
    System.out.println("\n-------------Szeparátorok:");
    System.out.println(System.getProperty("file.separator"));
    System.out.println(System.getProperty("path.separator"));
    System.out.println(System.getProperty("line.separator"));

    // Az operációs rendszer neve, architektúrája és verziója:
    System.out.println("\n-------------Operációs rendszer adatai:");
    System.out.println(System.getProperty("os.name"));
    System.out.println(System.getProperty("os.arch"));
    System.out.println(System.getProperty("os.version"));

    // A felhasználó neve, home könyvtára és az aktuális könyvtár:
    System.out.println("\n-------------Felhasználói adatok:");
    System.out.println(System.getProperty("user.name"));
    System.out.println(System.getProperty("user.home"));
    System.out.println(System.getProperty("user.dir"));

  }
}
