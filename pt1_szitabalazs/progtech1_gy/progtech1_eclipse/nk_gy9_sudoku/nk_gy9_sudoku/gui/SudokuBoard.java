package nk_gy9_sudoku.gui;

import nk_gy9_sudoku.logic.SudokuLogic;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SudokuBoard extends JPanel {

    private SudokuButton[][] fields;
    private JPanel[][] grids;
    private final SudokuLogic logic;

    private final SudokuFrame sudokuFrame;

    public SudokuBoard(final SudokuLogic logic, final SudokuFrame sudokuFrame) {
        super(new GridLayout(3, 3));
        this.logic = logic;
        this.sudokuFrame = sudokuFrame;

        createGrids();
        createFields();
    }

    /**
     * A Sudokuban tal�lhat� h�zak l�trehoz�s�t megval�s�t� met�dus.
     */
    private void createGrids() {
        grids = new JPanel[3][3];
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 3; ++x) {
                grids[y][x] = new JPanel(new GridLayout(3, 3));
                grids[y][x].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                add(grids[y][x]);
            }
        }
    }

    /**
     * A Sudokuban tal�lhat� 81 field l�trehoz�s�t megval�s�t� met�dus.
     */
    private void createFields(){
        fields = new SudokuButton[9][9];
        for (int y = 0; y < 9; ++y) {
            for (int x = 0; x < 9; ++x) {
                fields[y][x] = new SudokuButton(x, y);
                fields[y][x].addActionListener(onClickAction);
                // Ha eg�sz oszt�st v�gz�nk, akkor a sz�ks�ges indexeket kapjuk meg: 0/3=0, 1/3=0, 2/3=0 stb..
                grids[y / 3][x / 3].add(fields[y][x]);
            }
        }
    }

    /**
     * A gombjainkhoz rendelt esem�ny, mely seg�ts�g�vel l�ptetj�k a logik�ban tal�lhat� m�trixban az adott fieldhez rendelt sz�mokat,
     * majd visszaolvassuk azokat �s megjelen�tj�k az adott gomb sz�vegek�nt. Ellen�rizz�k tov�bb� azt is, hogy v�get �rt-e a j�t�k.
     * Amennyiben v�get �rt, felugr� ablak form�j�ban feldobunk egy �zenetet.
     */
    private final Action onClickAction = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            // Mivel csak a t�bl�nkon tal�lhat� j�t�kgombokra k�tj�k r� az esem�nyt, �gy eltekinthet�nk az instanceof vizsg�latt�l.
            SudokuButton btn = (SudokuButton) ae.getSource();
            final int posX = btn.getPositionX();
            final int posY = btn.getPositionY();

            logic.setFieldValue(posX, posY);
            final int value = logic.getFieldValue(posX, posY);
            btn.setText((value == 0) ? " " : String.valueOf(value));

            if (logic.checkEndGame()) {
                sudokuFrame.showMessageDialog();
            }
        }

    };
}
