/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aknakereso.view;

import aknakereso.model.Engine;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author thalyzsofia
 */

public class Frame extends JFrame{
    private Engine engine;
    private GridLayout tableLayout;

    public Frame(Engine engine) {
        super("Aknakereső");
        this.engine = engine;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(600,600));
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
        JMenu life = new JMenu("Hátralévő élet: ");
        JMenu reStep = new JMenu("Hátralévő lépések: ");
        menuBar.add(menu);
        menuBar.add(life);
        menuBar.add(reStep);
        /*
        for(int i = 3; i < 8; i = i + 2) {
            addMenuItem(menu,i);
        }*/
        addMenuItem(menu,9);
        addMenuItem(menu,12);

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
                if(i == 0) {
                    button.setEnabled(true);
                }
                /*if(i % (engine.getSize()-1) == 0 && j % (engine.getSize()-1) == 0) {
                    button.setEnabled(true);
                }*/

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
                    case BOMB : {
                        ((JButton) getContentPane().getComponent(i * engine.getSize() + j)).setBackground(Color.LIGHT_GRAY);
                        break;
                    }
                    case FIELD : {
                        ((JButton) getContentPane().getComponent(i * engine.getSize() + j)).setBackground(Color.LIGHT_GRAY);
                        break;
                    }
                }
            }
        }
        validate();
    }

    public void drawMenu() {
        ((JMenu)this.getJMenuBar().getComponent(1)).setText("Hátralévő élet: "+engine.getLife());
        ((JMenu)this.getJMenuBar().getComponent(2)).setText("Hátralévő lépések: "+engine.getRemainSteps());
        validate();
    }

    private void addActionListener(JButton button, int i, int j) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Engine.field fieldType = engine.getField(i, j);
                switch(fieldType) {
                    case BOMB: {
                       engine.step(i, j);
                       if(engine.getRemainSteps() == 0) {
                           for(int ii = i; ii < engine.getSize(); ii++) {
                                for(int jj = 0; jj < engine.getSize(); jj++) {
                                     getContentPane().getComponent(ii * engine.getSize() + jj).setEnabled(false);
                                     if(ii == i && jj!= j && (engine.getField(ii, jj) == Engine.field.BOMB && ((JButton) getContentPane().getComponent(ii * engine.getSize() + jj)).getBackground() != Color.RED)) {
                                        ((JButton) getContentPane().getComponent(ii * engine.getSize() + jj)).setText("B");
                                        //((JButton) getContentPane().getComponent(ii * engine.getSize() + jj)).setForeground(Color.BLUE);
                                     }
                                     
                                     if(ii == i && jj!= j && (engine.getField(ii, jj) == Engine.field.FIELD && ((JButton) getContentPane().getComponent(ii * engine.getSize() + jj)).getBackground() != Color.GREEN)) {
                                       ((JButton) getContentPane().getComponent(ii * engine.getSize() + jj)).setText("A");
                                       //((JButton) getContentPane().getComponent(ii * engine.getSize() + jj)).setForeground(Color.BLUE);
                                    }
                                     
                                     if(i<engine.getSize()-1) {
                                        getContentPane().getComponent((i+1) * engine.getSize() + jj).setEnabled(true); 
                                     } 
                                }
                            }
                       }
                       ((JButton) getContentPane().getComponent(i * engine.getSize() + j)).setBackground(Color.RED);
                       getContentPane().getComponent(i * engine.getSize() + j).setEnabled(false);

                       checkVictoryCondition();
                       if(i == engine.getSize()-1) {
                            checkVictoryLastLine();
                       }
                       engine.remainStepRepair();
                       drawMenu();
                       break; 
                    }

                    case FIELD: {
                       engine.step(i, j);
                       if(engine.getRemainSteps() == 0) {
                           for(int ii = i; ii < engine.getSize(); ii++) {
                                for(int jj = 0; jj < engine.getSize(); jj++) {
                                    getContentPane().getComponent(ii * engine.getSize() + jj).setEnabled(false);
                                    if(ii == i && jj != j && (engine.getField(ii, jj) == Engine.field.FIELD && ((JButton) getContentPane().getComponent(ii * engine.getSize() + jj)).getBackground() != Color.GREEN)) {
                                       ((JButton) getContentPane().getComponent(ii * engine.getSize() + jj)).setText("A");
                                       //((JButton) getContentPane().getComponent(ii * engine.getSize() + jj)).setForeground(Color.BLUE);
                                    }

                                    if(ii == i && jj!= j && (engine.getField(ii, jj) == Engine.field.BOMB && ((JButton) getContentPane().getComponent(ii * engine.getSize() + jj)).getBackground() != Color.RED)) {
                                        ((JButton) getContentPane().getComponent(ii * engine.getSize() + jj)).setText("B");
                                        //((JButton) getContentPane().getComponent(ii * engine.getSize() + jj)).setForeground(Color.BLUE);
                                     }

                                     if(i<engine.getSize()-1) {
                                        getContentPane().getComponent((i+1) * engine.getSize() + jj).setEnabled(true);
                                     }
                                }
                            }
                       }
                       ((JButton) getContentPane().getComponent(i * engine.getSize() + j)).setBackground(Color.GREEN);
                       getContentPane().getComponent(i * engine.getSize() + j).setEnabled(false);

                       checkVictoryCondition();
                       if(i == engine.getSize()-1) {
                            checkVictoryLastLine();
                        }
                       engine.remainStepRepair();
                       drawMenu(); 
                       break; 
                    }
                }
            }
        });
        ((JMenu)this.getJMenuBar().getComponent(1)).setText("Hátralévő élet: "+engine.getLife());
        ((JMenu)this.getJMenuBar().getComponent(2)).setText("Hátralévő lépések: "+engine.getRemainSteps());
    }

    private void checkVictoryCondition() {
        if (engine.isGameOverLife()) {
            JOptionPane.showMessageDialog(this, "Vesztettél.");
            engine.newGame(engine.getSize());
            createFields();
        }
    }

    private void checkVictoryLastLine() {
        if (engine.isGameOverWin()) {
            JOptionPane.showMessageDialog(this, "Nyertél.");
            engine.newGame(engine.getSize());
            createFields();
        }
    }
}
