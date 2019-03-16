/*
 * Feladatmegoldások/10. fejezet
 * Projekt: AlakzatRajzolo
 * Csomag: alakzatrajzolo
 * AlakzatRajzolo.java (fõprogram)
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2002.09.01.
 *
 * Alakzatrajzoló keret, fõprogram. Felül az eszköztár tartalmazza
 * a lehetséges funkciók gombjait, középen a rajzpanel.
 * Az egyes gombok kiválasztásakor beállítjuk a rajzpanel megfelelõ tulajdonságait.
 */

package alakzatrajzolo;
import buttons.PaintedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlakzatRajzolo extends JFrame implements ActionListener,
          MouseMotionListener {
  private Container cp = getContentPane();
  private JPanel toolBar = new JPanel();
  private Font toolFont = new Font("Dialog",Font.PLAIN,12);
  private PaintedButton btPoint, btLine, btRect, btRoundedRect, btOval;
  private JCheckBox cbFilled;
  private JButton btBackground, btColor;
  private JTextField tfBackground, tfColor;

  private DrawPanel drawPanel = new DrawPanel();

  public AlakzatRajzolo() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screenSize.width, screenSize.height-50);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    buildToolBar();
    cp.add(toolBar,"North");
    cp.add(drawPanel);
    show();
  }

  // Az eszköztár (toolBar) felépítése:
  void buildToolBar() {
    // Gombok az alakzat típusának kiválasztására.
    // Egyszerre pontosan egy alakzatot lehet kiválasztani (kezdetben a téglalap):
    toolBar.setFont(toolFont);
    toolBar.add(btPoint = new PaintedButton(PaintedButton.POINT));
    toolBar.add(btLine = new PaintedButton(PaintedButton.LINE));
    toolBar.add(btRect = new PaintedButton(PaintedButton.RECT));
    toolBar.add(btRoundedRect = new PaintedButton(PaintedButton.ROUNDEDRECT));
    toolBar.add(btOval = new PaintedButton(PaintedButton.OVAL));
    ButtonGroup bg = new ButtonGroup();
    bg.add(btPoint);
    bg.add(btLine);
    bg.add(btRect);
    bg.add(btRoundedRect);
    bg.add(btOval);
    btRect.setSelected(true);
    drawPanel.drawingMode = drawPanel.RECT_MODE;

    // Elválasztás:
    toolBar.add(new Label("  "));

    // Jelölõmezõ az alakzat kitöltésének megválasztására.
    // Kezdetben nincs kitöltés:
    toolBar.add(cbFilled = new JCheckBox("Kitöltött",false));
    cbFilled.setFont(toolFont);
    drawPanel.filled = false;

    // Elválasztás:
    toolBar.add(new Label("  "));

    // Színek:
    toolBar.add(tfBackground = new JTextField(1));
    tfBackground.setEnabled(false);
    //tfBackground.setOpaque(true);
    toolBar.add(btBackground=new JButton("Háttérszín"));
    btBackground.setFont(toolFont);
    btBackground.setPreferredSize(new Dimension(100,30));

    toolBar.add(tfColor = new JTextField(1));
    tfColor.setEnabled(false);
    tfColor.setBackground(Color.black);
    //tfColor.setOpaque(true);
    toolBar.add(btColor=new JButton("Rajzszín"));
    btColor.setFont(toolFont);
    btColor.setPreferredSize(new Dimension(100,30));

    // Figyelõláncok:
    btPoint.addActionListener(this);
    btLine.addActionListener(this);
    btRect.addActionListener(this);
    btRoundedRect.addActionListener(this);
    btOval.addActionListener(this);
    cbFilled.addActionListener(this);
    btBackground.addActionListener(this);
    btColor.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    AbstractButton source = (AbstractButton)e.getSource();
    if (source==btPoint)
      drawPanel.drawingMode=DrawPanel.POINT_MODE;
    if (source==btLine)
      drawPanel.drawingMode=DrawPanel.LINE_MODE;
    if (source==btRect)
      drawPanel.drawingMode=DrawPanel.RECT_MODE;
    if (source==btRoundedRect)
      drawPanel.drawingMode=DrawPanel.ROUNDEDRECT_MODE;
    else if (source==btOval)
      drawPanel.drawingMode=DrawPanel.OVAL_MODE;

    else if (source==cbFilled)
      drawPanel.filled=cbFilled.isSelected();

    else if (source==btBackground) {
      Color color = drawPanel.getBackground();
      color = JColorChooser.showDialog(this,"A rajzlap háttérszíne",color);
      drawPanel.setBackground(color);
      tfBackground.setBackground(color);
    }

    else if (source==btColor) {
      Color color = drawPanel.color;
      color = JColorChooser.showDialog(this,"A rajzlap rajzolószíne",color);
      drawPanel.color = color;
      tfColor.setBackground(color);
    }
  }

  public void mouseDragged(MouseEvent e) {
  }

  public void mouseMoved(MouseEvent e) {
    setTitle(e.getX()+"-"+e.getY());
  }

  public static void main(String[] args) {
    new AlakzatRajzolo();
  }
}
