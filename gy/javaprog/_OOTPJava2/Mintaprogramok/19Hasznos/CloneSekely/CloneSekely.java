/*
 * Mintaprogramok/19. fejezet
 * CloneSekely.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

// A kl�nozhat� oszt�ly:
class Gyerek implements Cloneable {                        //1
  int magassag=120, suly=35;
  boolean jo=true;

  public Object clone() throws CloneNotSupportedException {//2
    return super.clone();                                  //3
  }

  public String toString() {
    return magassag+" "+suly+" "+(jo?"J�":"Rossz");
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
      System.out.println("M�solt : "+masolt);
    else
      System.out.println("A gyerek nem kl�nozhato, vagy "+
        "nem �rdemes kl�nozni");
  }
}
