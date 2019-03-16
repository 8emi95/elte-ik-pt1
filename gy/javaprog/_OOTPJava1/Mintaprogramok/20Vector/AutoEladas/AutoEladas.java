/*
 * AutoEladas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2002.01.02.
 */

import extra.*;
import java.util.*;

/* AutoKinalat *************************************************/
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

/* EladottAuto *************************************************/
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

/* AutoEladas **************************************************/
public class AutoEladas {
  private Vector rendszamok = new Vector();
  private Vector autoKinalatok = new Vector();
  private Vector eladottAutok = new Vector();
  
  public AutoEladas() {
    menu();
  }

  void rendszamFelvisz() {
    String rendszam = Console.readLine("Rendszam: ");
    while (!rendszam.equals("")) {
      rendszamok.add(rendszam.toUpperCase());
      rendszam = Console.readLine("Rendszam: ");
    }
    Collections.sort(rendszamok);
  }

  void rendszamLista() {
    System.out.println("Rendszamok listaja");
    for (int i=0; i<rendszamok.size(); i++)
      System.out.println(rendszamok.get(i));
  }

  void kinalatFelvisz() {
    String tipus = Console.readLine("Autotipus: ");
    String szin;
    int db;
    while (!tipus.equals("")) {
      autoKinalatok.add(new AutoKinalat(tipus,
        Console.readLine("Szin: "),
        Console.readInt("Db: ")));
      tipus = Console.readLine("Autotipus: ");
    }
    Collections.sort(autoKinalatok);
  }

  void kinalatLista() {
    System.out.println("Kinalatok listaja");
    for (int i=0; i<autoKinalatok.size(); i++)
      System.out.println(autoKinalatok.get(i));
  }

  void eladas() {
    if (autoKinalatok.isEmpty())
      System.out.println("Elfogyott az auto!");
    if (rendszamok.isEmpty())
      System.out.println("Elfogyott a rendszam!");

    kinalatLista();
    String tipus = Console.readLine("Milyen tipust ker? ");
    String szin = Console.readLine("Milyen szint ker? ");
    int index = autoKinalatok.indexOf(new AutoKinalat(tipus,szin));
    if (index<0) {
      System.out.println("Nincs ilyen auto");
      return;
    }
    AutoKinalat autoKinalat = (AutoKinalat)(autoKinalatok.get(index));
    if (!autoKinalat.van()) {
      System.out.println("Elfogyott");
      return;
    }

    autoKinalat.keszletCsokkent();
    String rendszam = (String)rendszamok.remove(0);
    String tulajdonos = Console.readLine("Tulajdonos: ");
    EladottAuto eladottAuto = new EladottAuto(rendszam,tulajdonos,tipus,szin);
    eladottAutok.add(eladottAuto);
    System.out.println("A vasarolt auto adatai: "+eladottAuto);
  }

  void eladottAutokLista() {
    System.out.println("Eladott autok listaja");
    for (int i=0; i<eladottAutok.size(); i++)
      System.out.println(eladottAutok.get(i));
  }

  void menu() {
    rendszamFelvisz();
    rendszamLista();
    kinalatFelvisz();
    kinalatLista();
    char menu;
    do {
      menu = Character.toUpperCase(Console.readChar
        ("A(uto eladas)/K(inalatlista)/R(endszamlista)"+
        "/E(ladott autok listaja)/V(ege)? "));
      switch (menu) {
        case 'A' : { eladas(); break; }
        case 'R' : { rendszamLista(); break; }
        case 'K' : { kinalatLista(); break; }
        case 'E' : { eladottAutokLista(); break; }
      }
    } while (menu != 'V');
  }

  public static void main (String args[]) {
    new AutoEladas();
  }
}
