import java.awt.Color;

/**
 * Színek kezelése: szín és név együtt.
 */
public class Szín
{
    private Color   szín;
    private String  név;

    public Szín(String név, Color szín)
    {
        this.szín = szín;   this.név = név;
    }

    public Color szín() { return szín; }

    public String név() { return név; }

    @Override
    public String toString()    { return név; }
}
