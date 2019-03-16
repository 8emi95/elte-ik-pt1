/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vadaszbead;
import vadaszbead.model.Engine;
import vadaszbead.view.Frame;

/**
 *
 * @author Zsoci
 */
public class VadaszBead {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame frame = new Frame(new Engine());
        frame.showFrame();
    }
    
}
