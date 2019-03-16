package nk_swing_gy10_colorpuzzle.gui;

import java.awt.event.ActionEvent;
import java.time.Duration;
import java.time.Instant;
import javax.swing.AbstractAction;
import javax.swing.JLabel;

/**
 * Id�z�t�h�z k�sz�tett akci�, amely kisz�molja egy kiindul� �llapothoz k�pest
 * az eltelt id�t, majd friss�ti a param�ter�l kapott labelt.
 * Megjegyz�s: Az oszt�ly Java SE 8 -ban bevezetett t�pusokat haszn�l, �gy
 * visszafele nem kompatibilis.
 * @author Nagy Kriszti�n
 */
public class TimerAction extends AbstractAction{

    private final JLabel timerLabel;
    private final Instant startTime;

    public TimerAction(final JLabel timerLabel) {
        this.timerLabel = timerLabel;        
        this.startTime = Instant.now();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timerLabel.setText(formatDuration(Duration.between(startTime, Instant.now())));
    }
    /**
     * Met�dus melynek seg�ts�g�vel XX:XX:XX alak�ra form�ljuk a param�terben kapott id�t.
     * @param duration Eltelt id�
     * @return Az eltelt id� megform�zva
     */
    private String formatDuration(final Duration duration){
        final long seconds = duration.getSeconds();
        return String.format("%02d:%02d:%02d", seconds / 3600, 
            (seconds % 3600) /60, seconds % 60);
    }
}
