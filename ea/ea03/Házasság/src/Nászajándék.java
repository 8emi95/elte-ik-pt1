
import java.util.ArrayList;
import java.util.Collection;

public class Nászajándék {

    private final String név;
    private final Collection<Személy> ajándékozók;

    public Nászajándék(String név) {
        this.név = név;
        this.ajándékozók = new ArrayList<>();
    }

    public void újAjándékozó(Személy ajándékozó) {
        this.ajándékozók.add(ajándékozó);
    }

    public String név() {
        return this.név;
    }

    public Collection<Személy> ajándékozók() {
        return this.ajándékozók;
    }
}
