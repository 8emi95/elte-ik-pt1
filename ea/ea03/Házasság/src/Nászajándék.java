
import java.util.ArrayList;
import java.util.Collection;

public class N�szaj�nd�k {

    private final String n�v;
    private final Collection<Szem�ly> aj�nd�koz�k;

    public N�szaj�nd�k(String n�v) {
        this.n�v = n�v;
        this.aj�nd�koz�k = new ArrayList<>();
    }

    public void �jAj�nd�koz�(Szem�ly aj�nd�koz�) {
        this.aj�nd�koz�k.add(aj�nd�koz�);
    }

    public String n�v() {
        return this.n�v;
    }

    public Collection<Szem�ly> aj�nd�koz�k() {
        return this.aj�nd�koz�k;
    }
}
