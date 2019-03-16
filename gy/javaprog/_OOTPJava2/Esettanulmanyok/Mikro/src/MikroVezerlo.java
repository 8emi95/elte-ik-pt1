import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A mikrohullámú sütõ fõablaka.
 * Az osztály állapotának meghatározói:
 * {@link Ajto}, {@link Motor}
 *
 * <p><h1>A mikrohullámú sütõ rövid leírása</h1><br>
 * Egy egyszerû mikrohullámú sütõt kell modellezni.
 * A sütõnek csak légkeveréses fõzési üzemmódja van.
 * A vezérlõpanelen három gomb található: a
 * <code>Perc plusz</code>, a <code>Töröl</code> és az
 * <code>Ajtó</code>.
 * Fõzés csak csukott ajtó mellett történhet. Ha nyitva van az ajtó,
 * illetve a fõzés ideje alatt a sütõben ég egy kis lámpa.<br>
 * <hr>
 * <b>Vezérlõpanel</b>
 * <li><i>Kijelzõ:</i> Mutatja a fõzési idõt percekben.
 * <li><i>Perc+:</i> Ha nem volt fõzés, akkor elindul egy
 * egyperces fõzés. Ha fõzés közben nyomjuk meg, akkor a fõzési
 * idõhöz egy perc hozzáadódik.</li>
 * <li><i>Törlés:</i> Fõzés befejezése. A hátralevõ idõ nullázódik.</li>
 * <li><i>Ajtó:</i> Az ajtó nyitása, illetve csukása.</li>
 * <br>
 * <b>A mikrohullámú sütõ képe:</b><br>
 * <img src="mikro.jpg" alt="Kellene egy jobb böngészõ!" align=middle>
 *
 * @author Angster Erzsébet
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

  /** Létrehozza a fõablakot. */
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
    this.setTitle("Mikrohullámú sütõ");
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
    btTorol.setText("Töröl");
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
    btAjto.setText("Ajtó ki/be");
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

  /** Értesítés jött a visszaszámlálótól, hogy letelt egy másodperc. */
  public void mpLetelt() {
    kijelez();
  }

  /** Értesítés jött a visszaszámlálótól, hogy letelt az idõ. */
  public void idoLetelt() {
    // ajtó csukva On Entry:
    motor.kikapcsol();
    lampa.kikapcsol();
    // idõ letelt kisérõ akció:
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

    // Kísérõ akció:
    visszaszamlalo.plusz60mp();
    if (!motor.isBekapcsolva()) {
      // motor bekapcsolva On Entry:
      lampa.bekapcsol();
      motor.bekapcsol();
      visszaszamlalo.indit();
      kijelez();
    }
  }

  /** Töröl gomb. */
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

  /* Ajtógombot lenyomták. */
  void btAjto_actionPerformed(ActionEvent e) {
    if (btAjto.isSelected()) {
      // ajtó csukva átmenet, On Entry:
      ajto.becsuk();
      lampa.kikapcsol();
      if (!visszaszamlalo.nulla()) { // idõ > 0
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
      // ajtó nyitva állapotba átmenet:
      if (motor.isBekapcsolva()) {
        // motor bekapcsolva On Exit:
        motor.kikapcsol();
        lampa.kikapcsol();
        visszaszamlalo.megallit();
      }
      // ajtó nyitva On Entry:
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
