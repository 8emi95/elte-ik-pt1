package hu.elte.prt.colorswitch.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.UIManager;

public class FieldMouseListener implements MouseListener {

    private ColorSwitcherFrame frame;
    private Field field;

    public FieldMouseListener(ColorSwitcherFrame frame, Field field) {
	this.frame = frame;
	this.field = field;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
	markBorders();
    }

    @Override
    public void mousePressed(MouseEvent e) {
	undoBorders();
    }

    @Override
    public void mouseExited(MouseEvent e) {
	undoBorders();
    }

    private void markBorders() {
	for (Component c : frame.getGrid().getComponents()) {
	    Field f = (Field) c;
	    if (shouldBeMarked(f, field)) {
		f.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
	    }
	}
    }

    private void undoBorders() {
	for (Component c : frame.getGrid().getComponents()) {
	    Field f = (Field) c;
	    if (shouldBeMarked(f, field)) {
		f.setBorder(UIManager.getBorder("Button.border"));
	    }
	}
    }

    private boolean shouldBeMarked(Field field, Field selectedField) {
	if (frame.colorByRows()) {
	    return field.getY() == selectedField.getY();
	} else {
	    return field.getX() == selectedField.getX();
	}
    }

    @Override
    public void mouseReleased(MouseEvent e) {
	// NOP
    }

    @Override
    public void mouseClicked(MouseEvent e) {
	// NOP
    }

}
