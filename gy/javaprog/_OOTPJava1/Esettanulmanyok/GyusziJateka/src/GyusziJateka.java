/*
 * Esettanulmányok/GyusziJateka
 * GyusziJateka.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java I. kötet
 * 2001.02.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* Autó osztály, a Component osztály kiterjesztése.
 * Figyeli az egéreseményeket.
 */
class Auto extends JComponent implements MouseListener, MouseMotionListener {
  private Color szin;            // az autó színe
  private double sebesseg;       // az autó sebessége m/sec-ben
  private double irany;          // irány radian-ban (a felhasznalo fokban adja meg)
  //private TerepAsztal terepAsztal;  // ezen van az autó

  /* Konstruktor. Paraméterként meg lehet adni az autó színét, a kezdõ pozícióját,
   * sebességét, és az asztalt, amelyiken rajta lesz az autó.
  */
  public Auto(Color szin, int x, int y, double sebesseg) {
    this.szin = szin;
    this.sebesseg = sebesseg;
    irany = 0;
    //terepAsztal = asztal;
    setLocation(x,y);
    setSize(60,48);         // autó mérete
    addMouseListener(this); // az autó hozzáadása saját maga egérfigyelõ láncához
    addMouseMotionListener(this); // ez a lánc az egérmozgásokat figyeli
  }

  /* Az autó képe. A JComponent osztály paintComponent() metódusának felülírása.
   * A megjelenítésrõl a háttérprogram gondoskodik.
  */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.black);       // a kerekek feketék
    g.fillOval(8,34,13,13);        // elsô kerék
    g.fillOval(40,34,13,13);       // hátsó kerék
    g.setColor(szin);              // autó színe
    g.fillRect(15,20,45,10);       // felsô test
    g.fillRect(2,30,59,10);        // alsó test
    g.fillOval(0,32,4,4);          // lámpa
    g.drawLine(15,20,30,10);       // antenna
    g.setColor(Color.lightGray);   // az ablak szürke
    g.fillRect(17,23,4,8);         // ablak
  }

  /* Az autó megy egy sebességének megfelelõ távolságot.
  * Ha a terepasztal falához ér, rugalmasan ütközik.
  */
  public void megy() {
    int sebessegX, sebessegY;
    sebessegX = (int)(sebesseg * Math.cos(irany));
    sebessegY = (int)(sebesseg * -Math.sin(irany));

    if (getX() < 0 || getX()+getWidth() > getParent().getWidth()) {
      irany = Math.PI-irany;
      sebessegX *= -1;
    }
    if (getY() < 0 || getY()+getHeight() > getParent().getHeight()) {
      irany *= -1;
      sebessegY *= -1;
    }

    setVisible(false);
    // Új pozícióba kerül. A koordináták a tulajdonoshoz képest értendõk:
    setLocation(getX()+sebessegX,getY()+sebessegY);
    setVisible(true);
  }

  // Az autó fordul egyet a megadott szöggel pozitív irányban.
  public void fordul(int fok) {
    irany += Math.toRadians(fok);
  }

  // Az autó iránya a megadott lesz:
  public void setIrany(int fok) {
    irany = Math.toRadians(fok);
  }

  /* A MouseListener interfész metódusai. Kötelezõ mindegyiket implementálni,
   * az üreseket is.

   * Ha kettõt kattint az aktor az autón, akkor ez a metódus
   * automatikusan meghívásra kerül.
   * Az autó megfordul, azaz 180 fokos fordulatot tesz.
   */
  public void mouseClicked(MouseEvent e) {
    if (e.getClickCount()==2)
      fordul(180);
  }
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}

  /* A MouseMotionListener interfész metódusai.

   * Ha egérrel vonszolja az aktor az autót, akkor ez a metódus
   * automatikusan meghívásra kerül.
   * A metódus arrébbteszi az autót úgy, hogy az egér az autó közepén legyen.
   * De csak akkor teszi arrébb, ha az autó még a terepasztalon lesz.
   */
  public void mouseDragged(MouseEvent e) {
    // Az autó új koordinátájának kiszámítása:
    int x = getX() + e.getX() - getWidth() / 2;
    int y = getY() + e.getY() - getHeight() / 2;

    // Csak akkor helyezzük át az autót, ha az új koordináta rajta van a terepasztalon:
    if (x >= 0 && x + getWidth() < getParent().getWidth() &&
        y >= 0 && y + getHeight() < getParent().getHeight())
    setLocation(x, y);
  }
  public void mouseMoved(MouseEvent e) {}
}

/* TerepAsztal osztály, a Frame osztály kiterjesztése.
 * Figyeli a billentyûzetet.
 */
class TerepAsztal extends JFrame implements KeyListener {
  // A keretbe nem lehet közvetlenül betenni komponenst, csak a contentPane-be:
  Container cp = getContentPane();

  // Konstruktor:
  public TerepAsztal() {
    setTitle("Gyuszi játszik");  // a keret címe
    setDefaultCloseOperation(EXIT_ON_CLOSE); // ha becsukják a keretet, vége a programnak
    setResizable(false);         // a keretet nem lehet átméretezni
    setLocation(200,100);        // a keret bal felsõ sarka
    setSize(700,500);            // a keret mérete (benne a terepasztal)
    cp.setBackground(Color.lightGray);  // a terepasztal szürke
    cp.setLayout(null);
    addKeyListener(this);        // billentyû figyelésének regisztrálása
    show();                      // látszik a keret
  }

  /* Robognak az autók.
   * Sorban, vég nélkül mindegyik autó azt az üzenetet kapja, hogy megy.
   * Közben kicsit várakozni kell, mert a megy csak egy szimuláció, az autó
   * igazából ugrik a sebességének megfelelõ távolságot.
   * A robogás elvileg vég nélkül megy. A háttérprogram közben
   * figyeli a billentyûzetet, majd ott fog leállnia program.
   */
  public void robogas() {
    int index = -1;
    Auto auto;
    do {
      index += 1;
      if (index == cp.getComponentCount())  // az utolsó autó után az elsõ következik
        index = 0;
      auto = (Auto)cp.getComponent(index);  // az autó referenciájának kikérése
      auto.megy();                       // üzenet az autónak
      try {
        Thread.sleep(100);               // 100 ezredmásodperc várakozás
      }
      catch (InterruptedException e) {
      }
    } while (true);
  }

  // Ez azért kell, mert a keretbe nem lehet közvetlenül betenni komponenst:
  public void add(Auto auto) {
    cp.add(auto);
  }

  // Billentyûkezelõ metódusok:
  public void keyTyped(KeyEvent e) {}
  // Ha lenyomtak egy billentyût, ide kerül a vezérlés:
  public void keyPressed(KeyEvent e){
    if (e.getKeyCode()== KeyEvent.VK_ESCAPE) // ha a lenyomott billentyû az ESC,
      System.exit(0);                        // a program azonnal leáll.
  }
  public void keyReleased(KeyEvent e) {}
}

/* Vezér osztály. Nem látható, a háttérbõl indítja el a játékot.
 * Van egy terepasztala.
 */
public class GyusziJateka  {
  private TerepAsztal terepAsztal;

  /* Konstruktor. Létrehozza a terepasztalt, majd létrehoz 4 autót,
   * és ráteszi õket a terepasztalra.
   * Utasítja a terepasztalt, hogy robogtassa az autókat.
   */
  GyusziJateka() {
    terepAsztal = new TerepAsztal();
    Auto auto;
    auto = new Auto(Color.red,100,10,5);
    terepAsztal.add(auto);
    auto = new Auto(Color.yellow,250,150,10);
    auto.setIrany(30);
    terepAsztal.add(auto);
    auto = new Auto(Color.green,350,50,5);
    auto.setIrany(120);
    terepAsztal.add(auto);
    auto = new Auto(Color.white,500,300,15);
    auto.setIrany(60);
    terepAsztal.add(auto);

    terepAsztal.robogas();    // és robog, és robog...
  }

  /* A program belépési pontja. Létrehozza a játékot.
   */
  public static void main(String[] args) {
    new GyusziJateka();
  }
}
