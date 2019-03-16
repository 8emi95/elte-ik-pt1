/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vadaszbead.view;
import java.awt.Color;
import vadaszbead.model.Engine;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Zsoci
 */
public class Frame extends JFrame{
    
    private Engine engine;
    private GridLayout tableLayout;
    
    public Frame(Engine engine) {
        super("Vadász");
        this.engine = engine;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800,800));
        tableLayout = new GridLayout();
        getContentPane().setLayout(tableLayout);
    }
    
    public void showFrame(){
        pack();
        setMenu();
        setVisible(true);
        
    }
    
    private void setMenu() {
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("Game");
        JMenu points = new JMenu("Hátralévő lépések: ");
	menuBar.add(menu);
        menuBar.add(points);
	for(int i = 3; i < 8; i = i + 2) {
            addMenuItem(menu,i);
        }
	
	setJMenuBar(menuBar);
    }
    
    private void addMenuItem(JMenu menu, int size) {
	JMenuItem menuItem = new JMenuItem("Start " + Integer.toString(size) + "x" + Integer.toString(size));
	menuItem.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		engine.newGame(size);
		createFields();
	    }
	});
	menu.add(menuItem);
    }
    
    private void createFields() {
        for(int i=getContentPane().getComponentCount()-1;i>=0;i--) {
            getContentPane().remove(i);
        }
        tableLayout.setColumns(engine.getSize());
        tableLayout.setRows(engine.getSize());
        for(int i=0;i < engine.getSize();++i){
            for(int j=0;j < engine.getSize();++j){
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(80, 80));
                button.setEnabled(false);
                if(i % (engine.getSize()-1) == 0 && j % (engine.getSize()-1) == 0) {
                    button.setEnabled(true);
                }
                addActionListener(button, i,j);
                button.setVisible(true);
                getContentPane().add(button);
            }
        }
        
        draw();
    }
    
    private void draw() {
        for(int i=0;i < engine.getSize();++i){
            for(int j=0;j < engine.getSize();++j){
                Engine.field fieldType = engine.getField(i, j);
                switch(fieldType) {
                    case ATTACKER : {
                        ((JButton) getContentPane().getComponent(i * engine.getSize() + j)).setBackground(Color.RED);
                        break;
                    }
                    case DEFENDER : {
                        ((JButton) getContentPane().getComponent(i * engine.getSize() + j)).setBackground(Color.GREEN);
                        break;
                    }
                    case WAY : {
                        ((JButton) getContentPane().getComponent(i * engine.getSize() + j)).setBackground(Color.WHITE);
                        break;
                    }
                }
            }
        }
        ((JMenu)this.getJMenuBar().getComponent(1)).setText("Hátralévő lépések: "+engine.getStepCount());
        validate();
    }
    
    private void addActionListener(JButton button, int i, int j) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine.field fieldType = engine.getField(i, j);
                switch(fieldType) {
                    case ATTACKER : {
                        engine.preStep(i, j);
                        for(int ii = 0; ii <= engine.getSize()-1; ii++) {
                            for(int jj = 0; jj <= engine.getSize()-1; jj++) {
                                if(engine.getField(ii, jj) != Engine.field.ATTACKER) {
                                    getContentPane().getComponent(ii * engine.getSize() + jj).setEnabled(false);
                                    if(engine.getField(ii, jj) == Engine.field.WAY) {
                                       getContentPane().getComponent(ii * engine.getSize() + jj).setBackground(Color.WHITE); 
                                    }   
                                }
                                else {
                                    getContentPane().getComponent(ii * engine.getSize() + jj).setEnabled(true);
                                }
                            }
                        }
                        
                        for(int ii = -1; ii <= 1; ii++) {
                            for(int jj = -1; jj <= 1; jj++) {
                                if((!(ii == 0 && jj == 0)) &&
                                   ((i + ii) >= 0 && (j+jj)>= 0 && (i + ii) < engine.getSize() &&(j+jj) < engine.getSize()) &&
                                    engine.getField(i+ii, j+jj) == Engine.field.WAY) {
                                    getContentPane().getComponent((i + ii)* engine.getSize() + j+jj).setEnabled(true);
                                    getContentPane().getComponent((i + ii)* engine.getSize() + j+jj).setBackground(Color.cyan);
                                }
                            }
                        }
                        break;
                    }
                    case DEFENDER : {
                        engine.preStep(i, j);
                        for(int ii = -1; ii <= 1; ii++) {
                            for(int jj = -1; jj <= 1; jj++) {
                                if(!(ii == 0 && jj == 0) &&
                                    ((i + ii) >= 0 && (j+jj)>= 0 && (i + ii) < engine.getSize() &&(j+jj) < engine.getSize()) &&
                                     engine.getField(i+ii, j+jj) == Engine.field.WAY) {
                                     getContentPane().getComponent((i + ii)* engine.getSize() + j+jj).setEnabled(true);
                                     getContentPane().getComponent((i + ii)* engine.getSize() + j+jj).setBackground(Color.cyan);
                                }
                            }
                        }
                        break;
                    }
                    case WAY : {
                        engine.step(i, j);
                        for(int ii = 0; ii <= engine.getSize()-1; ii++) {
                            for(int jj = 0; jj <= engine.getSize()-1; jj++) {
                                if(engine.getField(ii, jj) == Engine.field.WAY) {
                                    getContentPane().getComponent(ii * engine.getSize() + jj).setEnabled(false);
                                    getContentPane().getComponent(ii * engine.getSize() + jj).setBackground(Color.WHITE); 
                                }
                                if(engine.getField(ii, jj) != engine.getCurrentPlayer()) {
                                    getContentPane().getComponent(ii * engine.getSize() + jj).setEnabled(false);
                                }
                                if(engine.getField(ii, jj) == engine.getCurrentPlayer()) {
                                    getContentPane().getComponent(ii * engine.getSize() + jj).setEnabled(true);
                                }
                            }
                        }
                        draw();
                        checkVictoryCondition();
                        break;
                    }
                }
            }
        });
    }
    
    private void checkVictoryCondition() {
        if (engine.isGameOverAttacker()) {
            JOptionPane.showMessageDialog(this, "A menekülő játékos győzött.");
            engine.newGame(engine.getSize());
            createFields();
        }
        
        if (engine.isGameOverDefender()) {
            JOptionPane.showMessageDialog(this, "A támadó játékos győzött.");
            engine.newGame(engine.getSize());
            createFields();
        }
    }
}
