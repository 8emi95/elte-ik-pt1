import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dávid
 */
class PontozoVaszon extends JPanel {
    private Vector pontok = new Vector();
    
    public PontozoVaszon() {
        setBackground(Color.PINK);
        addMouseListener(new EgerFigyelo());
    }
    
    public void paintComponent(Graphics gr){
        super.paintComponent(gr);
        Point p;
        for(int i=0; i<pontok.size(); i++){
            p=(Point)(pontok.get(i));
            gr.fillOval(p.x, p.y, 5, 5);
        }
    }
    
    class EgerFigyelo extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            pontok.add(new Point(e.getX(),e.getY()));
            Graphics gr = getGraphics(); //a PontozoVaszonban szerepel ezért meghívható
            gr.fillOval(e.getX(), e.getY(), 5, 5);
            gr.dispose();//erőforrás manuális felszabadítása, nem muszáj kiirni, úgyis megcsinálja a garbagecollector, de ajánlott
        }
    }
}

public class Pontozo extends JFrame{

    public Pontozo() {
        setTitle("Pontozás");
        setBounds(0,0,640,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        getContentPane().add(new PontozoVaszon());
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Pontozo();
    }
    
}
