import extra.Format;

/**
 * @author zentaidavid
 * @version 1.0
 * @created 01-okt.-2015 13:10:55
 */
public class Henger {

	private static int szuletesSzamlalo = 0;
	private double sugar;
	private double magassag;

    public Henger(double sugar, double magassag) {
        this.sugar = sugar;
        this.magassag = magassag;
        szuletesSzamlalo++;
    }

    public static int getSzuletesSzamlalo() {
        return szuletesSzamlalo;
    }

    public double getSugar() {
        return sugar;
    }

    public double getMagassag() {
        return magassag;
    }

    public double terfogat() {
        return sugar*sugar*Math.PI*magassag;
    }

    public String toString() {
        return "\n" + getClass().getName() + "\nSugár: " + Format.right(sugar, 0, 2) + " Magasság: " + Format.right(magassag, 0, 2) + " Térfogat: " + Format.right(terfogat(), 0, 2);
    }
}//end Henger