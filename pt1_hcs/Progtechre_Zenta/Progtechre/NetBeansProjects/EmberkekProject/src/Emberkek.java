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
class Emberke extends JPanel{
    private Color color;
    
    public Emberke(Color color){
        this.color = color;
    }
    
    protected void paintComponent(Graphics gr){
        super.paintComponent(gr); //
        gr.translate(getWidth()/2, getHeight()/2);
        gr.setColor(color);
        gr.drawOval(-5, -15, 10, 10); //emberke feje
        gr.drawLine(0, -5, 0, 7);//teste
        gr.drawLine(-7, 0, 7, 0);//két keze
        gr.drawLine(0, 7, -5, 20);//bal lába
        gr.drawLine(0, 7, 5, 20);//jobb lába
    }
}

public class Emberkek extends JFrame{

    public Emberkek() {
        setBounds(100, 100, 300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLayout(new GridLayout(5,6));
        for(int i=0; i<10; i++){
            add(new Emberke(Color.BLUE));
            add(new Emberke(Color.RED));
            add(new Emberke(Color.BLACK));
        }
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Emberkek();
    }
    
}
