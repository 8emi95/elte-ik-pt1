/*
 * Mintafeladatok/1. fejezet
 * Projekt: AutoEladas
 * EladottAuto.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;
import java.util.*;

class EladottAuto {
  private String rendszam;
  private String tulajdonos;
  private String tipus;
  private String szin;

  public EladottAuto(String rendszam, String tulajdonos, String tipus, String szin) {
    this.rendszam = rendszam;
    this.tulajdonos = tulajdonos;
    this.tipus = tipus;
    this.szin = szin;
  }

  public boolean equals(Object obj) {
    return rendszam.equals(((EladottAuto)obj).rendszam);
  }

  public int compareTo(Object obj) {
    return rendszam.compareTo(((EladottAuto)obj).rendszam);
  }

  public String toString() {
    return Format.left(rendszam,10) + " " +
      Format.left(tulajdonos,10) + " " +
      Format.left(tipus,10) + " " +
      Format.left(szin,10);
  }
}
