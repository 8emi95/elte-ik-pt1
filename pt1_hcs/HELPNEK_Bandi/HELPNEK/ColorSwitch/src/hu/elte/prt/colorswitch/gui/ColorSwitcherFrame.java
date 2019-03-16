package hu.elte.prt.colorswitch.gui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hu.elte.prt.colorswitch.model.ColorSwitcherEngine;
import hu.elte.prt.colorswitch.model.ColorSwitcherGUI;

public class ColorSwitcherFrame extends JFrame implements ColorSwitcherGUI {

    private static final long serialVersionUID = 5598887483086311183L;

    private ColorSwitcherEngine engine;
    private JPanel grid;

    public ColorSwitcherFrame(ColorSwitcherEngine engine) {
	super("Color Switcher Game");
	this.engine = engine;
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showFrame() {
	getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	getContentPane().add(createButtonPanel());
	getContentPane().add(createGridPanel());
	pack();
	setVisible(true);
    }

    private JPanel createButtonPanel() {
	JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JButton newGame = new JButton("New Game");
	addNewGameListener(newGame);
	panel.add(newGame);
	return panel;
    }

    private void addNewGameListener(JButton newGame) {
	newGame.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		engine.newGame();
	    }
	});
    }

    private JPanel createGridPanel() {
	grid = new JPanel(new GridLayout(engine.getSize(), engine.getSize()));
	for (int i = 0; i < engine.getSize(); ++i) {
	    for (int j = 0; j < engine.getSize(); ++j) {
		addField(i, j);
	    }
	}
	return grid;
    }

    private void addField(int i, int j) {
	Field field = new Field(i, j, engine.getColorOfField(i, j));
	addFieldListeners(i, j, field);
	grid.add(field);
    }

    private void addFieldListeners(int i, int j, Field selectedField) {
	selectedField.addMouseListener(new FieldMouseListener(this, selectedField));
	addFieldActionListener(i, j, selectedField);
    }

    private void addFieldActionListener(int i, int j, Field selectedField) {
	selectedField.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		engine.clicked(i, j);
	    }
	});
    }

    @Override
    public void update() {
	for (Component c : grid.getComponents()) {
	    Field field = (Field) c;
	    field.setColor(engine.getColorOfField(field.getRow(), field.getColumn()));
	}
    }

    @Override
    public void won(int clickCount) {
	JOptionPane.showMessageDialog(this, "You won.\nSteps needed: " + clickCount + ".");
	engine.newGame();
    }

    public JPanel getGrid() {
	return grid;
    }

    public boolean colorByRows() {
	return engine.colorByRows();
    }

}
