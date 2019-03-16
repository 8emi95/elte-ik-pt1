/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pegsolitaire;

import javax.swing.JFrame;

/**
 *
 * @author naksabi
 */
public class PegSolitaire {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       PegSolitaireLogic logic = new PegSolitaireLogic();
       JFrame jFrame = new PegSolitaireFrame(logic);
       jFrame.setVisible(true);
    }
}
