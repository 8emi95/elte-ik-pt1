/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiszuros_amoba;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author rckzz
 */
public class GameWindow extends JFrame {

    private JButton newGame;
    private GameBase base;
    int windowSize = 0;
    JLabel actualPlayerLabel;
    private HashMap<MyVector,JButton> buttonCache = new HashMap<>();
    public GameWindow(int size) {
        setSize(600, 600);
        windowSize = size;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        newGame = new JButton();
        newGame.setText("Új játék kezdése");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new MainWindow();
            }
        });
        base = new GameBase(size);
        actualPlayerLabel = new JLabel();
        actualPlayerLabel.setText("Aktuális játékos: X");
        
        JPanel framepanel = new JPanel();
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(size, size));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                addButton(gamePanel, i, j);
            }
        }
        
        framepanel.add(actualPlayerLabel);
        framepanel.add(newGame);        

        getContentPane().add(gamePanel, BorderLayout.CENTER);
        getContentPane().add(framepanel, BorderLayout.NORTH);
        setVisible(true);
    }

    private void addButton(JPanel panel, int i, int j) {
        final JButton button = new JButton();
        buttonCache.put(new MyVector(i,j),button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {                
                Player player = base.setValue(i, j);                
                base.removeElementIf(windowSize, player);  
                if(base.winnerFound()){
                    gameOver(player.name());
                }
                if(base.isDraw()) gameOver("Döntetlen");
                updateActualPlayer();
                repaintButtons();
            }
        });
        panel.add(button);
    }
    private void repaintButtons(){
        Player[][] tmptable = base.getGameTable();
        for(Entry<MyVector,JButton> x : buttonCache.entrySet()){
            MyVector coordinates = x.getKey();
            JButton refToButton = x.getValue();
            if(tmptable[coordinates.getX()][coordinates.getY()] == Player.NOBODY){
                refToButton.setText("");
            }
            else if (tmptable[coordinates.getX()][coordinates.getY()] == Player.O){
                refToButton.setText(Player.O+"");
            }
            else if (tmptable[coordinates.getX()][coordinates.getY()] == Player.X){
                refToButton.setText(Player.X+"");
            }
        }
                
    }
    private void updateActualPlayer(){
        actualPlayerLabel.setText("Aktuális játékos: "+base.getActualPlayer().name());
    }
    private void gameOver(String winner){
        dispose();        
        JOptionPane.showMessageDialog(this,"A játéknak vége. A nyertes: "+winner);
        new MainWindow();
    }
}
