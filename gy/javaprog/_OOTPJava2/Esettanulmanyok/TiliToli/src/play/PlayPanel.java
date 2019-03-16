/*
 * Projekt: Tilitoli
 *
 * Csomag: play
 * PlayPanel.java

 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Játékpanel. Egy terület, melyen a gombok és a lyuk elhelyezkedik.
 * Felelõs egy játék lejátszásáért.
 * Létrehozáskor megadjuk a sorok és oszlopok számát.
 * Az addObserver metódusával fel lehet iratkozni figyelõnek.
 * Ha vége van a játéknak, akkor a figyelõ értesítést kap, melynek
 * paramétere a játék eredménye (Result). Az eredményben a név
 * nincs kitöltve, csak az idõ és a lépések száma.
 *
 * Metódusok:
 * - addObserver: feliratkozás figyelõként. A figyelõ értesítést
 *   kap, ha vége van a játéknak.
 * - start: Véletlenszerûen elrendezi a gombokat, elindítja a
 *   stoppert, és engedélyezi a játékot.
 */

package play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class PlayPanel extends JPanel implements ActionListener {
  private int rows, cols;     // sorok és oszlopok száma
  private int time;           // játékidõ másodpercben
  private int numberOfSteps;  // lépések száma
  private Timer stopper;      // stopper

  /* PlayButton. Belsõ osztály, a gombot reprezentálja. Egy gombnak van száma.
   * Ismeri a játékpanelt, így annak pnButtons gombjait.
   */
  class PlayButton extends JButton {
    int number;

    PlayButton(int number) {
      super(""+number);
      this.number = number;
      setBackground(new Color(140,150,140)); // sötétebb olajzöld
      setFont(new Font("Dialog",Font.PLAIN,20));
    }

    // Visszaadja a gombon levõ számot:
    public int getNumber() {
      return number;
    }

    // Visszaadja a gomb sorfolytonos pozícióját a panelen (0-tól számozva):
    public int getPosition() {
      for (int i=0; i<pnButtons.getComponentCount(); i++)
        if (pnButtons.getComponent(i) == this)
          return i;
      return -1;
    }

    // Visszaadja a gomb sorszámát (0..rows):
    public int getRow() {
      return getPosition()/cols;
    }

    // Visszaadja a gomb oszlopszámát (0..cols):
    public int getCol() {
      return getPosition()%cols;
    }

    // Megmondja, hogy a paraméterben megadott gomb szomszédja-e:
    public boolean isNeighbour(PlayButton pb) {
      int rowDif = Math.abs(this.getRow()-pb.getRow());
      int colDif = Math.abs(this.getCol()-pb.getCol());
      return rowDif+colDif == 1;
    }

    // Visszaaadja a gomb egy véletlen szomszédját:
    public PlayButton randomNeighbour() {
      int x = getRow();
      int y = getCol();
      int newX, newY;
      do {
        newX = x;
        newY = y;
        int n = (int)(Math.random()*4); // 0..3
        if (n==0)
          newX++;
        else if (n==1)
          newX--;
        else if (n==2)
          newY++;
        else if (n==3)
          newY--;
      // Ha a szélén voltunk, kiindexelhettünk:
      } while ((newX<0 || newX>cols-1 || newY<0 || newY>rows-1));

      int pos = newY*rows + newX;
      return (PlayButton)pnButtons.getComponent(pos);
    }

    public String  toString() {
      return number+"";
    }
  } // PlayButton vége -----------------------



  private JPanel pnButtons;      // a játék gombjait tartalmazó panel
  private PlayButton btPressed;  // éppen lenyomott gomb
  private PlayButton btHole;     // lyuk (láthatatlan gomb)
  private JLabel lbStep;         // a lépésszámot kijelzõ címke
  private JLabel lbTime;         // az idõt kijelzõ címke
  private PlayObserver playObserver;

  public PlayPanel(PlayObserver playObserver, int rows, int cols) {
    super(new BorderLayout());
    this.playObserver = playObserver;
    this.rows = rows;
    this.cols = cols;
    setBackground(Color.lightGray);
    stopper = new Timer(1000,this); // stopper létrehozása

    // Gombok panelje:
    pnButtons = new JPanel();
    pnButtons.setLayout(new GridLayout(rows,cols,1,1));
    pnButtons.setBackground(new Color(180,190,180)); // világosabb olajzöld
    add(pnButtons);

    // Státuszsor. A kijelzõket tartalmazza:
    JPanel pnStatus = new JPanel(new GridLayout(1,4));
    pnStatus.add(new JLabel("Idõ:"));
    pnStatus.add(lbTime = new JLabel(str(time/60)+":"+str(time%60)));
    pnStatus.add(new JLabel("Lépés:"));
    pnStatus.add(lbStep = new JLabel(" 0"));
    add(pnStatus,"South");
  }

  // Új játék kezdõdik:
  public void start() {
    createButtons();
    numberOfSteps = 0;
    time = 0;
    stopper.start();
    setButtonsEnabled(true);
  }

  // Új gombok létrehozása véletlen helyeken:
  void createButtons() {
    // Létrehozás és keverés közben eltüntetjük a gombokat,
    // különben rángana a képernyõ:
    pnButtons.setVisible(false);
    pnButtons.removeAll();
    // Létrehozzuk a gombokat csökkenõ sorrendben:
    pnButtons.add(btHole = new PlayButton(rows*cols));
    for (int i=rows*cols-1; i>0; i--) {
      JButton button = new PlayButton(i);
      pnButtons.add(button);
    }
    btHole.setVisible(false);
    setButtonsEnabled(true);

    /* Keverés. Véletlen számszor lépünk egyet, mintha
     * lenyomták volna a lyuk valamelyik szomszédját:
     */
    int lepesSzam = (int)(Math.random()*rows*cols*10);
    for (int i=0; i<lepesSzam; i++) {
      doStep(btHole.randomNeighbour());
    }

    lbStep.setText("0");
    lbTime.setText("0");
    validate();
    pnButtons.setVisible(true);
    setButtonsEnabled(false);
  }

  /* A panel gombjai true esetén reagálhatnak, false esetén
   * nem reagálhatnak az akcióeseményre:
   */
  void setButtonsEnabled(boolean enabled) {
    for (int i = 0; i < pnButtons.getComponentCount(); i++) {
      Component comp = pnButtons.getComponent(i);
      if (comp instanceof PlayButton)
        if (enabled)
          ((PlayButton)comp).addActionListener(this);
        else
          ((PlayButton)comp).removeActionListener(this);
    }
  }

  /* Egy lépés végrehajtásának kísérlete. btPressed az a gomb, amelyen
   * kattintottak. Csak akkor lesz csere, ha ez a gomb a lyuk mellett van:
   */
  void doStep(PlayButton btPressed) {
    if (!btPressed.isNeighbour(btHole))
      return;

    // btPressed és btHole szomszédok, így megtörténik a csere:
    int posPressed = btPressed.getPosition();
    int posHole = btHole.getPosition();

    pnButtons.add(btHole, posPressed);
    pnButtons.add(btPressed, posHole);
    validate(); // gombok újrarajzolása a csere miatt

    // Lépésszám növelése:
    numberOfSteps++;
    lbStep.setText(numberOfSteps + "");
  }

  // true, ha a gombok jó sorrendben vannak, és a lyuk az utolsó helyen áll:
  public boolean buttonsInOrder() {
    for (int i=0; i<rows*cols; i++)
      if (((PlayButton)pnButtons.getComponent(i)).getNumber() != i+1)
        return false;
    return true;
  }

  // Kiegészítés balról 0-val:
  private String str(int n) {
    return (n<10)? "0"+n : ""+n;
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() instanceof PlayButton) {
      doStep((PlayButton)e.getSource());

      if (buttonsInOrder()) {
        stopper.stop();
        setButtonsEnabled(false);
        playObserver.endOfPlay(new Result(time,numberOfSteps));
      }

      /*
      // tesztelés során nem játszunk, olyankor az eredmény véletlen:
      if (true) {
        stopper.stop();
        setButtonsEnabled(false);
        playObserver.endOfPlay(new Result(extra.util.Util.rnd(200),20));
      }
      */
    }
    else if (e.getSource()==stopper) {
      time++;
      lbTime.setText(str(time/60)+":"+str(time%60));
    }
  }

}  //PlayPanel
