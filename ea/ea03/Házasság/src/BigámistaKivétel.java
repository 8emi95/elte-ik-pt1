
public class BigámistaKivétel extends Exception {

    private final Személy személy;

    public BigámistaKivétel(Személy személy) {
        this.személy = személy;
    }

    public Személy személy() {
        return this.személy;
    }
}
