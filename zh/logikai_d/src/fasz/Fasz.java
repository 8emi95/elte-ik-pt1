/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fasz;

import fasz.model.Engine;
import fasz.view.Frame;

/**
 *
 * @author Zsoci
 */
public class Fasz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.startNewGame();
        Frame frame = new Frame(engine);
        frame.showFrame();
        
    }
    
}
