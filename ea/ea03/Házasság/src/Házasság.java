
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class H�zass�g {

    private final Szem�ly f�rj;
    private final Szem�ly feles�g;
    private final Szem�ly f�rjTan�ja;
    private final Szem�ly feles�gTan�ja;
    private final String h�zass�gk�t�sHelye;
    private final Date h�zass�gk�t�sIdeje;
    private final Collection<N�szaj�nd�k> n�szaj�nd�kok;

    public H�zass�g(Szem�ly f�rj, Szem�ly feles�g, Szem�ly f�rjTan�ja, Szem�ly feles�gTan�ja,
            String h�zass�gk�t�sHelye, Date h�zass�gk�t�sIdeje) throws Identit�sZavarosKiv�tel {
        if(f�rj.nem() != Nem.F�RFI) {
            throw new Identit�sZavarosKiv�tel(f�rj);
        }
        if(feles�g.nem() != Nem.N�) {
            throw new Identit�sZavarosKiv�tel(feles�g);
        }
        this.f�rj = f�rj;
        this.feles�g = feles�g;
        this.f�rjTan�ja = f�rjTan�ja;
        this.feles�gTan�ja = feles�gTan�ja;
        this.h�zass�gk�t�sHelye = h�zass�gk�t�sHelye;
        this.h�zass�gk�t�sIdeje = h�zass�gk�t�sIdeje;
        this.n�szaj�nd�kok = new ArrayList<>();
    }

    public void �jN�szaj�nd�k(N�szaj�nd�k n�szaj�nd�k) {
        this.n�szaj�nd�kok.add(n�szaj�nd�k);
    }

    public Collection<N�szaj�nd�k> n�szaj�nd�kok() {
        return this.n�szaj�nd�kok;
    }

    public Szem�ly f�rj() {
        return this.f�rj;
    }

    public Szem�ly feles�g() {
        return this.feles�g;
    }

    public Szem�ly f�rjTan�ja() {
        return this.f�rjTan�ja;
    }

    public Szem�ly feles�gTan�ja() {
        return this.feles�gTan�ja;
    }

    public String h�zass�gk�t�sHelye() {
        return this.h�zass�gk�t�sHelye;
    }

    public Date h�zass�gk�t�sIdeje() {
        return this.h�zass�gk�t�sIdeje;
    }

    public void szentes�t() throws Big�mistaKiv�tel {
        f�rj.h�zasodik(this);
        feles�g.h�zasodik(this);
    }

    public void v�l�s() throws SzingliV�lniAkarKiv�tel {
        this.f�rj.v�lik();
        this.feles�g.v�lik();
    }
}
