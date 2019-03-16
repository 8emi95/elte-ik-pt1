
/**
 * @author Keszthelyi Zsolt
 * @version 2017. m�jus 14.
 * 
 * stereotype: entity
 * encoding: windows-1250
 */
public class Szemely {
  private String nev;
  private String varos; // lak�hely

  public Szemely(String nev, String varos) {
    this.nev = nev;
    this.varos = varos;
  }

  public void setNev(String nev) {
    this.nev = nev;
  }

  public void setVaros(String varos) {
    this.varos = varos;
  }

  public String getNev() {
    return nev;
  }

  public String getVaros() {
    return varos;
  }

  @Override
  public String toString() {
    return nev + " (" + varos + ")";
  }

  /**
   * Jelzi, hogy egy m�sik Szemely oszt�ly� objektum egyenl�-e ezzel.
   * 
   * @param obj A hasonl�t� Szemely oszt�ly� objektum
   * @return true, ha a Szemely oszt�ly� this �s obj egyenl�,
   *         azaz a nev mez�j�k azonos; egy�bk�nt false.
   */
  @Override
  public boolean equals(Object obj) {
    return nev.equals(((Szemely)obj).nev);
  }  
} // class Szemely
