package sudoku.gui;

import java.awt.event.ActionEvent;
import java.time.Duration;
import java.time.Instant;
import javax.swing.AbstractAction;
import javax.swing.JLabel;

/**
 * Időzítőhöz készített akció, amely kiszámolja egy kiinduló állapothoz képest
 * az eltelt időt, majd frissíti a paraméterül kapott labelt.
 * Megjegyzés: Az osztály Java SE 8-ban bevezetett osztályokat használ, így
 * visszafele nem kompatibilis.
 * @author Nagy Krisztián
 */
public class TimerAction extends AbstractAction{

    private final JLabel timerLabel;
    private final Instant startTime;

    public TimerAction(final JLabel timerLabel, long previousRuntime) {
        this.timerLabel = timerLabel;
        final Duration previousDuration = (previousRuntime == 0L) ? Duration.ZERO : Duration.ofMillis(previousRuntime);
        this.startTime = Instant.now().minus(previousDuration);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        timerLabel.setText(formatDuration(Duration.between(startTime, Instant.now())));
    }

    /**
     * Metódus melynek segítségével XX:XX:XX alakúra formáljuk a paraméterben kapott időt.
     * @param duration Eltelt idő
     * @return Az eltelt idő megformázva
     */
    private String formatDuration(final Duration duration){
        final long seconds = duration.getSeconds();
        return String.format("%02d:%02d:%02d", seconds / 3600,
                (seconds % 3600) /60, seconds % 60);
    }
}