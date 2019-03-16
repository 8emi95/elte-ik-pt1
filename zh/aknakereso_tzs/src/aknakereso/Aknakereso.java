/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aknakereso;
import aknakereso.model.Engine;
import aknakereso.view.Frame;

/**
 *
 * @author Zsoci
 */

public class Aknakereso {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Frame frame = new Frame(new Engine());
        frame.showFrame();
    }
}
