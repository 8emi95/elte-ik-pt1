/*
 * Mintaprogramok/19. fejezet
 * Compile.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import java.io.*;

public class Compile {
  String javacDir = "I:/JBuilder9/jdk1.4/bin"; // javac.exe könvvtára
  String classPath = "."; // CLASSPATH környezeti változó tartalma
  String actualDir =
      "C:/javaprog/_OOTPJava2/Mintaprogramok/19Hasznos/CiklusMero"; // a forráskód könyvtára
  String actualFileName = "CiklusMero.java"; // a forráskód neve

  public boolean compile() {
    boolean ok = false;
    String[] cmdarray = {javacDir+"/javac.exe", actualDir+"/"+actualFileName};
    String[] envp = {"CLASSPATH="+classPath};
    Runtime rt = Runtime.getRuntime();

    try {
      Process pr = rt.exec(cmdarray,envp);
      BufferedReader errors = new BufferedReader(new InputStreamReader(pr.getErrorStream()));
      String line;
      if ((line = errors.readLine()) == null) {
        System.out.println("A fordítás sikerült.");
        ok = true;
      }
      else {
        do {
          System.out.println(line);
        } while ((line = errors.readLine()) !=null);
      }
    }
    catch (Exception e) {
      System.out.println(e);
    }
    return ok;
  }

  public static void main(String[] args) {
    new Compile().compile();
  }
}