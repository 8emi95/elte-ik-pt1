/*
 * Mintaprogramok/18. fejezet
 * ProgParamTeszt.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

public class ProgParamTeszt {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("A programnak nincs param�tere.");
      System.exit(0);
    }

    System.out.println("\nParam�terek egyenk�nt, k�l�n sorban:");
    for (int i = 0; i < args.length; i++)
      System.out.println(args[i]);

    System.out.println("\nParam�terek vessz�vel elv�lasztva:");

    StringBuffer sor = new StringBuffer(args[0]);
    for (int i = 1; i < args.length; i++) {
      sor.append(", " + args[i]);
    }
    System.out.println(sor);
  }
}
