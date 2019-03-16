package colorpuzzle.gui;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A játéktábla felett található információs panel, melyen megjelenítjük a játék kezdete óta eltelt időt és a játékos
 * lépéseinek a számát
 *
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
         * Mivel nem állítottunk be semmilyen Layoutot, így alapértelmezetten FlowLayout-tal dolgozunk.
         * Beállítjuk a panel általunk preferált méretét 100x50-re:
         */
        setPreferredSize(new Dimension(100, 50));
        // Saját betűtípust szeretnénk használni, ami a Garamond lesz, ITALIC (dőlt) stílusban és 16-os betűmérettel.
        textFont = new Font("Garamond", Font.ITALIC, 16);

        elapsedTimeTextLabel = createLabel("Elapsed time: ", textFont);
        elapsedTimeLabel = createLabel("", textFont);
        stepCounterTextLabel = createLabel("Steps: ", textFont);
        stepCounterLabel = createLabel("", textFont);


        //Hozzáadjuk a komponenseket a panelunkhoz.
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
            // Amennyiben létezett már Timerünk, úgy leállítjuk.
            elapsedTime.stop();
        }
        // Beállítjuk a megjelenő feliratot 00:00:00-ra
        elapsedTimeLabel.setText("00:00:00");
        // 0-ázzuk a lépések számát
        setSteps(0);
        // Létrehozunk egy új időzítőt.
        elapsedTime = new Timer(1000, new TimerAction(elapsedTimeLabel));
        // Elindítjuk az újonnan létrehozott időzítőnket.
        elapsedTime.start();
    }

    public void setSteps(int steps) {
        stepCounterLabel.setText(String.valueOf(steps));
    }
}
