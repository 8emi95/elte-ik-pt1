
public class SzingliVálniAkarKivétel extends Exception {

    private final Személy személy;

    public SzingliVálniAkarKivétel(Személy személy) {
        this.személy = személy;
    }

    public Személy személy() {
        return this.személy;
    }
}
