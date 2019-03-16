/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

/**
 *
 * @author Andris
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car mycar = new Car();
        
        mycar.accelerate();
        mycar.accelerate();
        mycar.declenerate();
        mycar.accelerate();
        mycar.declenerate();
        mycar.declenerate();
    }
    
}
