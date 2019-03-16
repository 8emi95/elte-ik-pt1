import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

/**
 * Csúszka használatát bemutató párbeszédablak
 */
public class SliderDlg extends OKCancelDialog implements ChangeListener
{
    private JSlider     csúszka;        // a csúszka

    private JLabel      info;           // a csúszka értékének megjelenítése

    /**
     * Egy csúszkát tartalmazó párbeszédablak létrehozása
     * @param keret ehhez tartozik a dialógus
     * @param cím a fejléc tartalma
     * @param min a csúszka alsó határa
     * @param max a csúszka felső határa
     * @param érték a csúszak aktuális értéke
     * @param fő a fő értékek
     */
    public SliderDlg(JFrame keret, String cím, int min, int max, int érték, int fő)
    {
        super(keret, cím);
        if ( érték < min || érték > max )   érték = min;
        info = new JLabel("" + érték, SwingConstants.CENTER);
        csúszka = new JSlider(min, max, érték);
        csúszka.setMajorTickSpacing(fő);
        csúszka.setMinorTickSpacing(1);
        csúszka.setPaintTicks(true);
        csúszka.setPaintLabels(true);
        csúszka.setSnapToTicks(true);
        csúszka.addChangeListener(this);
        setLayout(new BorderLayout());
        add("North", info);
        add("Center", csúszka);
        add("South", gombpanel);

        setSize(new Dimension(250, 120));
        setResizable(false);
    }

    @Override
    protected boolean processOK()   { return true; }

    @Override
    protected void processCancel()  {}

    /**
     * A csúszka értékének lekérdezése
     * @return a csúszka értéke
     */
    public int getValue()           { return csúszka.getValue(); }

    /**
     * A csúszka értékének beállítása
     * @param v az aktuális érték
     */
    public void setValue(int v)
    {
        if ( v < csúszka.getMinimum() ) v = csúszka.getMinimum();
        if ( v > csúszka.getMaximum() ) v = csúszka.getMaximum();
        csúszka.setValue(v);
    }

    /**
	 * A csúszka változás eseménye
	 * @param e az esemény
	 */
	public void stateChanged(ChangeEvent e)
	{
		info.setText("" + csúszka.getValue());
	}
}
