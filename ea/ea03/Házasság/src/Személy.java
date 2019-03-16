
public class Szem�ly {

    private final Nem nem;
    private String n�v;
    private String szigSz�m;
    private String c�m;
    private H�zass�g h�zass�g;

    public Szem�ly(Nem nem, String n�v, String szigSz�m, String c�m) {
        this.nem = nem;
        this.n�v = n�v;
        this.szigSz�m = szigSz�m;
        this.c�m = c�m;
        this.h�zass�g = null;
    }

    public Nem nem() {
        return this.nem;
    }

    public String n�v() {
        return this.n�v;
    }

    public String szigSz�m() {
        return this.szigSz�m;
    }

    public String c�m() {
        return this.c�m;
    }

    public void h�zasodik(H�zass�g h�zass�g) throws Big�mistaKiv�tel {
        if (this.h�zass�g != null) {
            throw new Big�mistaKiv�tel(this);
        }
        this.h�zass�g = h�zass�g;
    }

    public void v�lik() throws SzingliV�lniAkarKiv�tel {
        if (h�zass�g == null) {
            throw new SzingliV�lniAkarKiv�tel(this);
        }
        this.h�zass�g = null;
    }

    public H�zass�g h�zass�g() {
        return this.h�zass�g;
    }

    public Szem�ly h�zast�rs() {
        Szem�ly h�zast�rs = null;
        if (h�zass�g != null) {
            switch (nem) {
                case F�RFI:
                    h�zast�rs = this.h�zass�g.feles�g();
                    break;
                case N�:
                    h�zast�rs = this.h�zass�g.f�rj();
                    break;
            }
        }
        return h�zast�rs;
    }
}
