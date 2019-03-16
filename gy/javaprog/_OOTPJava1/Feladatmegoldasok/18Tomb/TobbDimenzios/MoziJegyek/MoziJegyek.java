/*
 * Feladatmegold�sok/18. fejezet
 * MoziJegyek.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import extra.*;

class Mozi {
  private int sorSzam = 10;
  private boolean[][] nezoter = new boolean[sorSzam][]; // 10 sor van

  public Mozi() {
    for (int i=0; i<nezoter.length; i++) {
      if (i<=5)
        nezoter[i] = new boolean[8];   // az els� 5 sorban 8 hely van
      else
        nezoter[i] = new boolean[12];  // a t�bbi sorban 12 hely van
    }
  }

  // A sorok sz�ma a moziban:
  public int getSorSzam() {
    return nezoter.length;
  }

  // Egy adott sorban a helyek sz�ma (sor 1-r�l indul):
  public int getHelySzam(int sor) {
    return nezoter[sor-1].length;
  }

  // J�-e a sor �s helysz�m (sor �s hely 1-r�l indul):
  public boolean ok(int sor, int hely) {
    return (sor-1 >= 0 && sor-1 < nezoter.length &&
      hely-1 >= 0 && hely-1 < nezoter[sor-1].length);
  }

  // Sor �s hely lefoglal�sa, illetve felszabad�t�sa (sor �s hely 1-r�l indul):
  private void allit(int sor, int hely, boolean b) {
    if (!ok(sor,hely))
     return;
    nezoter[sor-1][hely-1] = b;
  }

  // Hely lefoglal�sa. A sor �s hely 1-t�l sz�moz�dik:
  public void lefoglal(int sor, int hely) {
    allit(sor,hely,true);
  }

  // Hely felszabad�t�sa. A sor �s hely 1-t�l sz�moz�dik:
  public void felszabadit(int sor, int hely) {
    allit(sor,hely,false);
  }

  // true, ha a sor, hely foglalt:
  public boolean foglalt(int sor, int hely) {
    if (!ok(sor,hely))
      return false;
    return nezoter[sor-1][hely-1];
  }

  // A n�z�t�r kiprintel�se konzolra:
  public void print() {
    System.out.print("\n  ");
    for (int j=0; j<nezoter[nezoter.length-1].length; j++)
      System.out.print((j+1)%10);
    System.out.println();

    for (int i=0; i<nezoter.length; i++) {
      System.out.print(Format.right(i+1,2));
      for (int j=0; j<nezoter[i].length; j++) {
        if (nezoter[i][j])
          System.out.print("O");
        else
          System.out.print("-");
      }
      System.out.println();
    }
  }
}

//-------------------------------------------------------------------------------------------
public class MoziJegyek {
  private Mozi mozi = new Mozi();

  // A sor sz�m�nak bek�r�se a n�z�t�l:
  private int sorBeker() {
    int sor;
    boolean ok = false;
    do {
      sor = Console.readInt("Sor: ");
      ok = sor<=mozi.getSorSzam();
      if (!ok)
        System.out.println("Nincs ilyen sor!");
    } while (!ok);
    return sor;
  }

  // A hely sz�m�nak bek�r�se a n�z�t�l:
  private int helyBeker(int sor) {
    int hely;
    boolean ok = false;
    do {
      hely = Console.readInt("Hely: ");
      ok = hely<=mozi.getHelySzam(sor);
      if (!ok)
        System.out.println("Nincs ilyen hely!");
    } while (!ok);
    return hely;
  }

  public void menu() {
    int sor, hely;
    char c;
    // V�laszt�s men�b�l: Eladas/Visszavaltas/V�ge.
    do {
      mozi.print();
      c = Character.toUpperCase(Console.readChar("E(lad�s)/V(isszav�lt�s)/K(il�p)"));
      switch (c) {
        case 'E': {
          sor = sorBeker();
          hely = helyBeker(sor);
          if (mozi.foglalt(sor,hely))
            System.out.println("M�r foglalt!");
          else
            mozi.lefoglal(sor,hely);
          break;
        }
        case 'V': {
          sor = sorBeker();
          hely = helyBeker(sor);
          if (mozi.foglalt(sor,hely))
            mozi.felszabadit(sor,hely);
          else
            System.out.println("Nincs lefoglalva!");
          break;
        }
      } // switch
    } while (c!='K');
  }

  public static void main(String[] args) {
    new MoziJegyek().menu();
  }
}
