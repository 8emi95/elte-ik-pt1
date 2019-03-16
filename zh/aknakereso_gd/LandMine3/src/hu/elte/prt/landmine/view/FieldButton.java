package hu.elte.prt.landmine.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class FieldButton extends JButton {
    private static final long serialVersionUID = -1834537428211133070L;

    private int row;
    private int column;

    public FieldButton(int row, int column) {
        super();
        this.row = row;
        this.column = column;
        setPreferredSize(new Dimension(80, 80));
        setFont(getFont().deriveFont(30.0f));
        setBackground(Color.WHITE);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
