/**
 *
 * @author Adam Ancsin
 */
public class Identit�sZavarosKiv�tel extends Exception{
    private final Szem�ly szem�ly;

    public Identit�sZavarosKiv�tel(Szem�ly szem�ly) {
        this.szem�ly = szem�ly;
    }

    public Szem�ly szem�ly() {
        return this.szem�ly;
    }
}
