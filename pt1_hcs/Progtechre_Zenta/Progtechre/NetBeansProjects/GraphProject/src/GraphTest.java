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
class RajzPanel extends JPanel {
    protected void paintComponent(Graphics gr){ 
        super.paintComponent(gr);
        setBackground(new Color(130,180,160));
        gr.drawOval(40, 80, 320, 100);
        gr.drawRect(40, 80, 320, 100);
        gr.setColor(Color.WHITE);
        gr.setFont(new Font("Arial", Font.BOLD, 40));
        gr.drawString("Végre grafika!",60,140);
        gr.drawLine(60,140,340,140);
        gr.setColor(Color.ORANGE);
        gr.fillRect(0,200,500,10);
    }
}

public class GraphTest extends JFrame{

    public GraphTest(){
        setBounds(500,200,400,280);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //JFrame.EXIT_ON_CLOSE ugyan azt csinálja
        getContentPane().add(new RajzPanel());
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new GraphTest();
    }
    
}
