/*
 * Feladatmegoldások/12. fejezet
 * Rajzolas.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

class Rajzlap extends JPanel implements MouseListener,
                                MouseMotionListener {
  // Minden eleme egy egyszínû, összefüggõ vonal:
  private Vector vonalak = new Vector();
  private Polygon aktVonal;

  // A színeket külön vektorban tároljuk:
  private Vector vonalSzinek = new Vector();
  private Color aktSzin;

  public Rajzlap() {
    setSize(400,400);
    addMouseListener(this);
    addMouseMotionListener(this);
  }

  // A kép törlése:
  public void clear() {
    vonalak.clear();
    vonalSzinek.clear();
    repaint();
  }

  // Aktuális rajzolószín beállítása:
  public void setColor(Color c) {
    aktSzin = c;
  }

  // A teljes kép (összes sokszög) kirajzolása:
  public void paintComponent(Graphics gr) {
    super.paintComponent(gr);
    Polygon vonal;
    Color szin;
    for (int i=0; i<vonalak.size(); i++) {
      szin = (Color)(vonalSzinek.get(i));
      vonal = (Polygon)(vonalak.get(i));
      gr.setColor(szin);
      gr.drawPolyline(vonal.xpoints,vonal.ypoints,vonal.npoints);
    }
  }

  public void mouseClicked(MouseEvent e) {
  }

  public void mousePressed(MouseEvent e) {
    // Vonalkezdés, egy pont hozzáadása a sokszöghöz.
    // Elõször adatmódosítás:
    int x=e.getX(), y=e.getY();
    vonalSzinek.add(aktSzin);
    vonalak.add(aktVonal = new Polygon());
    aktVonal.addPoint(x,y);
    // Pont kirajzolása:
    Graphics gr = getGraphics();
    gr.setColor(aktSzin);
    gr.drawLine(x,y,x,y);
    gr.dispose();
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void mouseDragged(MouseEvent e) {
    // Vonal folytatása, ha már el van kezdve a vonal:
    if (aktVonal != null && aktVonal.npoints > 0) {
      // Adatmódosítás:
      aktVonal.addPoint(e.getX(),e.getY());
      // Utolsó vonalszakasz kirajzolása:
      Graphics gr = getGraphics();
      gr.setColor(aktSzin);
      gr.drawLine(aktVonal.xpoints[aktVonal.npoints-2],
        aktVonal.ypoints[aktVonal.npoints-2],
        aktVonal.xpoints[aktVonal.npoints-1],
        aktVonal.ypoints[aktVonal.npoints-1]);
      gr.dispose();
    }
  }

  public void mouseMoved(MouseEvent e) {
  }
}

public class Rajzolas extends JApplet implements ActionListener {
  JButton btTorol, btRajzoloSzin;
  Rajzlap rajzlap;
  Color[] colors = {Color.black,Color.white,Color.red,
    Color.pink,Color.orange,Color.magenta,Color.blue};
  int rajzoloSzin = 0;

  public Rajzolas() {
    // Törlés és színállítás gombok:
    JPanel pn = new JPanel();
    pn.add(btTorol = new JButton("Töröl"));
    pn.add(new JLabel("Rajzolószín",JLabel.RIGHT));
    pn.add(btRajzoloSzin = new JButton(""));
    btRajzoloSzin.setBackground(colors[rajzoloSzin]);

    getContentPane().add(pn,"North");

    // Rajzolóterület:
    getContentPane().add(rajzlap = new Rajzlap(),"Center");
    rajzlap.setBackground(Color.lightGray);
    rajzlap.setColor(colors[rajzoloSzin]);

    btRajzoloSzin.addActionListener(this);
    btTorol.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btTorol)
      rajzlap.clear();
    else if (e.getSource() == btRajzoloSzin) {
      if (rajzoloSzin < colors.length-1)
        rajzoloSzin++;
      else
        rajzoloSzin = 0;
      btRajzoloSzin.setBackground(colors[rajzoloSzin]);
      rajzlap.setColor(colors[rajzoloSzin]);
    }
  }
} // Rajzolas
