/*
 * Mintaprogramok/18. fejezet
 * ProgParamTeszt.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

public class ProgParamTeszt {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("A programnak nincs paramétere.");
      System.exit(0);
    }

    System.out.println("\nParaméterek egyenként, külön sorban:");
    for (int i = 0; i < args.length; i++)
      System.out.println(args[i]);

    System.out.println("\nParaméterek vesszõvel elválasztva:");

    StringBuffer sor = new StringBuffer(args[0]);
    for (int i = 1; i < args.length; i++) {
      sor.append(", " + args[i]);
    }
    System.out.println(sor);
  }
}
