package nk_swing_gy10_colorpuzzle.gui;

import java.awt.event.ActionEvent;
import java.time.Duration;
import java.time.Instant;
import javax.swing.AbstractAction;
import javax.swing.JLabel;

/**
 * Idõzítõhöz készített akció, amely kiszámolja egy kiinduló állapothoz képest
 * az eltelt idõt, majd frissíti a paraméterül kapott labelt.
 * Megjegyzés: Az osztály Java SE 8 -ban bevezetett típusokat használ, így
 * visszafele nem kompatibilis.
 * @author Nagy Krisztián
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
     * Metódus melynek segítségével XX:XX:XX alakúra formáljuk a paraméterben kapott idõt.
     * @param duration Eltelt idõ
     * @return Az eltelt idõ megformázva
     */
    private String formatDuration(final Duration duration){
        final long seconds = duration.getSeconds();
        return String.format("%02d:%02d:%02d", seconds / 3600, 
            (seconds % 3600) /60, seconds % 60);
    }
}
