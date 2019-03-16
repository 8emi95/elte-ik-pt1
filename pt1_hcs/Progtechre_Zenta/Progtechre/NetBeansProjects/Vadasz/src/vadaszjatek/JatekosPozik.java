/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vadaszjatek;

/**
 *
 * @author Dávid
 */
public class JatekosPozik {
    
    private int x, y;
    
    public JatekosPozik(int i, int j){
        this.x = i;
        this.y = j;
    }
    
    public void setX(int i){
        this.x = i;
    }
    
    public void setY(int j){
        this.y = j;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}
