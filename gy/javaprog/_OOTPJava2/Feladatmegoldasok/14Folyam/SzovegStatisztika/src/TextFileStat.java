/*
 * Feladatmegold�sok/14. fejezet
 * Projekt: SzovegStatisztika
 * TextFileStat.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 */

import java.io.*;
import java.util.StringTokenizer;

// A sz�veg statisztikai adatai�rt felel. A sz�veg �tvonal�val inicializ�ljuk.
// A statisztikai adatok (sorok, szavak, le�t�sek sz�ma...) lek�rdezhet�k.
public class TextFileStat {
  private File file = null;
  private BufferedReader reader = null;

  // Konstruktor:
  public TextFileStat(String utvonal) {
    file = new File(utvonal);
  }

  // Visszaadja a sz�vegben szerepl� sorok sz�m�t:
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

  // Visszaadja a sz�vegben szerepl� szavak sz�m�t:
  public int szavakSzama() throws IOException {
    int szavakSzama = 0;
    megnyit();
    while (reader.ready()) {
      szavakSzama += szavakSzama(reader.readLine());
    }
    bezar();
    return szavakSzama;
  }

  /* Visszaadja a sz�vegben szerepl� le�t�sek sz�m�t.
   * Ez megegyezik a karakterek sz�m�val, de a sorv�gjelet
   * mindenk�ppen csak egy karakternek sz�m�tjuk:
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

  // Visszaadja a megadott sz�veg els� el�fordul�s�nak poz�ci�j�t.
  // Ha nincs benne, akkor -1 -et ad vissza:
  public int keres(String szoveg) throws IOException {
    int sorszam = 0;     // sorok sz�ml�l�sa
    int joSorszam = -1;  // ebben lesz a keresett sz�veg
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

  // Megnyitja a sz�veges �llom�nyt:
  private void megnyit() throws IOException {
    reader = new BufferedReader(new FileReader(file));
  }

  private void bezar() throws IOException {
    reader.close();
  }

  // Visszaadja a sorban szerepl� szavak sz�m�t:
  private int szavakSzama(String sor) {
    StringTokenizer st = new StringTokenizer(sor);
    return st.countTokens();
  }
}
