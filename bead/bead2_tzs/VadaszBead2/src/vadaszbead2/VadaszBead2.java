/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vadaszbead2;
import vadaszbead2.model.Engine;
import vadaszbead2.view.Frame;

/**
 *
 * @author Zsoci
 */
public class VadaszBead2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Frame frame = new Frame(new Engine());
        frame.showFrame();
    }
    
}
