
/**
 * @author Keszthelyi Zsolt
 * @version 2017. május 14.
 * 
 * stereotype: entity
 * encoding: windows-1250
 */
public class Szemely {
  private String nev;
  private String varos; // lakóhely

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
   * Jelzi, hogy egy másik Szemely osztályú objektum egyenlõ-e ezzel.
   * 
   * @param obj A hasonlító Szemely osztályú objektum
   * @return true, ha a Szemely osztályú this és obj egyenlõ,
   *         azaz a nev mezõjük azonos; egyébként false.
   */
  @Override
  public boolean equals(Object obj) {
    return nev.equals(((Szemely)obj).nev);
  }  
} // class Szemely
