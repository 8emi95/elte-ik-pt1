package hu.valdar.progtech.gy9.sudoku.gui;

import hu.valdar.progtech.gy9.sudoku.model.SudokuLogic;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.UIManager;

public class SudokuFrame extends JFrame{
    private SudokuBoard sudokuBoard;
    private final JMenuBar sudokuMenuBar;
    private final JLabel timerLabelText;
    private final JLabel timerLabel;
    private final SudokuLogic logic;
    private Timer timer;
    
    public SudokuFrame(final SudokuLogic logic){
        setFrameProperties();
        applyNimbusLookAndFeelTheme();
        this.logic = logic;
        
        sudokuMenuBar = new SodokuMenuBar(); // Létrehozunk egy példányt a menünkből
        timerLabelText = new JLabel("Elapsed time: "); // Létrehozunk egy cimkét a paraméterben átadott szöveggel
        timerLabel = new JLabel("     ");
        final JPanel timerPanel = new JPanel(); // Létrehozunk egy panelt, amiben az eltelt időhöz kapcsolódó komponenseket tároljuk 
        timerPanel.add(timerLabelText); // Hozzáadjuk a cimkéket a panelhez. (Mivel nem állítottunk elrendezést, így alapértelmezetten FlowLayout lesz) 
        timerPanel.add(timerLabel);
        timerPanel.setPreferredSize(new Dimension(500,50)); // Beállítjuk a méretét a panelnak 
        getContentPane().add(timerPanel, BorderLayout.NORTH); // Hozzáadjuk elrendezésnek megfelelően a panelt a frame-hez.
        
        setJMenuBar(sudokuMenuBar);  // Beállítjuk a menüt      
        
        sudokuBoard = new SudokuBoard(logic, this); // Létrehozunk egy példányt a grafikus komponensekből álló játéktáblából.
        sudokuBoard.setPreferredSize(new Dimension(500,500)); // Beállítjuk a méretét.
        getContentPane().add(sudokuBoard, BorderLayout.CENTER); // Hozzáadjuk az elrendezésnek megfelelően
        
        pack(); // BorderLayout elrendezés esetén a méretek beállítása miatt meg kell hívni, miután elrendeztük a komponenseinket.
        timer = new Timer(1000, new TimerAction(timerLabel, 0L)); // Létrehozunk egy időzítőt, amely másodpercenként lefuttatja a saját akciónkat.
        timer.start(); // Elindítjuk az időzítőt
    }
    
    /**
     * Segédfüggvény az alapvető keretbeállításokhoz.
     */
    private void setFrameProperties(){
        setTitle("Simple Swing Sudoku"); // Ablak fejlécében megjelenő szöveg
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Mi történjen az ablak bezárásakor
        setSize(600,500); // Ablak méretének beállítása
        setLocation(100,100); // Az elhelyezkedésének beállítása (Eltolás bal felső ponttól)
        setLayout(new BorderLayout()); // Elrendezés beállítása: 4 égtáj + közép
        setResizable(false); // Átméretezhetőség beállítása
    }
    
    /**
     * Érdekességként, lehet előre definiált témákat is használni. Ezek közül szerintem az egyik legszebb a Nimbus
     */
    private void applyNimbusLookAndFeelTheme(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }        
    }
    
    /**
     * Amennyiben a játékos győzött jelenítsük meg egy felugró ablak segítségével.
     * Állítsuk meg az időzítőt és hozzunk létre egy új játékot.
     */
    public void showMessageDialog(){
        timer.stop();
        JOptionPane.showMessageDialog(this, "Congratulation, you solved the puzzle!");
        logic.createNewGame();
    }    
    
    /**
     * Új grafikus játéktábla létrehozása
     */
    private void createNewSudokuBoard(){
        getContentPane().remove(sudokuBoard);
        sudokuBoard = new SudokuBoard(logic, this);
        getContentPane().add(sudokuBoard, BorderLayout.CENTER);
        
    }  
    
    /**
     * Saját menü. Az egyszerűség kedvéért most belső osztályként megvalósítva.
     */
    private class SodokuMenuBar extends JMenuBar{
        private final JMenu gameMenu;
        private final JMenuItem newGame;
        
        public SodokuMenuBar(){
            gameMenu = new JMenu("Game");
            newGame = new JMenuItem(newGameAction);
            newGame.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            gameMenu.add(newGame);
            

            add(gameMenu);
            
        }
              
        private final Action newGameAction = new AbstractAction("New game") {

            @Override
            public void actionPerformed(ActionEvent ae) {
                timer.stop();
                timer = new Timer(1000, new TimerAction(timerLabel, 0L));
                logic.createNewGame();
                createNewSudokuBoard();
                timer.start();
            }
        };
        
    }    
}
