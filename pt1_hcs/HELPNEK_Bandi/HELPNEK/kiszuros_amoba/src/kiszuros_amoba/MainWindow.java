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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author rckzz
 */
public class MainWindow extends JFrame implements ActionListener{
    private JButton first,second,third;
    public MainWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel main = new JPanel();
        main.setLayout(new GridLayout(1,3));        
        
        JLabel label = new JLabel();
        label.setText("Válaszd ki, hogy mekkora legyen a tábla!");
        
        first = new JButton();
        first.setText("6x6");
        first.addActionListener(this);
        
        second = new JButton();
        second.setText("10x10");
        second.addActionListener(this);
        
        third = new JButton();
        third.setText("14x14");
        third.addActionListener(this);
        
        main.add(first);
        main.add(second);
        main.add(third);
        
        getContentPane().add(label,BorderLayout.NORTH);
        getContentPane().add(main,BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==first){
            dispose();
            new GameWindow(6);
        }else if(ae.getSource()==second){
            dispose();
            new GameWindow(10);
        }else if(ae.getSource() == third){
            dispose();
            new GameWindow(14);
        }
    }
}
