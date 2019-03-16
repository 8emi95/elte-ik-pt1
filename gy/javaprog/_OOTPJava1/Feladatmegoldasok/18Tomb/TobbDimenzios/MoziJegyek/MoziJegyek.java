/*
 * Feladatmegoldások/18. fejezet
 * MoziJegyek.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import extra.*;

class Mozi {
  private int sorSzam = 10;
  private boolean[][] nezoter = new boolean[sorSzam][]; // 10 sor van

  public Mozi() {
    for (int i=0; i<nezoter.length; i++) {
      if (i<=5)
        nezoter[i] = new boolean[8];   // az elsõ 5 sorban 8 hely van
      else
        nezoter[i] = new boolean[12];  // a többi sorban 12 hely van
    }
  }

  // A sorok száma a moziban:
  public int getSorSzam() {
    return nezoter.length;
  }

  // Egy adott sorban a helyek száma (sor 1-rõl indul):
  public int getHelySzam(int sor) {
    return nezoter[sor-1].length;
  }

  // Jó-e a sor és helyszám (sor és hely 1-rõl indul):
  public boolean ok(int sor, int hely) {
    return (sor-1 >= 0 && sor-1 < nezoter.length &&
      hely-1 >= 0 && hely-1 < nezoter[sor-1].length);
  }

  // Sor és hely lefoglalása, illetve felszabadítása (sor és hely 1-rõl indul):
  private void allit(int sor, int hely, boolean b) {
    if (!ok(sor,hely))
     return;
    nezoter[sor-1][hely-1] = b;
  }

  // Hely lefoglalása. A sor és hely 1-tõl számozódik:
  public void lefoglal(int sor, int hely) {
    allit(sor,hely,true);
  }

  // Hely felszabadítása. A sor és hely 1-tõl számozódik:
  public void felszabadit(int sor, int hely) {
    allit(sor,hely,false);
  }

  // true, ha a sor, hely foglalt:
  public boolean foglalt(int sor, int hely) {
    if (!ok(sor,hely))
      return false;
    return nezoter[sor-1][hely-1];
  }

  // A nézõtér kiprintelése konzolra:
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

  // A sor számának bekérése a nézõtõl:
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

  // A hely számának bekérése a nézõtõl:
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
    // Választás menübõl: Eladas/Visszavaltas/Vége.
    do {
      mozi.print();
      c = Character.toUpperCase(Console.readChar("E(ladás)/V(isszaváltás)/K(ilép)"));
      switch (c) {
        case 'E': {
          sor = sorBeker();
          hely = helyBeker(sor);
          if (mozi.foglalt(sor,hely))
            System.out.println("Már foglalt!");
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
