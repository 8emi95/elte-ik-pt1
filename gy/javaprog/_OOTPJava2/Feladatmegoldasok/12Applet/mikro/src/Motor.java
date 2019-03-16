/*
 * Feladatmegoldások/12. fejezet
 * Projekt: mikro
 * Motor.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

// Ha a motor be van kapcsolva, akkor berreg, egyébként nem berreg.
public class Motor {
  private boolean bekapcsolva = false;
  private Hang berreg;

  public Motor() {
    /** A hang az osztály alatti sound mappában van. */
    berreg = new Hang(getClass().getResource("sound/berreg.wav"));
  }

  /** Be van kapcsolva a motor?*/
  public boolean isBekapcsolva() {
    return bekapcsolva;
  }

  /** A motor bekapcsolása. Elkezd berregni.*/
  public void bekapcsol() {
    bekapcsolva = true;
    berreg.szol();
  }

  /** A motor kikapcsolása. Berregés leáll.*/
  public void kikapcsol() {
    bekapcsolva = false;
    berreg.elhallgat();
  }

}
