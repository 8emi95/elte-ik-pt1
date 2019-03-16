/*
 * Esettanulm�nyok/GyusziJateka
 * GyusziJateka.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java I. k�tet
 * 2001.02.01.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* Aut� oszt�ly, a Component oszt�ly kiterjeszt�se.
 * Figyeli az eg�resem�nyeket.
 */
class Auto extends JComponent implements MouseListener, MouseMotionListener {
  private Color szin;            // az aut� sz�ne
  private double sebesseg;       // az aut� sebess�ge m/sec-ben
  private double irany;          // ir�ny radian-ban (a felhasznalo fokban adja meg)
  //private TerepAsztal terepAsztal;  // ezen van az aut�

  /* Konstruktor. Param�terk�nt meg lehet adni az aut� sz�n�t, a kezd� poz�ci�j�t,
   * sebess�g�t, �s az asztalt, amelyiken rajta lesz az aut�.
  */
  public Auto(Color szin, int x, int y, double sebesseg) {
    this.szin = szin;
    this.sebesseg = sebesseg;
    irany = 0;
    //terepAsztal = asztal;
    setLocation(x,y);
    setSize(60,48);         // aut� m�rete
    addMouseListener(this); // az aut� hozz�ad�sa saj�t maga eg�rfigyel� l�nc�hoz
    addMouseMotionListener(this); // ez a l�nc az eg�rmozg�sokat figyeli
  }

  /* Az aut� k�pe. A JComponent oszt�ly paintComponent() met�dus�nak fel�l�r�sa.
   * A megjelen�t�sr�l a h�tt�rprogram gondoskodik.
  */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.black);       // a kerekek feket�k
    g.fillOval(8,34,13,13);        // els� ker�k
    g.fillOval(40,34,13,13);       // h�ts� ker�k
    g.setColor(szin);              // aut� sz�ne
    g.fillRect(15,20,45,10);       // fels� test
    g.fillRect(2,30,59,10);        // als� test
    g.fillOval(0,32,4,4);          // l�mpa
    g.drawLine(15,20,30,10);       // antenna
    g.setColor(Color.lightGray);   // az ablak sz�rke
    g.fillRect(17,23,4,8);         // ablak
  }

  /* Az aut� megy egy sebess�g�nek megfelel� t�vols�got.
  * Ha a terepasztal fal�hoz �r, rugalmasan �tk�zik.
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
    // �j poz�ci�ba ker�l. A koordin�t�k a tulajdonoshoz k�pest �rtend�k:
    setLocation(getX()+sebessegX,getY()+sebessegY);
    setVisible(true);
  }

  // Az aut� fordul egyet a megadott sz�ggel pozit�v ir�nyban.
  public void fordul(int fok) {
    irany += Math.toRadians(fok);
  }

  // Az aut� ir�nya a megadott lesz:
  public void setIrany(int fok) {
    irany = Math.toRadians(fok);
  }

  /* A MouseListener interf�sz met�dusai. K�telez� mindegyiket implement�lni,
   * az �reseket is.

   * Ha kett�t kattint az aktor az aut�n, akkor ez a met�dus
   * automatikusan megh�v�sra ker�l.
   * Az aut� megfordul, azaz 180 fokos fordulatot tesz.
   */
  public void mouseClicked(MouseEvent e) {
    if (e.getClickCount()==2)
      fordul(180);
  }
  public void mousePressed(MouseEvent e) {}
  public void mouseReleased(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}
  public void mouseExited(MouseEvent e) {}

  /* A MouseMotionListener interf�sz met�dusai.

   * Ha eg�rrel vonszolja az aktor az aut�t, akkor ez a met�dus
   * automatikusan megh�v�sra ker�l.
   * A met�dus arr�bbteszi az aut�t �gy, hogy az eg�r az aut� k�zep�n legyen.
   * De csak akkor teszi arr�bb, ha az aut� m�g a terepasztalon lesz.
   */
  public void mouseDragged(MouseEvent e) {
    // Az aut� �j koordin�t�j�nak kisz�m�t�sa:
    int x = getX() + e.getX() - getWidth() / 2;
    int y = getY() + e.getY() - getHeight() / 2;

    // Csak akkor helyezz�k �t az aut�t, ha az �j koordin�ta rajta van a terepasztalon:
    if (x >= 0 && x + getWidth() < getParent().getWidth() &&
        y >= 0 && y + getHeight() < getParent().getHeight())
    setLocation(x, y);
  }
  public void mouseMoved(MouseEvent e) {}
}

/* TerepAsztal oszt�ly, a Frame oszt�ly kiterjeszt�se.
 * Figyeli a billenty�zetet.
 */
class TerepAsztal extends JFrame implements KeyListener {
  // A keretbe nem lehet k�zvetlen�l betenni komponenst, csak a contentPane-be:
  Container cp = getContentPane();

  // Konstruktor:
  public TerepAsztal() {
    setTitle("Gyuszi j�tszik");  // a keret c�me
    setDefaultCloseOperation(EXIT_ON_CLOSE); // ha becsukj�k a keretet, v�ge a programnak
    setResizable(false);         // a keretet nem lehet �tm�retezni
    setLocation(200,100);        // a keret bal fels� sarka
    setSize(700,500);            // a keret m�rete (benne a terepasztal)
    cp.setBackground(Color.lightGray);  // a terepasztal sz�rke
    cp.setLayout(null);
    addKeyListener(this);        // billenty� figyel�s�nek regisztr�l�sa
    show();                      // l�tszik a keret
  }

  /* Robognak az aut�k.
   * Sorban, v�g n�lk�l mindegyik aut� azt az �zenetet kapja, hogy megy.
   * K�zben kicsit v�rakozni kell, mert a megy csak egy szimul�ci�, az aut�
   * igaz�b�l ugrik a sebess�g�nek megfelel� t�vols�got.
   * A robog�s elvileg v�g n�lk�l megy. A h�tt�rprogram k�zben
   * figyeli a billenty�zetet, majd ott fog le�llnia program.
   */
  public void robogas() {
    int index = -1;
    Auto auto;
    do {
      index += 1;
      if (index == cp.getComponentCount())  // az utols� aut� ut�n az els� k�vetkezik
        index = 0;
      auto = (Auto)cp.getComponent(index);  // az aut� referenci�j�nak kik�r�se
      auto.megy();                       // �zenet az aut�nak
      try {
        Thread.sleep(100);               // 100 ezredm�sodperc v�rakoz�s
      }
      catch (InterruptedException e) {
      }
    } while (true);
  }

  // Ez az�rt kell, mert a keretbe nem lehet k�zvetlen�l betenni komponenst:
  public void add(Auto auto) {
    cp.add(auto);
  }

  // Billenty�kezel� met�dusok:
  public void keyTyped(KeyEvent e) {}
  // Ha lenyomtak egy billenty�t, ide ker�l a vez�rl�s:
  public void keyPressed(KeyEvent e){
    if (e.getKeyCode()== KeyEvent.VK_ESCAPE) // ha a lenyomott billenty� az ESC,
      System.exit(0);                        // a program azonnal le�ll.
  }
  public void keyReleased(KeyEvent e) {}
}

/* Vez�r oszt�ly. Nem l�that�, a h�tt�rb�l ind�tja el a j�t�kot.
 * Van egy terepasztala.
 */
public class GyusziJateka  {
  private TerepAsztal terepAsztal;

  /* Konstruktor. L�trehozza a terepasztalt, majd l�trehoz 4 aut�t,
   * �s r�teszi �ket a terepasztalra.
   * Utas�tja a terepasztalt, hogy robogtassa az aut�kat.
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

    terepAsztal.robogas();    // �s robog, �s robog...
  }

  /* A program bel�p�si pontja. L�trehozza a j�t�kot.
   */
  public static void main(String[] args) {
    new GyusziJateka();
  }
}
