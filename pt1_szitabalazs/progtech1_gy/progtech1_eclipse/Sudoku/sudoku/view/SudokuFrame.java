package sudoku.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

import sudoku.model.SudokuEngine;
import sudoku.model.SudokuView;

public class SudokuFrame extends JFrame implements SudokuView {
    private static final long serialVersionUID = -956358773548723639L;
    private static final Color GRAY = null;
    private SudokuEngine engine;

    public void setModel(SudokuEngine engine) {
        this.engine = engine;
    }

    public void showFrame() {
        setTitle("Sudoku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(engine.getSize(), engine.getSize()));
        
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                JButton field = new JButton(Integer.toString(i) + j);
                field.setPreferredSize(new Dimension(60, 60));
                int topBorder = 1;
                int leftBorder = 1;
                int bottomBorder = 1;
                int rightBorder = 1;
                if (j % 3 == 0) {
                    leftBorder = 4;
                } else if (j == engine.getSize()-1) {
                    rightBorder = 4;
                } else if (i % 3 == 0) {
                    rightBorder = 4;
                } else if(j == engine.getSize()-1) {
                    rightBorder = 4;
                }
                field.setBorder(BorderFactory.createMatteBorder(topBorder, leftBorder, bottomBorder, rightBorder, GRAY));
                getContentPane().add(field);
            }
        }
        
        setVisible(true);
        pack();
    }

}
