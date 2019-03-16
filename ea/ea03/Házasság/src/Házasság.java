
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Házasság {

    private final Személy férj;
    private final Személy feleség;
    private final Személy férjTanúja;
    private final Személy feleségTanúja;
    private final String házasságkötésHelye;
    private final Date házasságkötésIdeje;
    private final Collection<Nászajándék> nászajándékok;

    public Házasság(Személy férj, Személy feleség, Személy férjTanúja, Személy feleségTanúja,
            String házasságkötésHelye, Date házasságkötésIdeje) throws IdentitásZavarosKivétel {
        if(férj.nem() != Nem.FÉRFI) {
            throw new IdentitásZavarosKivétel(férj);
        }
        if(feleség.nem() != Nem.NÕ) {
            throw new IdentitásZavarosKivétel(feleség);
        }
        this.férj = férj;
        this.feleség = feleség;
        this.férjTanúja = férjTanúja;
        this.feleségTanúja = feleségTanúja;
        this.házasságkötésHelye = házasságkötésHelye;
        this.házasságkötésIdeje = házasságkötésIdeje;
        this.nászajándékok = new ArrayList<>();
    }

    public void újNászajándék(Nászajándék nászajándék) {
        this.nászajándékok.add(nászajándék);
    }

    public Collection<Nászajándék> nászajándékok() {
        return this.nászajándékok;
    }

    public Személy férj() {
        return this.férj;
    }

    public Személy feleség() {
        return this.feleség;
    }

    public Személy férjTanúja() {
        return this.férjTanúja;
    }

    public Személy feleségTanúja() {
        return this.feleségTanúja;
    }

    public String házasságkötésHelye() {
        return this.házasságkötésHelye;
    }

    public Date házasságkötésIdeje() {
        return this.házasságkötésIdeje;
    }

    public void szentesít() throws BigámistaKivétel {
        férj.házasodik(this);
        feleség.házasodik(this);
    }

    public void válás() throws SzingliVálniAkarKivétel {
        this.férj.válik();
        this.feleség.válik();
    }
}
