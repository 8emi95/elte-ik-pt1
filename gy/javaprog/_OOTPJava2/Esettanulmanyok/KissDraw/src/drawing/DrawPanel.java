/*
 * Projekt: KissDraw
 *
 * Csomag: drawing
 * DrawPanel.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 2. k�tet
 * 2002.09.01.
 */

package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import extra.util.Savable;

// Rajzlap. Tartalmazza az alakzatok list�j�t (figures).
public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener, Savable {

  // Rajzol�si m�dok. A drawingMode lehets�ges �rt�kei:
  public static final int LINE_MODE = 10;
  public static final int RECT_MODE = 20;
  public static final int OVAL_MODE = 30;
  public static final int FREELINE_MODE = 40;
  public static final int SELECT_MODE = 50;

  private int drawingMode = LINE_MODE;    // aktu�lis rajzol�si m�d
  private boolean gridVisible = false;    // l�that�-e a r�cs
  private boolean gridAlign = false;      // r�csra igaz�t�s van-e
  private int gridStepX=10, gridStepY=10; // a r�cs s�r�s�ge
  private Color color = Color.black;      // a rajzpanel rajzol�sz�ne

  // A panelen lev� alakzatok:
  private Vector figures = new Vector();

  /* Az alakzatok vektor�nak egym�s ut�ni �llapotai.
   * Az undo/redo (visszavon�s/ism�t) funkci� haszn�lja: */
  private transient Vector states = new Vector();
  private transient int stateIndex = -1;  // az aktu�lis �llapot indexe

  /* Megv�ltozott a rajzlap, ha figures!=origFigures.
   * A setModified �s az isModified() haszn�lja: */
  private transient Vector origFigures = new Vector();

  private transient Figure figure;     // az aktu�lis alakzat
  private transient Point startPoint;  // az aktu�lis alakzat kezd�pontja

  // Norm�l eg�rkurzor:
  private transient Cursor drawCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
  // Ha az eg�r egy alakzat f�l� ker�l, ilyen lesz a kurzor:
  private transient Cursor selectCursor = new Cursor(Cursor.MOVE_CURSOR);


  // Konstruktor. L�trej�n egy �res rajzlap.
  public DrawPanel() {
    // A rajzpanel figyelni fogja az eg�resem�nyeket:
    addMouseListener(this);
    addMouseMotionListener(this);
    setCursor(drawCursor);
    clear(); // rajzlap alap�llapot
  }

  public int getDrawingMode() {
    return drawingMode;
  }

  public void setDrawingMode(int mode) {
    drawingMode = mode;
  }

  public boolean isGridAlign() {
    return gridAlign;
  }

  public void setGridAlign(boolean gridAlign) {
    this.gridAlign = gridAlign;
  }

  public boolean isGridVisible() {
    return gridVisible;
  }

  public void setGridVisible(boolean gridVisible) {
    this.gridVisible = gridVisible;
    repaint();
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  // Visszaadja a rajzlap aktu�lis alakzatait:
  public Vector getFigures() {
    return figures;
  }

  // Be�ll�tja a rajzlap aktu�lis alakzatait.
  public void setFigures(Vector figures) {
    clear();
    this.figures = figures;
    repaint();
  }

  // A rajzlap kirajzol�sa (elk�sz�t�se):
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawGrid(g);
    for (int i = 0; i < figures.size(); i++) {
      Figure fig = (Figure)figures.get(i);
      fig.draw(g);
    }
  }

  // A r�cs s�r�s�g�nek be�ll�t�sa:
  public void setGridStep(int x, int y) {
    gridStepX = x;
    gridStepY = y;
    repaint();   // �jrarajzol�s az �j s�r�s�ggel
  }

  // A r�cs (grid) kirajzol�sa (pontoz�s), ha a r�cs l�that�:
  void drawGrid(Graphics g) {
    if (!gridVisible)
      return;

    g.setColor(Color.black);
    for (int x=0; x<getWidth(); x+=gridStepX)
      for (int y=0; y<getHeight(); y+=gridStepY) {
        g.fillOval(x,y,1,1);
      }
    for (int y=0; y<getHeight(); y+=gridStepY) {
      for (int x=0; x<getWidth(); x+=gridStepX) {
        g.fillOval(x,y,1,1);
      }
    }
  }

  // Egy pont x koordin�t�j�nak t�vols�ga a legk�zelebbi r�cst�l v�zszintesen:
  int distanceToGridX(int x) {
    int d = x % gridStepX;
    if (d < gridStepX/2)
      return -d;
    else
      return gridStepX-d;
  }

  // Egy pont y koordin�t�j�nak t�vols�ga a legk�zelebbi r�cst�l f�gg�legesen:
  int distanceToGridY(int y) {
    int d = y % gridStepY;
    if (d < gridStepY/2)
      return -d;
    else
      return gridStepY-d;
  }

  // �j alakzat hozz�ad�sa a rajzlaphoz:
  public void add(Figure figure) {
    stateChanged();
    figures.add(figure);
    repaint();
  }

  // Egy megl�v� alakzat t�rl�se a rajzlapr�l:
  public void remove(Figure figure) {
    stateChanged();
    figures.remove(figure);
    repaint();
  }

  // Az �sszes alakzat (a rajzlap) t�rl�se.
  public void removeAll() {
    if (figures.isEmpty())
      return;

    stateChanged();
    figures.clear();
    repaint();
  }

  // Visszaadja a kiv�lasztott alakzatokat:
  public Vector selectedFigures() {
    Vector selectedFigures = new Vector();
    Figure figure;
    for (int i = 0; i < figures.size(); i++) {
      figure = (Figure)figures.get(i);
      if (figure.isSelected())
        selectedFigures.add(figure);
    }
    return selectedFigures;
  }

  // A kijel�lt alakzatok t�rl�se a rajzlapr�l:
  public void removeAllSelected() {
    if (selectedFigures().isEmpty())
      return;

    stateChanged();
    ListIterator iter = figures.listIterator();
    Figure figure = null;
    while (iter.hasNext()) {
      figure = (Figure)iter.next();
      if (figure.isSelected())
        iter.remove();
    }
    repaint();
  }

  // �sszes alakzat kiv�laszt�sa:
  public void selectAll() {
    if (figures.isEmpty())
      return;

    stateChanged();
    Figure figure;
    for (int i = 0; i < figures.size(); i++) {
      figure = (Figure)figures.get(i);
      figure.select();
    }
    repaint();
  }

  // Alakzat kiv�laszt�s�nak megsz�ntet�se:
  public void deSelectAll() {
    if (selectedFigures().isEmpty())
      return;

    stateChanged();
    ListIterator iter = figures.listIterator();
    Figure figure = null;
    while (iter.hasNext()) {
      figure = (Figure)iter.next();
      figure.deSelect();
    }
    repaint();
  }

  /* Megadja, hogy a p pont melyik alakzaton van. Ha nincs alatta
   * alakzat, akkor null-t ad vissza. A legfels� alakzatot akarjuk
   * megtal�lni el�sz�r, ez�rt a keres�s visszafel� indul. */
  public Figure figureAtPoint(Point p) {
    Figure figure;
    for (int i=figures.size()-1; i>=0; i--) {
      figure = (Figure)figures.get(i);
      if (figure.near(p))
        return figure;
    }
    return null;
  }

  // Megadja, hogy a rajzlapot m�dos�tott�k-e:
  public boolean isModified() {
    return !origFigures.equals(figures);
  }

  /* A rajzlap m�dos�t�s�nak kiindul�si �llapotba hoz�sa.
   * Ezut�n az isModified false �rt�ket ad vissza:
   */
  public void setModified(boolean modified) {
    if (!modified)
      origFigures = new Vector(figures);
  }

  // Csak tesztel�shez:
  void printStates() {
    System.out.println("state size= "+states.size());
    System.out.println("state index= "+stateIndex);
    System.out.println("figures= "+figures);
    for (int i = 0; i < states.size(); i++) {
      System.out.println(i+". "+states.get(i));
    }
  }

  /* Az �llapot megv�ltozott. Megjegyezz�k az el�z� �llapotot a redo/undo -hoz.
   * Duplik�ljuk az el�z� �llapotot, �s az �j lesz az aktu�lis �llapot. */
  protected void stateChanged() {
    // A stateIndex feletti �llapotok t�rl�se:
    for (int i=states.size()-1; i>stateIndex; i--)
      states.remove(i);

    /* Az utols� �llapotot �ttessz�k egy k�vetkez� �llapotba.
     * A figures vektort kl�nozni kell, m�gpedig m�ly kl�noz�ssal,
     * egy�bk�nt az elemek k�z�sek lesznek. */
    Vector cloneFigures = new Vector();
    try {
      for (int i = 0; i < figures.size(); i++) {
        cloneFigures.add( ( (Figure) figures.get(i)).clone());
      }
    }
    catch (CloneNotSupportedException ex) {
      // Nem fordul el�, mert a Figure kl�nozhat�:
      extra.hu.HuOptionPane.showMessageDialog(this,"Hiba! "+ex);
    }
    states.add(cloneFigures);
    figures = cloneFigures;
    stateIndex++;
  }

  // Az objektum alap�llapotba hoz�sa, vagyis "ki�r�t�se":
  public void clear() {
    states.clear();
    figures = new Vector();
    states.add(figures);
    stateIndex = 0;
    setBackground(SystemColor.window);
    repaint();
  }

  /* undo. Visszavon�s. Az el�z� �llapot vissza�ll�t�sa
   * (az el�z� alakzatlista kirajzol�sa): */
  public void undo(){
    if (stateIndex>=1){
      stateIndex--;
      figures = (Vector)states.get(stateIndex);
      repaint();
    }
  }

  // redo. Ism�t. A visszavont �llapot helyre�ll�t�sa:
  public void redo(){
    // Ha m�g nem rontottuk el a k�vetkez� �llapotot, vissza�ll�tjuk:
    if (stateIndex < states.size()-1){
      stateIndex++;
      figures = (Vector)states.get(stateIndex);
      repaint();
    }
  }

  /* Az objektum ki�r�sa szerializ�ci�val.
   * Sajnos a szerializ�lt objektum nem kompatibilis egy k�s�bbi API-val.
   */
  public void writeToFile(File file) throws Exception {
    ObjectOutputStream out =
       new ObjectOutputStream(new FileOutputStream(file));

    out.writeObject(figures);
    out.writeObject(getBackground());
    out.close();
    setModified(false);
  }

  /* A szerializ�lt objektum beolvas�sa:
   */
  public void readFromFile(File file) throws Exception {
    ObjectInputStream in =
        new ObjectInputStream(new FileInputStream(file));
    figures = (Vector)in.readObject();
    setBackground((Color)in.readObject());
    in.close();
    clear();
    repaint();
    setModified(false);
  }

  /* SELECT m�dban, ha az eg�r egy alakzat felett "h�z el",
   * akkor az eg�rkurzor megv�ltozik. */
  public void mouseMoved(MouseEvent e) {
    if (drawingMode != SELECT_MODE)
      return;

    Figure figure = figureAtPoint(e.getPoint());
    if (figureAtPoint(e.getPoint()) != null)
      setCursor(selectCursor);
    else
      setCursor(drawCursor);
  }

  /* Alakzat kiv�laszt�sa.
   * Ha nem alakzaton kattintanak, akkor megsz�nik minden kijel�l�s.
   * Ha egy alakzaton kattintanak, akkor ha nem volt kiv�lasztva,
   * most ki lesz v�lasztva, ha ki volt v�lasztva, akkor
   * megsz�nik a kiv�laszt�s. */
  public void mouseClicked(MouseEvent e) {
    if (drawingMode != SELECT_MODE)
      return;

    // Az alakzat, amelyen kattintottak:
    Figure figure = figureAtPoint(e.getPoint());

    // Mell�kattintottak:
    if (figure == null) {
      deSelectAll();
      return;
    }

    // Alakzaton kattintottak:
    stateChanged();
    figure = figureAtPoint(e.getPoint());
    if (figure.isSelected())
      figure.deSelect();
    else
      figure.select();

    repaint();
  }

  // Lenyomt�k az egeret, kezd�dik a rajzol�s. L�trehozzuk az alakzatot:
  public void mousePressed(MouseEvent e) {
    if (drawingMode == SELECT_MODE)
      return;

    // Ha van r�cspontra igaz�t�s, akkor a pontot r�tessz�k a legk�zelebbi r�cspontra:
    if (gridAlign)
      e.translatePoint(distanceToGridX(e.getX()),distanceToGridY(e.getY()));

    // L�trehozzuk az alakzatot a rajzol�si m�dt�l f�gg�en. Az alakzat egyel�re pontszer�.
    switch (drawingMode) {
      case LINE_MODE: figure = new Line(e.getPoint(),color); break;
      case RECT_MODE: figure = new Rect(e.getPoint(),color); break;
      case OVAL_MODE: figure = new Oval(e.getPoint(),color); break;
      case FREELINE_MODE: figure = new FreeLine(e.getPoint(),color); break;
    }
  }

  /* Elengedt�k az egeret, az alakzat kialakult. Kirajzoljuk
   * az alakzatot, �s hozz�adjuk a t�bbi alakzat list�j�hoz.
   */
  public void mouseReleased(MouseEvent e) {
    if (drawingMode == SELECT_MODE)
      return;

    Graphics g = getGraphics();
    g.setColor(color);
    figure.draw(g);
    add(figure);
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  // Vonszolj�k az egeret. Az alakzat kialak�t�sa:
  public void mouseDragged(MouseEvent e) {
    if (drawingMode == SELECT_MODE)
      return;

    Graphics g = getGraphics();
    g.setColor(color);
    g.setXORMode(getBackground());
    // Az el�z� alakzat t�rl�se XOR m�dban:
    figure.draw(g);
    if (gridAlign)
      // Az eg�r poz�ci�j�nak r�csra igaz�t�sa:
      e.translatePoint(distanceToGridX(e.getX()),distanceToGridY(e.getY()));
    // Alakzat v�gpontj�nak m�dos�t�sa:
    figure.setEndPoint(e.getPoint());
    // Az alakzat kirajzol�sa XOR m�dban:
    figure.draw(g);
  }

}
