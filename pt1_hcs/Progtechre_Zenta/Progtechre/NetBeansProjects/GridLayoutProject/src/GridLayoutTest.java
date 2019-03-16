import java.awt.*;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dávid
 */
public class GridLayoutTest extends JFrame{
    
    public GridLayoutTest() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("GridLayout");
        getContentPane().setBackground(new Color(0,255,255));
        getContentPane().setLayout(new GridLayout(6,2,20,10));
        for (int i = 0; i <= 10; i++) {
            getContentPane().add(new JButton("Gomb "+i));
        }
        pack();
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new GridLayoutTest();
    }
    
}
