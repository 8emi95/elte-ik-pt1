package nk_gy8_swing.gui;

import javax.swing.*;
import java.awt.*;

public class SwingStartFrame extends JFrame{

    public SwingStartFrame() throws HeadlessException {
        initFrameProperties();

        getContentPane().add(createHelloWorldLabel());
    }

    /**
     * Elj�r�s, amely be�ll�tja a keret tulajdons�gait
     */
    private void initFrameProperties(){
        /*
         * JFrame-b�l �r�k�lt met�dus, mely seg�ts�g�vel megadhatjuk, hogy mi t�rt�njen akkor, ha az ablakon a
         * bez�r�sra(X) kattintunk.
         *
         * Lehet�s�geink:
         * EXIT_ON_CLOSE - Kil�p�s
         * HIDE_ON_CLOSE - Elrejt�s
         * DISPOSE_ON_CLOSE - Felszabad�t�s (Megsz�nik az ablak, de a programunk fut tov�bb, ha van mit csin�lnia)
         * DO_NOTHING_ON_CLOSE - Nem csin�l semmit.
         *
         * Mi mind�g az EXIT_ON_CLOSE-t fogjuk haszn�lni.
         */
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        /*
         * Ablak c�m�nek a be�ll�t�sa
         */
        setTitle("Swing Start");

        /*
         * A keret minimum �s maximum m�ret�nek a be�ll�t�sa
         *  setMinimumSize(new Dimension(400, 400));
         *  setMaximumSize(new Dimension(400, 400));
         */

        /*
         * A keret aktu�lis m�ret�nek a be�ll�t�sa
         */
        setSize(400, 400);

        /*
         * A keret �tm�retez�s�nek a letilt�sa
         */
        setResizable(false);

        /*
         * A keret k�z�pre igaz�t�sa
         */
        setLocationRelativeTo(null);
    }


    /**
     * Met�dus, amely l�trehoz egy 100x50-es, k�z�pre igaz�tott cimk�t Hello world! felirattal.
     * @return Hello world! cimke
     */
    private JLabel createHelloWorldLabel(){
        final JLabel label = new JLabel("Hello world!", JLabel.CENTER);
        label.setPreferredSize(new Dimension(100, 50));
        return label;
    }
}

