/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

/**
 *
 * @author Dobreff András
 */
class Car {
    private Wheel frontLeft;
    private Wheel frontRight;
    private Wheel rearleft;
    private Wheel rearRight;
    
    private Engine engine;
    
    public Car(){
        this.frontLeft = new Wheel(64);
        this.frontRight = new Wheel(64);
        this.rearleft = new Wheel(68);
        this.rearRight = new Wheel(68);
        
        this.engine = new Engine();
    }

    public void accelerate() {
        engine.setSpeed(engine.getSpeed()+10);
    }

    public void declenerate() {
        engine.setSpeed(engine.getSpeed()-10);
    }
}
