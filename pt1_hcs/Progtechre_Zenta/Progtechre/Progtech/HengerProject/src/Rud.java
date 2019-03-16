/**
 * @author zentaidavid
 * @version 1.0
 * @created 01-okt.-2015 13:11:11
 */
import extra.Format;

public class Rud extends Henger {

    private double fajsuly;

    public Rud(double sugar, double magassag, double fajsuly) {
        super(sugar, magassag);
        this.fajsuly = fajsuly;
    }
    
    public Rud(double sugar, double magassag) {
        this(sugar, magassag, 1);
    }

    public double getFajsuly() {
        return fajsuly;
    }

    public double suly() {
        return terfogat()*fajsuly;
    }

    public String toString() {
        return super.toString() + "\nFajsúly: "+Format.right(fajsuly, 0, 2)+" Súly: "+Format.right(suly(), 0, 2);
    }
}//end Rud
