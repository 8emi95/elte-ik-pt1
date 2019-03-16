/*
 * Projekt: Tilitoli
 *
 * Csomag: play
 * PlayPanel.java

 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java II. k�tet
 * 2002.09.01.
 *
 * J�t�kpanel. Egy ter�let, melyen a gombok �s a lyuk elhelyezkedik.
 * Felel�s egy j�t�k lej�tsz�s��rt.
 * L�trehoz�skor megadjuk a sorok �s oszlopok sz�m�t.
 * Az addObserver met�dus�val fel lehet iratkozni figyel�nek.
 * Ha v�ge van a j�t�knak, akkor a figyel� �rtes�t�st kap, melynek
 * param�tere a j�t�k eredm�nye (Result). Az eredm�nyben a n�v
 * nincs kit�ltve, csak az id� �s a l�p�sek sz�ma.
 *
 * Met�dusok:
 * - addObserver: feliratkoz�s figyel�k�nt. A figyel� �rtes�t�st
 *   kap, ha v�ge van a j�t�knak.
 * - start: V�letlenszer�en elrendezi a gombokat, elind�tja a
 *   stoppert, �s enged�lyezi a j�t�kot.
 */

package play;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class PlayPanel extends JPanel implements ActionListener {
  private int rows, cols;     // sorok �s oszlopok sz�ma
  private int time;           // j�t�kid� m�sodpercben
  private int numberOfSteps;  // l�p�sek sz�ma
  private Timer stopper;      // stopper

  /* PlayButton. Bels� oszt�ly, a gombot reprezent�lja. Egy gombnak van sz�ma.
   * Ismeri a j�t�kpanelt, �gy annak pnButtons gombjait.
   */
  class PlayButton extends JButton {
    int number;

    PlayButton(int number) {
      super(""+number);
      this.number = number;
      setBackground(new Color(140,150,140)); // s�t�tebb olajz�ld
      setFont(new Font("Dialog",Font.PLAIN,20));
    }

    // Visszaadja a gombon lev� sz�mot:
    public int getNumber() {
      return number;
    }

    // Visszaadja a gomb sorfolytonos poz�ci�j�t a panelen (0-t�l sz�mozva):
    public int getPosition() {
      for (int i=0; i<pnButtons.getComponentCount(); i++)
        if (pnButtons.getComponent(i) == this)
          return i;
      return -1;
    }

    // Visszaadja a gomb sorsz�m�t (0..rows):
    public int getRow() {
      return getPosition()/cols;
    }

    // Visszaadja a gomb oszlopsz�m�t (0..cols):
    public int getCol() {
      return getPosition()%cols;
    }

    // Megmondja, hogy a param�terben megadott gomb szomsz�dja-e:
    public boolean isNeighbour(PlayButton pb) {
      int rowDif = Math.abs(this.getRow()-pb.getRow());
      int colDif = Math.abs(this.getCol()-pb.getCol());
      return rowDif+colDif == 1;
    }

    // Visszaaadja a gomb egy v�letlen szomsz�dj�t:
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
      // Ha a sz�l�n voltunk, kiindexelhett�nk:
      } while ((newX<0 || newX>cols-1 || newY<0 || newY>rows-1));

      int pos = newY*rows + newX;
      return (PlayButton)pnButtons.getComponent(pos);
    }

    public String  toString() {
      return number+"";
    }
  } // PlayButton v�ge -----------------------



  private JPanel pnButtons;      // a j�t�k gombjait tartalmaz� panel
  private PlayButton btPressed;  // �ppen lenyomott gomb
  private PlayButton btHole;     // lyuk (l�thatatlan gomb)
  private JLabel lbStep;         // a l�p�ssz�mot kijelz� c�mke
  private JLabel lbTime;         // az id�t kijelz� c�mke
  private PlayObserver playObserver;

  public PlayPanel(PlayObserver playObserver, int rows, int cols) {
    super(new BorderLayout());
    this.playObserver = playObserver;
    this.rows = rows;
    this.cols = cols;
    setBackground(Color.lightGray);
    stopper = new Timer(1000,this); // stopper l�trehoz�sa

    // Gombok panelje:
    pnButtons = new JPanel();
    pnButtons.setLayout(new GridLayout(rows,cols,1,1));
    pnButtons.setBackground(new Color(180,190,180)); // vil�gosabb olajz�ld
    add(pnButtons);

    // St�tuszsor. A kijelz�ket tartalmazza:
    JPanel pnStatus = new JPanel(new GridLayout(1,4));
    pnStatus.add(new JLabel("Id�:"));
    pnStatus.add(lbTime = new JLabel(str(time/60)+":"+str(time%60)));
    pnStatus.add(new JLabel("L�p�s:"));
    pnStatus.add(lbStep = new JLabel(" 0"));
    add(pnStatus,"South");
  }

  // �j j�t�k kezd�dik:
  public void start() {
    createButtons();
    numberOfSteps = 0;
    time = 0;
    stopper.start();
    setButtonsEnabled(true);
  }

  // �j gombok l�trehoz�sa v�letlen helyeken:
  void createButtons() {
    // L�trehoz�s �s kever�s k�zben elt�ntetj�k a gombokat,
    // k�l�nben r�ngana a k�perny�:
    pnButtons.setVisible(false);
    pnButtons.removeAll();
    // L�trehozzuk a gombokat cs�kken� sorrendben:
    pnButtons.add(btHole = new PlayButton(rows*cols));
    for (int i=rows*cols-1; i>0; i--) {
      JButton button = new PlayButton(i);
      pnButtons.add(button);
    }
    btHole.setVisible(false);
    setButtonsEnabled(true);

    /* Kever�s. V�letlen sz�mszor l�p�nk egyet, mintha
     * lenyomt�k volna a lyuk valamelyik szomsz�dj�t:
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

  /* A panel gombjai true eset�n reag�lhatnak, false eset�n
   * nem reag�lhatnak az akci�esem�nyre:
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

  /* Egy l�p�s v�grehajt�s�nak k�s�rlete. btPressed az a gomb, amelyen
   * kattintottak. Csak akkor lesz csere, ha ez a gomb a lyuk mellett van:
   */
  void doStep(PlayButton btPressed) {
    if (!btPressed.isNeighbour(btHole))
      return;

    // btPressed �s btHole szomsz�dok, �gy megt�rt�nik a csere:
    int posPressed = btPressed.getPosition();
    int posHole = btHole.getPosition();

    pnButtons.add(btHole, posPressed);
    pnButtons.add(btPressed, posHole);
    validate(); // gombok �jrarajzol�sa a csere miatt

    // L�p�ssz�m n�vel�se:
    numberOfSteps++;
    lbStep.setText(numberOfSteps + "");
  }

  // true, ha a gombok j� sorrendben vannak, �s a lyuk az utols� helyen �ll:
  public boolean buttonsInOrder() {
    for (int i=0; i<rows*cols; i++)
      if (((PlayButton)pnButtons.getComponent(i)).getNumber() != i+1)
        return false;
    return true;
  }

  // Kieg�sz�t�s balr�l 0-val:
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
      // tesztel�s sor�n nem j�tszunk, olyankor az eredm�ny v�letlen:
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
