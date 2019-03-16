import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A mikrohull�m� s�t� f�ablaka.
 * Az oszt�ly �llapot�nak meghat�roz�i:
 * {@link Ajto}, {@link Motor}
 *
 * <p><h1>A mikrohull�m� s�t� r�vid le�r�sa</h1><br>
 * Egy egyszer� mikrohull�m� s�t�t kell modellezni.
 * A s�t�nek csak l�gkever�ses f�z�si �zemm�dja van.
 * A vez�rl�panelen h�rom gomb tal�lhat�: a
 * <code>Perc plusz</code>, a <code>T�r�l</code> �s az
 * <code>Ajt�</code>.
 * F�z�s csak csukott ajt� mellett t�rt�nhet. Ha nyitva van az ajt�,
 * illetve a f�z�s ideje alatt a s�t�ben �g egy kis l�mpa.<br>
 * <hr>
 * <b>Vez�rl�panel</b>
 * <li><i>Kijelz�:</i> Mutatja a f�z�si id�t percekben.
 * <li><i>Perc+:</i> Ha nem volt f�z�s, akkor elindul egy
 * egyperces f�z�s. Ha f�z�s k�zben nyomjuk meg, akkor a f�z�si
 * id�h�z egy perc hozz�ad�dik.</li>
 * <li><i>T�rl�s:</i> F�z�s befejez�se. A h�tralev� id� null�z�dik.</li>
 * <li><i>Ajt�:</i> Az ajt� nyit�sa, illetve csuk�sa.</li>
 * <br>
 * <b>A mikrohull�m� s�t� k�pe:</b><br>
 * <img src="mikro.jpg" alt="Kellene egy jobb b�ng�sz�!" align=middle>
 *
 * @author Angster Erzs�bet
 * @version 1.0
 * @see Lampa
 * @see Motor
 * @see Ajto
 * @see Hang
 * @see Visszaszamlalo
 */

public class MikroVezerlo extends JFrame {
  /** Kapcsolatok.*/
  private Hang rovidsip;
  private Hang hosszusip3;
  private Motor motor = new Motor();
  private Visszaszamlalo visszaszamlalo;

  private JPanel contentPane;
  private BorderLayout borderLayout1 = new BorderLayout();
  private JPanel pnVezerlo = new JPanel();
  private GridLayout gridLayout1 = new GridLayout();
  private JPanel pnUres = new JPanel();
  private BorderLayout borderLayout2 = new BorderLayout();
  private BorderLayout borderLayout3 = new BorderLayout();
  private JButton btTorol = new JButton();
  private JPanel pnTorol = new JPanel();
  private BorderLayout borderLayout4 = new BorderLayout();
  private JButton btPercPlusz = new JButton();
  private JPanel pnPercPlusz = new JPanel();
  private BorderLayout borderLayout5 = new BorderLayout();
  private JPanel pnKijelzo = new JPanel();
  private JLabel lbKijelzo = new JLabel();
  private JToggleButton btAjto = new JToggleButton();

  private JPanel pnAjtoGomb = new JPanel();
  private BorderLayout borderLayout7 = new BorderLayout();
  private Border border5;
  JPanel pnMikro = new JPanel();
  BorderLayout borderLayout6 = new BorderLayout();
  Lampa lampa = new Lampa();
  Ajto ajto = new Ajto();
  MikroBelso mikroBelso1 = new MikroBelso();
  MikroBelso mikroBelso = new MikroBelso();

  /** L�trehozza a f�ablakot. */
  public MikroVezerlo() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  //Component initialization
  private void jbInit() throws Exception  {
    rovidsip = new Hang(getClass().getResource("sound/rovidsip.wav"));
    hosszusip3 = new Hang(getClass().getResource("sound/hosszusip3.wav"));
    contentPane = (JPanel) this.getContentPane();
    border5 = BorderFactory.createEmptyBorder(15,15,15,15);
    contentPane.setLayout(borderLayout1);
    this.setSize(new Dimension(526, 349));
    this.setTitle("Mikrohull�m� s�t�");
    pnVezerlo.setBackground(new Color(100, 100, 200));
    pnVezerlo.setBorder(BorderFactory.createRaisedBevelBorder());
    pnVezerlo.setLayout(gridLayout1);
    gridLayout1.setColumns(1);
    gridLayout1.setRows(0);
    pnUres.setBackground(new Color(70, 110, 140));
    pnUres.setBorder(border5);
    pnUres.setLayout(borderLayout2);
    btTorol.setBackground(Color.lightGray);
    btTorol.setFont(new java.awt.Font("SansSerif", 0, 16));
    btTorol.setText("T�r�l");
    btTorol.addActionListener(new MikroVezerlo_btTorol_actionAdapter(this));
    pnTorol.setLayout(borderLayout3);
    pnTorol.setBackground(new Color(70, 110, 140));
    pnTorol.setBorder(border5);
    btPercPlusz.setBackground(Color.lightGray);
    btPercPlusz.setFont(new java.awt.Font("SansSerif", 0, 16));
    btPercPlusz.setText("Perc plusz");
    btPercPlusz.addActionListener(new MikroVezerlo_btPercPlusz_actionAdapter(this));
    pnPercPlusz.setLayout(borderLayout4);
    pnPercPlusz.setBackground(new Color(70, 110, 140));
    pnPercPlusz.setBorder(border5);
    pnKijelzo.setLayout(borderLayout5);
    pnKijelzo.setBackground(new Color(70, 110, 140));
    pnKijelzo.setBorder(border5);
    lbKijelzo.setBackground(Color.white);
    lbKijelzo.setFont(new java.awt.Font("Monospaced", 0, 26));
    lbKijelzo.setBorder(BorderFactory.createEtchedBorder());
    lbKijelzo.setOpaque(true);
    lbKijelzo.setHorizontalAlignment(SwingConstants.CENTER);
    lbKijelzo.setText("00:00");
    btAjto.setBackground(Color.lightGray);
    btAjto.setFont(new java.awt.Font("SansSerif", 0, 16));
    btAjto.setSelected(true);
    btAjto.setText("Ajt� ki/be");
    btAjto.addActionListener(new MikroVezerlo_btAjto_actionAdapter(this));
    pnAjtoGomb.setLayout(borderLayout7);
    pnAjtoGomb.setBackground(new Color(70, 110, 140));
    pnAjtoGomb.setBorder(border5);
    pnMikro.setLayout(borderLayout6);
    contentPane.add(pnVezerlo,  BorderLayout.EAST);
    pnVezerlo.add(pnKijelzo, null);
    pnKijelzo.add(lbKijelzo,  BorderLayout.CENTER);
    pnVezerlo.add(pnPercPlusz, null);
    pnPercPlusz.add(btPercPlusz,  BorderLayout.CENTER);
    pnVezerlo.add(pnTorol, null);
    pnTorol.add(btTorol,  BorderLayout.CENTER);
    pnVezerlo.add(pnUres, null);
    pnVezerlo.add(pnAjtoGomb, null);
    pnAjtoGomb.add(btAjto, BorderLayout.CENTER);
    contentPane.add(pnMikro,  BorderLayout.CENTER);
    pnMikro.add(lampa, BorderLayout.NORTH);
    pnMikro.add(ajto, BorderLayout.SOUTH);
    pnMikro.add(mikroBelso,  BorderLayout.CENTER);
    visszaszamlalo = new Visszaszamlalo(this);
  }

  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  public void kijelez() {
    lbKijelzo.setText(visszaszamlalo.toString());
  }

  /** �rtes�t�s j�tt a visszasz�ml�l�t�l, hogy letelt egy m�sodperc. */
  public void mpLetelt() {
    kijelez();
  }

  /** �rtes�t�s j�tt a visszasz�ml�l�t�l, hogy letelt az id�. */
  public void idoLetelt() {
    // ajt� csukva On Entry:
    motor.kikapcsol();
    lampa.kikapcsol();
    // id� letelt kis�r� akci�:
    hosszusip3.lejatszik();
    // motor kikapcsolva On Entry:
    visszaszamlalo.torol();
    kijelez();
  }

  /**  Perc plusz gomb. */
  void btPercPlusz_actionPerformed(ActionEvent e) {
    rovidsip.lejatszik();
    if (ajto.isNyitva())
       return;

    // K�s�r� akci�:
    visszaszamlalo.plusz60mp();
    if (!motor.isBekapcsolva()) {
      // motor bekapcsolva On Entry:
      lampa.bekapcsol();
      motor.bekapcsol();
      visszaszamlalo.indit();
      kijelez();
    }
  }

  /** T�r�l gomb. */
  void btTorol_actionPerformed(ActionEvent e) {
    // MikroVezerlo
    rovidsip.lejatszik();
    if (motor.isBekapcsolva()) {
      // motor bekapcsolva On Exit:
      motor.kikapcsol();
      lampa.kikapcsol();
    }
    // motor kikapcsolva On Entry:
    visszaszamlalo.torol();
    kijelez();
  }

  /* Ajt�gombot lenyomt�k. */
  void btAjto_actionPerformed(ActionEvent e) {
    if (btAjto.isSelected()) {
      // ajt� csukva �tmenet, On Entry:
      ajto.becsuk();
      lampa.kikapcsol();
      if (!visszaszamlalo.nulla()) { // id� > 0
        // motor bekapcsolva On Entry:
        lampa.bekapcsol();
        motor.bekapcsol();
        visszaszamlalo.indit();
        kijelez();
      }
      else {
        // motor kikapcsolva On Entry:
        visszaszamlalo.torol();
        kijelez();
      }
    }
    else {
      // ajt� nyitva �llapotba �tmenet:
      if (motor.isBekapcsolva()) {
        // motor bekapcsolva On Exit:
        motor.kikapcsol();
        lampa.kikapcsol();
        visszaszamlalo.megallit();
      }
      // ajt� nyitva On Entry:
      ajto.kinyit();
      lampa.bekapcsol();
    }
  }
}

class MikroVezerlo_btPercPlusz_actionAdapter implements java.awt.event.ActionListener {
  MikroVezerlo adaptee;

  MikroVezerlo_btPercPlusz_actionAdapter(MikroVezerlo adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btPercPlusz_actionPerformed(e);
  }
}

class MikroVezerlo_btTorol_actionAdapter implements java.awt.event.ActionListener {
  MikroVezerlo adaptee;

  MikroVezerlo_btTorol_actionAdapter(MikroVezerlo adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btTorol_actionPerformed(e);
  }
}

class MikroVezerlo_btAjto_actionAdapter implements java.awt.event.ActionListener {
  MikroVezerlo adaptee;

  MikroVezerlo_btAjto_actionAdapter(MikroVezerlo adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btAjto_actionPerformed(e);
  }
}
