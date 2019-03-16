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
public class BorderLayoutTest extends JFrame {
    
    Container cp = getContentPane();
    
    public BorderLayoutTest(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("BorderLayout");
        cp.setLayout(new BorderLayout(2,1));
        cp.add(new JButton("North - Észak - Felső"),"North");   //a gomb elhelyezése North
        cp.add(new JButton("South - Dél - Alsó"),"South");   //a gomb elhelyezése South
        cp.add(new JButton("West - Nyugat - Bal"),"West");   //a gomb elhelyezése West
        cp.add(new JButton("East - Kelet - Jobb"),"East");   //a gomb elhelyezése East
        cp.add(new JButton("Center - Középső"),"Center");   //a gomb elhelyezése Center
        
        setSize(450,200);
        setVisible(true);
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new BorderLayoutTest();
    }
    
}
