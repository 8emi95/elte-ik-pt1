/**
 * @author zentaidavid
 * @version 1.0
 * @created 01-okt.-2015 13:11:42
 */
import extra.Format;

public class Cso extends Rud {

    private double falVastagsag;

    public Cso(double sugar, double magassag, double fajsuly, double falVastagsag) {
        super(sugar, magassag, fajsuly);
        this.falVastagsag = falVastagsag;
    }

    public Cso(double sugar, double magassag, double falVastagsag) {
        this(sugar, magassag, falVastagsag, 1);
    }

    public double getFalVastagsag() {
        return falVastagsag;
    }

    public double terfogat() {
        Henger belso = new Henger(getSugar() - falVastagsag, getMagassag());
        return super.terfogat() - belso.terfogat();
    }

    public String toString() {
        return super.toString() + " Falvastagsag: " + Format.right(falVastagsag, 0, 2);
    }
}//end Cso
