
public class SzingliV�lniAkarKiv�tel extends Exception {

    private final Szem�ly szem�ly;

    public SzingliV�lniAkarKiv�tel(Szem�ly szem�ly) {
        this.szem�ly = szem�ly;
    }

    public Szem�ly szem�ly() {
        return this.szem�ly;
    }
}
