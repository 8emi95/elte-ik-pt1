/*
 * Mintaprogramok/19. fejezet
 * RendszerJellemzok.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

public class RendszerJellemzok {
  public static void main(String[] args) {
    System.out.print("Java home konyvt�r: ");
    System.out.println(System.getProperty("java.home"));

    System.out.print("Haszn�l�: ");
    System.out.println(System.getProperty("user.name"));

    System.out.print("Oszt�ly�tvonal: ");
    System.out.println(System.getProperty("java.class.path"));

    System.out.println("\nAz �sszes rendszerjellemz�:");
    Properties prop = System.getProperties();
    StringTokenizer st = new StringTokenizer(prop.toString(),",");
    while (st.hasMoreTokens()) {
      System.out.println(st.nextToken());
    }


    // Rendszerjellemz�k csoportos�tva:

    // A JRE verzi�ja, sz�ll�t�ja, URL c�me, home k�nyvt�ra:
    System.out.println("-------------JRE adatai:");
    System.out.println(System.getProperty("java.version"));
    System.out.println(System.getProperty("java.vendor"));
    System.out.println(System.getProperty("java.vendor.url"));
    System.out.println(System.getProperty("java.home"));

    // A Java VM adatai:
    System.out.println("\n-------------Java VM adatai:");
    // 6 db

    // A Java specifik�ci� adatai:
    System.out.println("\n-------------Java specifik�ci� adatai:");
    // 3 db

    // java.ext.dirs?
    System.out.println("\n-------------java.ext.dirs:");
    System.out.println(System.getProperty("java.ext.dirs"));

    // A class form�tum verzi�ja �s a classpath:
    System.out.println("\n-------------A class form�tum verzi�ja �s a classpath: *****");
    System.out.println(System.getProperty("java.class.version"));
    System.out.println(System.getProperty("java.class.path"));

    // Szepar�torok:
    System.out.println("\n-------------Szepar�torok:");
    System.out.println(System.getProperty("file.separator"));
    System.out.println(System.getProperty("path.separator"));
    System.out.println(System.getProperty("line.separator"));

    // Az oper�ci�s rendszer neve, architekt�r�ja �s verzi�ja:
    System.out.println("\n-------------Oper�ci�s rendszer adatai:");
    System.out.println(System.getProperty("os.name"));
    System.out.println(System.getProperty("os.arch"));
    System.out.println(System.getProperty("os.version"));

    // A felhaszn�l� neve, home k�nyvt�ra �s az aktu�lis k�nyvt�r:
    System.out.println("\n-------------Felhaszn�l�i adatok:");
    System.out.println(System.getProperty("user.name"));
    System.out.println(System.getProperty("user.home"));
    System.out.println(System.getProperty("user.dir"));

  }
}
