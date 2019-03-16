package lego_naiv;

import java.awt.Color;

public class Elem {
    private String név;
    private Color szín;
    private int ár;
   
    public Elem(String név, Color szín, int ár){
        this.név = név;
        this.szín = szín;
        this.ár = ár;
    }
    
    public String név() { return név; }
    public Color szín(){ return szín; }
    public int ár() { return ár; }
}
