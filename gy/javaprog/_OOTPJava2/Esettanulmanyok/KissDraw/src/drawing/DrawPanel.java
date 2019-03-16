/*
 * Projekt: KissDraw
 *
 * Csomag: drawing
 * DrawPanel.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java 2. kötet
 * 2002.09.01.
 */

package drawing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import extra.util.Savable;

// Rajzlap. Tartalmazza az alakzatok listáját (figures).
public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener, Savable {

  // Rajzolási módok. A drawingMode lehetséges értékei:
  public static final int LINE_MODE = 10;
  public static final int RECT_MODE = 20;
  public static final int OVAL_MODE = 30;
  public static final int FREELINE_MODE = 40;
  public static final int SELECT_MODE = 50;

  private int drawingMode = LINE_MODE;    // aktuális rajzolási mód
  private boolean gridVisible = false;    // látható-e a rács
  private boolean gridAlign = false;      // rácsra igazítás van-e
  private int gridStepX=10, gridStepY=10; // a rács sûrûsége
  private Color color = Color.black;      // a rajzpanel rajzolószíne

  // A panelen levõ alakzatok:
  private Vector figures = new Vector();

  /* Az alakzatok vektorának egymás utáni állapotai.
   * Az undo/redo (visszavonás/ismét) funkció használja: */
  private transient Vector states = new Vector();
  private transient int stateIndex = -1;  // az aktuális állapot indexe

  /* Megváltozott a rajzlap, ha figures!=origFigures.
   * A setModified és az isModified() használja: */
  private transient Vector origFigures = new Vector();

  private transient Figure figure;     // az aktuális alakzat
  private transient Point startPoint;  // az aktuális alakzat kezdõpontja

  // Normál egérkurzor:
  private transient Cursor drawCursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
  // Ha az egér egy alakzat fölé kerül, ilyen lesz a kurzor:
  private transient Cursor selectCursor = new Cursor(Cursor.MOVE_CURSOR);


  // Konstruktor. Létrejön egy üres rajzlap.
  public DrawPanel() {
    // A rajzpanel figyelni fogja az egéreseményeket:
    addMouseListener(this);
    addMouseMotionListener(this);
    setCursor(drawCursor);
    clear(); // rajzlap alapállapot
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

  // Visszaadja a rajzlap aktuális alakzatait:
  public Vector getFigures() {
    return figures;
  }

  // Beállítja a rajzlap aktuális alakzatait.
  public void setFigures(Vector figures) {
    clear();
    this.figures = figures;
    repaint();
  }

  // A rajzlap kirajzolása (elkészítése):
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawGrid(g);
    for (int i = 0; i < figures.size(); i++) {
      Figure fig = (Figure)figures.get(i);
      fig.draw(g);
    }
  }

  // A rács sûrûségének beállítása:
  public void setGridStep(int x, int y) {
    gridStepX = x;
    gridStepY = y;
    repaint();   // újrarajzolás az új sûrûséggel
  }

  // A rács (grid) kirajzolása (pontozás), ha a rács látható:
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

  // Egy pont x koordinátájának távolsága a legközelebbi rácstól vízszintesen:
  int distanceToGridX(int x) {
    int d = x % gridStepX;
    if (d < gridStepX/2)
      return -d;
    else
      return gridStepX-d;
  }

  // Egy pont y koordinátájának távolsága a legközelebbi rácstól függõlegesen:
  int distanceToGridY(int y) {
    int d = y % gridStepY;
    if (d < gridStepY/2)
      return -d;
    else
      return gridStepY-d;
  }

  // Új alakzat hozzáadása a rajzlaphoz:
  public void add(Figure figure) {
    stateChanged();
    figures.add(figure);
    repaint();
  }

  // Egy meglévõ alakzat törlése a rajzlapról:
  public void remove(Figure figure) {
    stateChanged();
    figures.remove(figure);
    repaint();
  }

  // Az összes alakzat (a rajzlap) törlése.
  public void removeAll() {
    if (figures.isEmpty())
      return;

    stateChanged();
    figures.clear();
    repaint();
  }

  // Visszaadja a kiválasztott alakzatokat:
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

  // A kijelölt alakzatok törlése a rajzlapról:
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

  // Összes alakzat kiválasztása:
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

  // Alakzat kiválasztásának megszüntetése:
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
   * alakzat, akkor null-t ad vissza. A legfelsõ alakzatot akarjuk
   * megtalálni elõször, ezért a keresés visszafelé indul. */
  public Figure figureAtPoint(Point p) {
    Figure figure;
    for (int i=figures.size()-1; i>=0; i--) {
      figure = (Figure)figures.get(i);
      if (figure.near(p))
        return figure;
    }
    return null;
  }

  // Megadja, hogy a rajzlapot módosították-e:
  public boolean isModified() {
    return !origFigures.equals(figures);
  }

  /* A rajzlap módosításának kiindulási állapotba hozása.
   * Ezután az isModified false értéket ad vissza:
   */
  public void setModified(boolean modified) {
    if (!modified)
      origFigures = new Vector(figures);
  }

  // Csak teszteléshez:
  void printStates() {
    System.out.println("state size= "+states.size());
    System.out.println("state index= "+stateIndex);
    System.out.println("figures= "+figures);
    for (int i = 0; i < states.size(); i++) {
      System.out.println(i+". "+states.get(i));
    }
  }

  /* Az állapot megváltozott. Megjegyezzük az elõzõ állapotot a redo/undo -hoz.
   * Duplikáljuk az elõzõ állapotot, és az új lesz az aktuális állapot. */
  protected void stateChanged() {
    // A stateIndex feletti állapotok törlése:
    for (int i=states.size()-1; i>stateIndex; i--)
      states.remove(i);

    /* Az utolsó állapotot áttesszük egy következõ állapotba.
     * A figures vektort klónozni kell, mégpedig mély klónozással,
     * egyébként az elemek közösek lesznek. */
    Vector cloneFigures = new Vector();
    try {
      for (int i = 0; i < figures.size(); i++) {
        cloneFigures.add( ( (Figure) figures.get(i)).clone());
      }
    }
    catch (CloneNotSupportedException ex) {
      // Nem fordul elõ, mert a Figure klónozható:
      extra.hu.HuOptionPane.showMessageDialog(this,"Hiba! "+ex);
    }
    states.add(cloneFigures);
    figures = cloneFigures;
    stateIndex++;
  }

  // Az objektum alapállapotba hozása, vagyis "kiürítése":
  public void clear() {
    states.clear();
    figures = new Vector();
    states.add(figures);
    stateIndex = 0;
    setBackground(SystemColor.window);
    repaint();
  }

  /* undo. Visszavonás. Az elõzõ állapot visszaállítása
   * (az elõzõ alakzatlista kirajzolása): */
  public void undo(){
    if (stateIndex>=1){
      stateIndex--;
      figures = (Vector)states.get(stateIndex);
      repaint();
    }
  }

  // redo. Ismét. A visszavont állapot helyreállítása:
  public void redo(){
    // Ha még nem rontottuk el a következõ állapotot, visszaállítjuk:
    if (stateIndex < states.size()-1){
      stateIndex++;
      figures = (Vector)states.get(stateIndex);
      repaint();
    }
  }

  /* Az objektum kiírása szerializációval.
   * Sajnos a szerializált objektum nem kompatibilis egy késõbbi API-val.
   */
  public void writeToFile(File file) throws Exception {
    ObjectOutputStream out =
       new ObjectOutputStream(new FileOutputStream(file));

    out.writeObject(figures);
    out.writeObject(getBackground());
    out.close();
    setModified(false);
  }

  /* A szerializált objektum beolvasása:
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

  /* SELECT módban, ha az egér egy alakzat felett "húz el",
   * akkor az egérkurzor megváltozik. */
  public void mouseMoved(MouseEvent e) {
    if (drawingMode != SELECT_MODE)
      return;

    Figure figure = figureAtPoint(e.getPoint());
    if (figureAtPoint(e.getPoint()) != null)
      setCursor(selectCursor);
    else
      setCursor(drawCursor);
  }

  /* Alakzat kiválasztása.
   * Ha nem alakzaton kattintanak, akkor megszûnik minden kijelölés.
   * Ha egy alakzaton kattintanak, akkor ha nem volt kiválasztva,
   * most ki lesz választva, ha ki volt választva, akkor
   * megszûnik a kiválasztás. */
  public void mouseClicked(MouseEvent e) {
    if (drawingMode != SELECT_MODE)
      return;

    // Az alakzat, amelyen kattintottak:
    Figure figure = figureAtPoint(e.getPoint());

    // Mellékattintottak:
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

  // Lenyomták az egeret, kezdõdik a rajzolás. Létrehozzuk az alakzatot:
  public void mousePressed(MouseEvent e) {
    if (drawingMode == SELECT_MODE)
      return;

    // Ha van rácspontra igazítás, akkor a pontot rátesszük a legközelebbi rácspontra:
    if (gridAlign)
      e.translatePoint(distanceToGridX(e.getX()),distanceToGridY(e.getY()));

    // Létrehozzuk az alakzatot a rajzolási módtól függõen. Az alakzat egyelõre pontszerû.
    switch (drawingMode) {
      case LINE_MODE: figure = new Line(e.getPoint(),color); break;
      case RECT_MODE: figure = new Rect(e.getPoint(),color); break;
      case OVAL_MODE: figure = new Oval(e.getPoint(),color); break;
      case FREELINE_MODE: figure = new FreeLine(e.getPoint(),color); break;
    }
  }

  /* Elengedték az egeret, az alakzat kialakult. Kirajzoljuk
   * az alakzatot, és hozzáadjuk a többi alakzat listájához.
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

  // Vonszolják az egeret. Az alakzat kialakítása:
  public void mouseDragged(MouseEvent e) {
    if (drawingMode == SELECT_MODE)
      return;

    Graphics g = getGraphics();
    g.setColor(color);
    g.setXORMode(getBackground());
    // Az elõzõ alakzat törlése XOR módban:
    figure.draw(g);
    if (gridAlign)
      // Az egér pozíciójának rácsra igazítása:
      e.translatePoint(distanceToGridX(e.getX()),distanceToGridY(e.getY()));
    // Alakzat végpontjának módosítása:
    figure.setEndPoint(e.getPoint());
    // Az alakzat kirajzolása XOR módban:
    figure.draw(g);
  }

}
