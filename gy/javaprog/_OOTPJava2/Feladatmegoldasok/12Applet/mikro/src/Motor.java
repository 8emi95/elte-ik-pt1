/*
 * Feladatmegold�sok/12. fejezet
 * Projekt: mikro
 * Motor.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2005.01.10.
 */

// Ha a motor be van kapcsolva, akkor berreg, egy�bk�nt nem berreg.
public class Motor {
  private boolean bekapcsolva = false;
  private Hang berreg;

  public Motor() {
    /** A hang az oszt�ly alatti sound mapp�ban van. */
    berreg = new Hang(getClass().getResource("sound/berreg.wav"));
  }

  /** Be van kapcsolva a motor?*/
  public boolean isBekapcsolva() {
    return bekapcsolva;
  }

  /** A motor bekapcsol�sa. Elkezd berregni.*/
  public void bekapcsol() {
    bekapcsolva = true;
    berreg.szol();
  }

  /** A motor kikapcsol�sa. Berreg�s le�ll.*/
  public void kikapcsol() {
    bekapcsolva = false;
    berreg.elhallgat();
  }

}
