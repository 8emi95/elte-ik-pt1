package hu.elte.prt.landmine.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hu.elte.prt.landmine.model.LandMineEngine;
import hu.elte.prt.landmine.model.LandMineListener;

public class LandMineFrame extends JFrame implements LandMineListener {

    private static final long serialVersionUID = -4719982511600549413L;

    private LandMineEngine engine;
    private JPanel gridPanel;

    public LandMineFrame(LandMineEngine engine) {
	super("Land Mine");
	this.engine = engine;
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showFrame() {
	getContentPane().setLayout(new BorderLayout(10, 10));
	getContentPane().add(getMenuPanel(), BorderLayout.NORTH);
	getContentPane().add(getGridPanel(), BorderLayout.CENTER);
	pack();
	setVisible(true);
    }

    private Component getMenuPanel() {
	JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JButton newGame = new JButton("New Game");
	newGame.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		engine.startNewGame();
	    }
	});
	JButton undo = new JButton("Undo");
	undo.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		engine.undo();
	    }
	});
	menuPanel.add(newGame);
	menuPanel.add(undo);
	return menuPanel;
    }

    private Component getGridPanel() {
	gridPanel = new JPanel();
	gridPanel.setLayout(new GridLayout(engine.getSize(), engine.getSize()));
	addFieldsToGrid();
	return gridPanel;
    }

    private void addFieldsToGrid() {
	for (int i = 0; i < engine.getSize(); ++i) {
	    for (int j = 0; j < engine.getSize(); ++j) {
		FieldButton field = new FieldButton(i, j);
		addActionListener(field, i, j);
		gridPanel.add(field);
	    }
	}
	updateFields();
    }

    private void addActionListener(FieldButton field, int i, int j) {
	field.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		engine.step(i, j);
	    }
	});
    }

    @Override
    public void updateFields() {
	if (null != gridPanel) {
	    for (Component c : gridPanel.getComponents()) {
		FieldButton field = (FieldButton) c;
		field.setText(getText(field.getRow(), field.getColumn()));
		field.setBackground(getBackground(field.getRow(), field.getColumn()));
	    }
	}
    }

    private String getText(int row, int column) {
	return engine.isPlayerHere(row, column) ? "X" : "";
    }

    private Color getBackground(int row, int column) {
	if (engine.hasMine(row, column)) {
	    return Color.MAGENTA;
	}
	return engine.isVisited(row, column) ? Color.LIGHT_GRAY : Color.WHITE;
    }

    @Override
    public void end(boolean outcome) {
	if (outcome) {
	    JOptionPane.showMessageDialog(this, "You won.");
	} else {
	    JOptionPane.showMessageDialog(this, "You lost.");
	}
    }

}
