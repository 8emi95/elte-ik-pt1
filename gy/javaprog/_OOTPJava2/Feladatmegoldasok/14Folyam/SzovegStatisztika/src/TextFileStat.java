/*
 * Feladatmegoldások/14. fejezet
 * Projekt: SzovegStatisztika
 * TextFileStat.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 */

import java.io.*;
import java.util.StringTokenizer;

// A szöveg statisztikai adataiért felel. A szöveg útvonalával inicializáljuk.
// A statisztikai adatok (sorok, szavak, leütések száma...) lekérdezhetõk.
public class TextFileStat {
  private File file = null;
  private BufferedReader reader = null;

  // Konstruktor:
  public TextFileStat(String utvonal) {
    file = new File(utvonal);
  }

  // Visszaadja a szövegben szereplõ sorok számát:
  public int sorokSzama() throws IOException {
    int sorokSzama = 0;
    megnyit();
    while (reader.ready()) {
      reader.readLine();
      sorokSzama++;
    }
    bezar();
    return sorokSzama;
  }

  // Visszaadja a szövegben szereplõ szavak számát:
  public int szavakSzama() throws IOException {
    int szavakSzama = 0;
    megnyit();
    while (reader.ready()) {
      szavakSzama += szavakSzama(reader.readLine());
    }
    bezar();
    return szavakSzama;
  }

  /* Visszaadja a szövegben szereplõ leütések számát.
   * Ez megegyezik a karakterek számával, de a sorvégjelet
   * mindenképpen csak egy karakternek számítjuk:
   */
  public int leutesekSzama() throws IOException {
    int leutesekSzama = 0;
    char kar;
    megnyit();
    while (reader.ready()) {
      kar = (char)reader.read();
      if (kar != '\r')
        leutesekSzama++;
    }
    bezar();
    return leutesekSzama;
  }

  // Visszaadja a megadott szöveg elsõ elõfordulásának pozícióját.
  // Ha nincs benne, akkor -1 -et ad vissza:
  public int keres(String szoveg) throws IOException {
    int sorszam = 0;     // sorok számlálása
    int joSorszam = -1;  // ebben lesz a keresett szöveg
    String sor;
    megnyit();
    while (reader.ready()) {
      sor = reader.readLine();
      sorszam++;
      if (sor.indexOf(szoveg)>=0) {
        joSorszam = sorszam;
        break;
      }
    }
    bezar();
    return joSorszam;
  }

  // Megnyitja a szöveges állományt:
  private void megnyit() throws IOException {
    reader = new BufferedReader(new FileReader(file));
  }

  private void bezar() throws IOException {
    reader.close();
  }

  // Visszaadja a sorban szereplõ szavak számát:
  private int szavakSzama(String sor) {
    StringTokenizer st = new StringTokenizer(sor);
    return st.countTokens();
  }
}
