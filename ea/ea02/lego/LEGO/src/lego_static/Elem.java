package lego_static;

import java.awt.Color;

public class Elem {
    private static final String név = new String("2x2 kocka");
    private static final Color szín = new Color(255, 0, 0);
    private static final int ár = 2;
   
    public String név() { return név; }
    public Color szín(){ return szín; }
    public int ár() { return ár; }
}
