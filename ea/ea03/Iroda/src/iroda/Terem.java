package iroda;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Adam Ancsin
 */
public class Terem {
    private final int azonosító;
    private final Collection<Hőérzékelő> hőérzékelők;
    private double hőmérséklet;
    
    public Terem(int azonosító, double hőmérséklet) {
        this.azonosító = azonosító;
        this.hőmérséklet = hőmérséklet; //egy teremnek mindig van hőmérséklete,
        //kezdetben is kell, hogy legyen, bár ez később változhat
        
        this.hőérzékelők = new ArrayList<>();
    }
    
    public void újHőmérséklet(double hőmérséklet) {
        this.hőmérséklet = hőmérséklet;
        értesítMindenkit();
    }
    
    public void újHőérzékelő(Hőérzékelő hőérzékelő) {
        this.hőérzékelők.add(hőérzékelő);
        hőérzékelő.újTerem(this);
        hőérzékelő.értesít();
    }
    
    public void hőérzékelőtTöröl(Hőérzékelő hőérzékelő) {
        this.hőérzékelők.remove(hőérzékelő);
    }
    
    public int azonosító() {
        return this.azonosító;
    }
    
    public double hőmérséklet() {
        return this.hőmérséklet;
    }
    
    private void értesítMindenkit() {
         for(Hőérzékelő hőérzékelő : hőérzékelők) {
            hőérzékelő.értesít();
        }
    }
}
