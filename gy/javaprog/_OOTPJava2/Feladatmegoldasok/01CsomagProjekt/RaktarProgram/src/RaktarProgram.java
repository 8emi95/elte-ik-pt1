/*
 * Feladatmegoldások/1. fejezet
 * Projekt: RaktarProgram
 * RaktarProgram.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

public class RaktarProgram {                          //14
  private Aru aru;                                    //15

  public RaktarProgram() {                            //16
    aru = new Aru("Paradicsom",300);                  //17
  }

  public void akciok() {                              //18
    aru.hozzatesz(125);                               //19
    System.out.println(aru);                          //20
    aru.elvesz(25);                                   //21
    System.out.println(aru);                          //22
    aru.setEgysegar(210);                             //23
    System.out.println(aru);                          //24
  }

  public static void main(String[] args) {            //25
    RaktarProgram program = new RaktarProgram();      //26
    program.akciok();                                 //27
  }
}
