/*
 * Mintafeladatok/1. fejezet
 * Projekt: AutoEladas
 * AutoEladas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import extra.*;
import java.util.*;

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
