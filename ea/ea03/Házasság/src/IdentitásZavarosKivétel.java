/**
 *
 * @author Adam Ancsin
 */
public class IdentitásZavarosKivétel extends Exception{
    private final Személy személy;

    public IdentitásZavarosKivétel(Személy személy) {
        this.személy = személy;
    }

    public Személy személy() {
        return this.személy;
    }
}
