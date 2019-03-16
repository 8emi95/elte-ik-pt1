/*
 * Mintaprogramok/3. fejezet
 * UdvarApp2.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.util.*;

class Oszlop {
  private int x, y; // az oszlop helye az udvaron
  private int szel=5; // az oszlop sz�less�ge

  public Oszlop(Udvar udvar,int x, int y) {
    if (x>=0 && x<=udvar.szel-szel &&
        y>=0 && y<=udvar.hossz-szel) {
      this.x = x; this.y = y;
    }
    else {
      this.x = 0; this.y = 0;
    }
  }
  public String toString() {
    return x+"-"+y;
  }
}

class Udvar {
  int szel=100, hossz=50;
  private Vector oszlopok = new Vector();

  public Udvar() {
    oszlopok.add(new Oszlop(this,25,30));
    oszlopok.add(new Oszlop(this,40,5));
    oszlopok.add(new Oszlop(this,97,10));
  }

  public String toString() {
    return "Udvar:"+szel+"x"+hossz+", Oszlopok:"+oszlopok;
  }
}

public class UdvarApp2 {
  public static void main(String[] args) {
    Udvar udvar = new Udvar();
    System.out.println(udvar);
  }
}
