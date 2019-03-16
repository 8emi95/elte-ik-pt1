import javax.swing.*;
import java.awt.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dávid
 */
public class Fenyujsag extends JFrame{

    public Fenyujsag() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(50, 50, 800, 240);
        setTitle("Fényújságok");
        setLayout(new GridLayout(3, 1));
        add(new FenyujsagPanel("2015. december 3.", 100, Color.RED, new Font("Dialog", Font.ITALIC, 20)));
        add(new FenyujsagPanel("Ez a fényújság 2. sora.", 200, new Color(0, 180, 0), new Font("Serif", Font.PLAIN, 22)));
        add(new FenyujsagPanel("Fenyújság program",1000, Color.BLUE, new Font("Monospaced", Font.BOLD, 20)));
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new Fenyujsag();
    }
    
}
