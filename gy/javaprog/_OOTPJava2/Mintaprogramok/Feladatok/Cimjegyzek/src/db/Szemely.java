/*
 * Mintaprogramok/Feladatok
 * Projekt: Cimjegyzek
 * Csomag: db
 * Szemely.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * Egy szem�ly adatait t�rolja.
 */

package db;
import java.io.*;

public class Szemely {
  public String nev;       // A szem�ly neve
  public String irszam;    // ir�ny�t�sz�m
  public String varos;     // v�ros
  public String cim;       // c�m - utca, h�zsz�m
  public String telefon;   // telefon

  // Az mez�k elmentett hosszai:
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
