import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dávid
 */
public class PittyegoKeret extends JFrame implements ActionListener{
    
    private JButton btPittyeg = new JButton("Pittyeg");
    
    public PittyegoKeret(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(btPittyeg);
        btPittyeg.addActionListener(this);
        setBounds(50, 100, 400, 100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ev) {
        Toolkit.getDefaultToolkit().beep();
        setTitle(getTitle() + " Pitty");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new PittyegoKeret();
    }
    
}
