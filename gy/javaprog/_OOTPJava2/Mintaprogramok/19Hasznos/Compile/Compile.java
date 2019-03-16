/*
 * Mintaprogramok/19. fejezet
 * Compile.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

import java.io.*;

public class Compile {
  String javacDir = "I:/JBuilder9/jdk1.4/bin"; // javac.exe k�nvvt�ra
  String classPath = "."; // CLASSPATH k�rnyezeti v�ltoz� tartalma
  String actualDir =
      "C:/javaprog/_OOTPJava2/Mintaprogramok/19Hasznos/CiklusMero"; // a forr�sk�d k�nyvt�ra
  String actualFileName = "CiklusMero.java"; // a forr�sk�d neve

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
        System.out.println("A ford�t�s siker�lt.");
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