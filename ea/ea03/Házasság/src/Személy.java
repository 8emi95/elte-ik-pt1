
public class Személy {

    private final Nem nem;
    private String név;
    private String szigSzám;
    private String cím;
    private Házasság házasság;

    public Személy(Nem nem, String név, String szigSzám, String cím) {
        this.nem = nem;
        this.név = név;
        this.szigSzám = szigSzám;
        this.cím = cím;
        this.házasság = null;
    }

    public Nem nem() {
        return this.nem;
    }

    public String név() {
        return this.név;
    }

    public String szigSzám() {
        return this.szigSzám;
    }

    public String cím() {
        return this.cím;
    }

    public void házasodik(Házasság házasság) throws BigámistaKivétel {
        if (this.házasság != null) {
            throw new BigámistaKivétel(this);
        }
        this.házasság = házasság;
    }

    public void válik() throws SzingliVálniAkarKivétel {
        if (házasság == null) {
            throw new SzingliVálniAkarKivétel(this);
        }
        this.házasság = null;
    }

    public Házasság házasság() {
        return this.házasság;
    }

    public Személy házastárs() {
        Személy házastárs = null;
        if (házasság != null) {
            switch (nem) {
                case FÉRFI:
                    házastárs = this.házasság.feleség();
                    break;
                case NÕ:
                    házastárs = this.házasság.férj();
                    break;
            }
        }
        return házastárs;
    }
}
