/*
 * Mintaprogramok/17. fejezet
 * Projekt: TermelFogyaszt
 * Raktar.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

public class Raktar {
  private int kapacitas;
  private int keszlet;

  public Raktar(int kapacitas) {
    this.kapacitas = kapacitas;
    keszlet = 0;
  }

  public synchronized void kivesz(int mennyiseg) {
    // Ha van elegendõ áru, kiszolgáljuk:
    if (mennyiseg <= keszlet) {
      keszlet -= mennyiseg;
      System.out.println("Kivettek, készlet: " + keszlet);
    }
    else {
      System.out.println("Sajnos nem tudunk adni!");
      // Vár, amíg lesz ennyi. Addig nem szolgál ki mást:
      try {
        while (keszlet < mennyiseg)
          wait();
      }
      catch (InterruptedException ie) {
      }
    }
    // Értesíti a szálakat, hátha vár rá valaki:
    notifyAll();
  }

  public synchronized void betesz(int mennyiseg) {
    // Ha van elegendõ hely, betesszük:
    if (keszlet + mennyiseg <= kapacitas) {
      keszlet += mennyiseg;
      System.out.println("Betettek, készlet: " + keszlet);
    }
    else {
      System.out.println("Nem fér be, várni kell!");
      // Vár, amíg lesz annyi hely:
      try {
        while (keszlet + mennyiseg <= kapacitas)
          wait();
      }
      catch (InterruptedException ie) {
      }
    }
    notifyAll();
  }
}
