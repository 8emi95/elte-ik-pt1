package vadasz_beadando;

/**
 *
 * @author zentaidavid
 */
public class MyVector {
    private int x, y;
    
    public MyVector(int i, int j){
        this.x = i;
        this.y = j;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int i){
        this.x = i;
    }
    
    public void setY(int j){
        this.y = j;
    }
}
