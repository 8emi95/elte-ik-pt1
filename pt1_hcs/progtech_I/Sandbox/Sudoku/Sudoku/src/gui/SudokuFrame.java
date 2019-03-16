package sudoku.gui;

import sudoku.logic.SudokuLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SudokuFrame extends JFrame{

    private SudokuBoard sudokuBoard;
    private final JLabel timerLabelText;
    private final JLabel timerLabel;
    private final SudokuLogic logic;
    private Timer timer;

    public SudokuFrame(final SudokuLogic logic){
        setFrameProperties();
        applyNimbusLookAndFeelTheme();
        this.logic = logic;

        timerLabelText = new JLabel("Elapsed time: ");
        timerLabel = new JLabel("     ");

        // A gondolkodási időt mutató panelt, hozzáadjuk az elrendezésünknek megfelelően északra. (Lásd java referencia.)
        getContentPane().add(createTimerPanel(), BorderLayout.NORTH);

        // Elkészítjük és beállítjuk a játékhoz tartozó menüt.
        setJMenuBar(new SodokuMenuBar());

        // Létrehozzuk a játéktáblát
        sudokuBoard = initSudokuBoard();
        // A játéktáblát tartalmazó panelt, hozzáadjuk az elrendezésünknek megfelelően középre. (Lásd java referencia.)
        getContentPane().add(sudokuBoard, BorderLayout.CENTER);

        // A komponenseinket az elrendezéseknek és a preferredSize-oknak megfelelően "összecsomagoljuk"
        pack();

        // Létrehozzuk és elindítjuk az időzítőnket
        initTimer();
    }

    /**
     * Létrehozzuk a játéktáblát 500x500-as mérettel.
     */
    private SudokuBoard initSudokuBoard(){
        final SudokuBoard sudokuBoard = new SudokuBoard(logic, this);
        sudokuBoard.setPreferredSize(new Dimension(500,500));
        return sudokuBoard;
    }

    /**
     * Létrehozunk egy gondolkodási időt számláló panelt.
     */
    private JPanel createTimerPanel(){
        final JPanel timerPanel = new JPanel();
        timerPanel.add(timerLabelText);
        timerPanel.add(timerLabel);
        timerPanel.setPreferredSize(new Dimension(500,50));
        return timerPanel;
    }

    /**
     * Létrehozunk és elindítunk egy időzítőt.
     * Fontos, hogy a javax.swing.Timer-ből hozzunk létre példányokat, mert ez megfelelően az EDT-n idéz elő eseményeket,
     * ellenben a java.util.Timer-rel, melyet főleg konzolos alkalmazások esetén használunk.
     */
    private void initTimer(){
        timer = new Timer(1000, new TimerAction(timerLabel, 0L));
        timer.start();
    }

    /**
     * Beállítjuk a kerethez tartozó fontosabb tulajdonságokat.
     */
    private void setFrameProperties(){
        setTitle("Simple Swing Sudoku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,500);
        setLocation(100,100);
        setLayout(new BorderLayout());
        setResizable(false);
    }

    /**
     * Érdekességként, lehet előre definiált témákat is használni. Ezek közül az egyik legszebb és gyakran szakdolgozatokban
     * is jól mutató téma a Nimbus.
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
     * Felugró üzenet formájában jelezzük a felhasználónak, hogy sikeresen megoldotta a játékot.
     * Mindezek előtt leállítjuk a gondolkodási idő jelzőhöz kapcsolódó számlálót, majd a legvégén egy új játékot hozunk
     * létre a játék logikájának segítségével.
     */
    void showMessageDialog(){
        timer.stop();
        JOptionPane.showMessageDialog(this, "Congratulation, you solved the puzzle!");
        logic.createNewGame();
    }

    /**
     * Létrehozunk egy új játék táblát oly módon, hogy eltávolítjuk a régi komponenst a felületről, majd a frissen létrehozottat
     * hozzáadjuk a megfelelő helyre.
     */
    private void createNewSudokuBoard(){
        getContentPane().remove(sudokuBoard);
        sudokuBoard = new SudokuBoard(logic, this);
        getContentPane().add(sudokuBoard, BorderLayout.CENTER);

    }

    /**
     * Belső osztály, ami a játékhoz kapcsolódó menü létrehozásáért felel.
     */
    private class SodokuMenuBar extends JMenuBar {
        private final JMenu gameMenu;
        private final JMenuItem newGame;

        SodokuMenuBar(){
            // Elkészítünk egy Game menü pontot
            gameMenu = new JMenu("Game");
            /* Létrehozunk egy menü elemet, melynek New game lesz a neve, ezt a hozzá kapcsolódó newGameAction eseménytől
             * veszi majd át.
             */
            newGame = new JMenuItem(newGameAction);
            // Hozzárendelhetünk egy menüponthoz egy billentyű parancsot a gyorsabb elérése érdekében.
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
