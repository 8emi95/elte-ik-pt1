/*
 * Mintaprogramok/3. fejezet
 * UdvarApp.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.util.*;

class Udvar {
  private int szel=100, hossz=50;
  private Vector oszlopok = new Vector();

  public Udvar() {                                         //1
    oszlopok.add(new Oszlop(25,30));
    oszlopok.add(new Oszlop(40,5));
    oszlopok.add(new Oszlop(97,10));
  }

  class Oszlop {                                           //2
    private int x, y; // az oszlop helye az udvaron
    private int szel=5; // az oszlop szélessége

    public Oszlop(int x, int y) {
      if (x>=0 && x<=Udvar.this.szel-szel &&
          y>=0 && y<=hossz-szel) {                         //3
        this.x = x; this.y = y;                            //4
      }
      else {
        this.x = 0; this.y = 0;
      }
    }
    public String toString() {
      return x+"-"+y;
    }
  }

  public String toString() {                               //5
    return "Udvar:"+szel+"x"+hossz+", Oszlopok:"+oszlopok;
  }
}

public class UdvarApp {
  public static void main(String[] args) {
    Udvar udvar = new Udvar();
    System.out.println(udvar);                             //6
  }
}
