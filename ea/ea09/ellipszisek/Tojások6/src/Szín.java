import java.awt.Color;

public class Szín
{
    private Color   szín;
    private String  név;

    public Szín(Color szín, String név)
    {
        this.szín = szín;   this.név = név;
    }

    public Color szín() { return szín; }

    public String név() { return név; }

    @Override
    public String toString()    { return név; }
}
