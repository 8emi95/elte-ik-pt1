package nk_gy9_sudoku.gui;

import nk_gy9_sudoku.logic.SudokuLogic;

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

        // A gondolkod�si id�t mutat� panelt, hozz�adjuk az elrendez�s�nknek megfelel�en �szakra. (L�sd java referencia.)
        getContentPane().add(createTimerPanel(), BorderLayout.NORTH);

        // Elk�sz�tj�k �s be�ll�tjuk a j�t�khoz tartoz� men�t.
        setJMenuBar(new SodokuMenuBar());

        // L�trehozzuk a j�t�kt�bl�t
        sudokuBoard = initSudokuBoard();
        // A j�t�kt�bl�t tartalmaz� panelt, hozz�adjuk az elrendez�s�nknek megfelel�en k�z�pre. (L�sd java referencia.)
        getContentPane().add(sudokuBoard, BorderLayout.CENTER);

        // A komponenseinket az elrendez�seknek �s a preferredSize-oknak megfelel�en "�sszecsomagoljuk"
        pack();

        // L�trehozzuk �s elind�tjuk az id�z�t�nket
        initTimer();
    }

    /**
     * L�trehozzuk a j�t�kt�bl�t 500x500-as m�rettel.
     */
    private SudokuBoard initSudokuBoard(){
        final SudokuBoard sudokuBoard = new SudokuBoard(logic, this);
        sudokuBoard.setPreferredSize(new Dimension(500,500));
        return sudokuBoard;
    }

    /**
     * L�trehozunk egy gondolkod�si id�t sz�ml�l� panelt.
     */
    private JPanel createTimerPanel(){
        final JPanel timerPanel = new JPanel();
        timerPanel.add(timerLabelText);
        timerPanel.add(timerLabel);
        timerPanel.setPreferredSize(new Dimension(500,50));
        return timerPanel;
    }

    /**
     * L�trehozunk �s elind�tunk egy ied�z�t�t.
     * Fontos, hogy a javax.swing.Timer-b�l hozzunk l�tre p�ld�nyokat, mert ez megfelel�en az EDT-n id�z el� esem�nyeket,
     * ellenben a java.util.Timer-rel, melyet f�leg konzolos alkalmaz�sok eset�n haszn�lunk.
     */
    private void initTimer(){
        timer = new Timer(1000, new TimerAction(timerLabel, 0L));
        timer.start();
    }

    /**
     * Be�ll�tjuk a kerethez tartoz� fontosabb tulajdons�gokat.
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
     * �rdekess�gk�nt, lehet el�re defini�lt t�m�kat is haszn�lni. Ezek k�z�l az egyik legszebb �s gyakran szakdolgozatokban
     * is j�l mutat� t�ma a Nimbus.
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
     * Felugr� �zenet form�j�ban jelezz�k a felhaszn�l�nak, hogy sikeresen megoldotta a j�t�kot.
     * Mindezek el�tt le�ll�tjuk a gondolkod�si id� jelz�h�z kapcsol�d� sz�ml�l�t, majd a legv�g�n egy �j j�t�kot hozunk
     * l�tre a j�t�k logik�j�nak seg�ts�g�vel.
     */
    void showMessageDialog(){
        timer.stop();
        JOptionPane.showMessageDialog(this, "Congratulation, you solved the puzzle!");
        logic.createNewGame();
    }

    /**
     * L�trehozunk egy �j j�t�k t�bl�t oly m�don, hogy elt�vol�tjuk a r�gi komponenst a fel�letr�l, majd a frissen l�trehozottat
     * hozz�adjuk a megfelel� helyre.
     */
    private void createNewSudokuBoard(){
        getContentPane().remove(sudokuBoard);
        sudokuBoard = new SudokuBoard(logic, this);
        getContentPane().add(sudokuBoard, BorderLayout.CENTER);

    }

    /**
     * Bels� oszt�ly, ami a j�t�khoz kapcsol�d� men� l�trehoz�s��rt felel.
     */
    private class SodokuMenuBar extends JMenuBar {
        private final JMenu gameMenu;
        private final JMenuItem newGame;

        SodokuMenuBar(){
            // Elk�sz�t�nk egy Game men� pontot
            gameMenu = new JMenu("Game");
            /* L�trehozunk egy men� elemet, melynek New game lesz a neve, ezt a hozz� kapcsol�d� newGameAction esem�nyt�l
             * veszi majd �t.
             */
            newGame = new JMenuItem(newGameAction);
            // Hozz�rendelhet�nk egy men�ponthoz egy billenty� parancsot a gyorsabb el�r�se �rdek�ben.
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
