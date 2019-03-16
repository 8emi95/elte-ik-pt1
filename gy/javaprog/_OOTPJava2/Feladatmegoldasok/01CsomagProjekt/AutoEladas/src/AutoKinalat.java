/*
 * Mintafeladatok/1. fejezet
 * Projekt: AutoEladas
 * AutoKinalat.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;
import java.util.*;

class AutoKinalat implements Comparable {
  private String tipus;
  private String szin;
  private int db;

  public AutoKinalat(String tipus, String szin, int db) {
    this.tipus = tipus;
    this.szin = szin;
    this.db = db;
  }

  public AutoKinalat(String tipus, String szin) {
    this(tipus,szin,0);
  }

  public String getTipus() { return tipus; }
  public String getSzin() { return szin; }
  public int getDb() { return db; }
  public boolean van() { return db>0; }

  public void keszletCsokkent() {
    if (db>0)
      db--;
  }

  public boolean equals(Object obj) {
    AutoKinalat ak = (AutoKinalat)obj;
    return tipus.equals(ak.getTipus()) &&
      szin.equals(ak.getSzin());
  }

  public int compareTo(Object obj) {
    AutoKinalat ak = (AutoKinalat)obj;
    int comp = tipus.compareTo(ak.tipus);
    if (comp!=0 )
      return comp;
    return szin.compareTo(ak.szin);
  }

  public String toString() {
    return Format.left(tipus,10) +
      Format.left(szin,10) +
      Format.left(db,6);
  }
}
