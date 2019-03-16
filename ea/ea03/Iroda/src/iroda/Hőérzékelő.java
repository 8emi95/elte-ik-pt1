package iroda;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Adam Ancsin
 */
public class Hőérzékelő {
    private final int azonosító;
    private final double hibahatár;
    private double hőmérséklet;
    private final Random generátor;
    private Terem terem;
    
    public Hőérzékelő(int azonosító, double hibahatár) {
        this.azonosító = azonosító;
        this.hibahatár = hibahatár;
        this.generátor = new Random(Calendar.getInstance().getTimeInMillis());
    }
    
    public void értesít() {
       double transzformáltRandom = this.generátor.nextDouble() * 2.0 - 1.0; 
       this.hőmérséklet = terem.hőmérséklet() * (1.0 + hibahatár * transzformáltRandom /100.0);
       System.out.println("Hőérzékelő "+azonosító+": "+this.hőmérséklet+" °C");
    }

    public double hibahatár() {
        return this.hibahatár;
    }
    
    public double hőmérséklet() {
        return this.hőmérséklet;
    }
    
    public void újTerem(Terem terem) {
        this.terem = terem;
    }
    
    public Terem terem() {
        return this.terem;
    }
} 
