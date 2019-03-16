import extra.Format;

/**
 * @author zentaidavid
 * @version 1.0
 * @created 24-szept.-2015 13:21:38
 */
public class Ember {

    private String nev;
    private int magassag;

    public Ember(String nev, int magassag) {
        this.nev = nev;
        this.magassag = magassag;
    }

    public Ember(String nev) {
        this(nev, 0);
    }

    public String getNev() {
        return nev;
    }

    public int getMagassag() {
        return magassag;
    }

    public void setMagassag(int magassag) {
        if (magassag > 0) {
            this.magassag = magassag;
        }
    }

    public boolean equals(Object obj) {
        return nev.equals(((Ember) obj).nev);
    }

    public String toString() {
        return Format.left(nev, 10) + Format.right(magassag, 3);
    }
}//end Ember
