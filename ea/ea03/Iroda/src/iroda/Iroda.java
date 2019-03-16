package iroda;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Adam Ancsin
 */
public class Iroda {
    private final Collection<Terem> termek;
    
    //vagy inkább ne legyen final? attól, hogy helyben marad,
    //még az utca/tér/település/stb. neve változhat
    private final String cím;
    private String cégNév;
    
    public Iroda(String cím) {
        this(cím, null);
    }
    public Iroda(String cím, String cégNév) {
        this.cím = cím;
        this.cégNév = cégNév;
        this.termek = new ArrayList<>();
    }
    
    public Collection<Terem> termek() {
        return this.termek;
    }
    
    public void újTerem(Terem terem) {
        this.termek.add(terem);
    }
    
    public String cím(){
        return this.cím;
    }
    
    public String cégNév(){
        return this.cégNév;
    }
    
    public void újCégNév(String cégNév) {
        this.cégNév = cégNév;
    }
}
