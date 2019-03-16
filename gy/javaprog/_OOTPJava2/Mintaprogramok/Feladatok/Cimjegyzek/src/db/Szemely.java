/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: db
 * Szemely.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Egy személy adatait tárolja.
 */

package db;
import java.io.*;

public class Szemely {
  public String nev;       // A személy neve
  public String irszam;    // irányítószám
  public String varos;     // város
  public String cim;       // cím - utca, házszám
  public String telefon;   // telefon

  // Az mezõk elmentett hosszai:
  public final static int NEV_MERET = 20;
  public final static int IRSZAM_MERET = 4;
  public final static int VAROS_MERET = 20;
  public final static int CIM_MERET = 20;
  public final static int TELEFON_MERET = 15;

  public Szemely() {
    this("","","","","");
  }

  public Szemely(String nev, String irSzam, String varos,
                 String cim, String telefon) {
    this.nev = nev;
    this.irszam = irSzam;
    this.varos = varos;
    this.cim = cim;
    this.telefon = telefon;
  }
}
