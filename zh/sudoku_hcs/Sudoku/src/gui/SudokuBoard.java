package sudoku.gui;

import sudoku.logic.SudokuLogic;

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
     * A Sudokuban található házak létrehozását megvalósító metódus.
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
     * A Sudokuban található 81 field létrehozását megvalósító metódus.
     */
    private void createFields(){
        fields = new SudokuButton[9][9];
        for (int y = 0; y < 9; ++y) {
            for (int x = 0; x < 9; ++x) {
                fields[y][x] = new SudokuButton(x, y);
                fields[y][x].addActionListener(onClickAction);
                // Ha egész osztást végzünk, akkor a szükséges indexeket kapjuk meg: 0/3=0, 1/3=0, 2/3=0 stb..
                grids[y / 3][x / 3].add(fields[y][x]);
            }
        }
    }

    /**
     * A gombjainkhoz rendelt esemény, mely segítségével léptetjük a logikában található mátrixban az adott fieldhez rendelt számokat,
     * majd visszaolvassuk azokat és megjelenítjük az adott gomb szövegeként. Ellenőrizzük továbbá azt is, hogy véget ért-e a játék.
     * Amennyiben véget ért, felugró ablak formájában feldobunk egy üzenetet.
     */
    private final Action onClickAction = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            // Mivel csak a táblánkon található játékgombokra kötjük rá az eseményt, így eltekinthetünk az instanceof vizsgálattól.
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
