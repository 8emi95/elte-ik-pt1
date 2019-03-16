/*
 * Mintaprogramok/19. fejezet
 * CloneSekely.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

// A klónozható osztály:
class Gyerek implements Cloneable {                        //1
  int magassag=120, suly=35;
  boolean jo=true;

  public Object clone() throws CloneNotSupportedException {//2
    return super.clone();                                  //3
  }

  public String toString() {
    return magassag+" "+suly+" "+(jo?"Jó":"Rossz");
  }
}

public class CloneSekely {
  public static void main (String args[]) throws
                               CloneNotSupportedException {
    Gyerek eredeti = new Gyerek();
    Gyerek masolt = null;

    if (eredeti instanceof Cloneable && eredeti.jo)        //4
      masolt = (Gyerek)eredeti.clone();                    //5

    System.out.println("Eredeti: "+eredeti);
    if (masolt!=null)
      System.out.println("Másolt : "+masolt);
    else
      System.out.println("A gyerek nem klónozhato, vagy "+
        "nem érdemes klónozni");
  }
}
