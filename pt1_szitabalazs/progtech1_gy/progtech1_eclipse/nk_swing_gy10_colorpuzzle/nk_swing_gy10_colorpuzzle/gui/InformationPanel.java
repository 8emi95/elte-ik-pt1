package nk_swing_gy10_colorpuzzle.gui;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A j�t�kt�bla felett tal�lhat� inform�ci�s panel, melyen megjelen�tj�k a j�t�k kezdete �ta eltelt id�t �s a j�t�kos
 * l�p�seinek a sz�m�t
 *
 * @author Nagy Kriszti�n
 */
public class InformationPanel extends JPanel {

    private final JLabel elapsedTimeTextLabel;
    private final JLabel elapsedTimeLabel;
    private final JLabel stepCounterTextLabel;
    private final JLabel stepCounterLabel;

    private final Font textFont;

    private Timer elapsedTime;

    public InformationPanel() {
        /*
         * Mivel nem �ll�tottunk be semmilyen Layoutot, �gy alap�rtelmezetten FlowLayout-tal dolgozunk.
         * Be�ll�tjuk a panel �ltalunk prefer�lt m�ret�t 100x50-re:
         */
        setPreferredSize(new Dimension(100, 50));
        // Saj�t bet�t�pust szeretn�nk haszn�lni, ami a Garamond lesz, ITALIC (d�lt) st�lusban �s 16-os bet�m�rettel.
        textFont = new Font("Garamond", Font.ITALIC, 16);

        elapsedTimeTextLabel = createLabel("Elapsed time: ", textFont);
        elapsedTimeLabel = createLabel("", textFont);
        stepCounterTextLabel = createLabel("Steps: ", textFont);
        stepCounterLabel = createLabel("", textFont);


        //Hozz�adjuk a komponenseket a panelunkhoz.
        add(elapsedTimeTextLabel);
        add(elapsedTimeLabel);
        add(new JLabel("    "));
        add(stepCounterTextLabel);
        add(stepCounterLabel);

        newGame();
    }

    private JLabel createLabel(String text, Font font) {
        final JLabel label = new JLabel(text);
        label.setFont(font);
        return label;
    }

    public final void newGame() {
        if (elapsedTime != null) {
            // Amennyiben l�tezett m�r Timer�nk, �gy le�ll�tjuk.
            elapsedTime.stop();
        }
        // Be�ll�tjuk a megjelen� feliratot 00:00:00-ra
        elapsedTimeLabel.setText("00:00:00");
        // 0-�zzuk a l�p�sek sz�m�t
        setSteps(0);
        // L�trehozunk egy �j id�z�t�t.
        elapsedTime = new Timer(1000, new TimerAction(elapsedTimeLabel));
        // Elind�tjuk az �jonnan l�trehozott id�z�t�nket.
        elapsedTime.start();
    }

    public void setSteps(int steps) {
        stepCounterLabel.setText(String.valueOf(steps));
    }
}
