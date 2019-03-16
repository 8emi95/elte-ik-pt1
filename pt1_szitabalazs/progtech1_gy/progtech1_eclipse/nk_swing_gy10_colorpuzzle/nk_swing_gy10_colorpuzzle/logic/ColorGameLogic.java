package nk_swing_gy10_colorpuzzle.logic;

import java.util.Random;

/**
 * @author Nagy Kriszti�n
 */
public class ColorGameLogic {
    private int[][] fields;
    private int size;
    private int steps;

    /**
     * �j j�t�k l�trehoz�s��rt felel�s logika, amely inicializ�lja a param�terben kapott m�ret alapj�n a n�gyzetes j�t�kt�bl�t
     * �s v�letlenszer�en felt�lti a logikai j�t�kteret 0-1-2 �rt�kekkel, tov�bb� 0-�zzuk a l�p�sek sz�m�t.
     *
     * @param size - a j�t�kt�r m�rete. Mivel a feladat szerint csak n�gyzetes lehet, �gy el�g egy param�tert haszn�lni.
     */
    public void newGame(final int size) {
        this.size = size;
        this.steps = 0;
        fields = new int[size][size];
        Random random = new Random();
        for (int row = 0; row < size; ++row) {
            for (int column = 0; column < size; ++column) {
                fields[row][column] = random.nextInt(3);
            }
        }
    }

    /**
     * Met�dus, amely visszaadja az adott mez�n tal�lhat� �rt�ket
     */
    public int getFieldValue(final int row, final int column) {
        return fields[row][column];
    }

    /**
     * Elj�r�s melynek a seg�ts�g�vel megv�ltoztatjuk a "gy�jt�pontban" lev� mez�t �s k�rnyezet�t.
     * <p>
     * P�ld�ul:
     * 0 0  0  0 0
     * 0 1 [0] 0 0
     * 0 2  0  2 0
     * 1 0  0  1 2
     * 1 1  1  2 1
     * <p>
     * []-jel�lt mez�re kattint�s eset�n (+) alakzatban elhelyezked� mez�k �rt�k�nek n�vel�se 1-el.
     * Eredm�ny:
     * <p>
     * 0 0 1 0 0
     * 0 2 1 1 0
     * 0 2 1 2 0
     * 1 0 0 1 2
     * 1 1 1 2 1
     * <p>
     * Mivel a felhaszn�l� interakci�ba l�pett a j�t�kt�bl�val, amikor ezt a met�dust megfuttatjuk, n�velj�k a l�p�sek sz�m�t is.
     */
    public void changeFieldValues(final int row, final int column) {
        changeSingleFieldValue(row, column);
        changeSingleFieldValue(row - 1, column);
        changeSingleFieldValue(row + 1, column);
        changeSingleFieldValue(row, column - 1);
        changeSingleFieldValue(row, column + 1);
        ++steps;
    }

    /**
     * Egy v�ltoz�s v�grehajt�sa. Figyel�nk arra az esetre, hogy ha a j�t�kp�lya sz�lein�l kattintottunk, akkor
     * el�fordulhat, hogy �tl�pj�k az index�nkkel a m�trixunk hat�rait. Ekkor ArrayIndexOutOfBoundsException keletkezik,
     * amit elnyel�nk.
     */
    private void changeSingleFieldValue(final int row, final int column) {
        try {
            fields[row][column]++;
            fields[row][column] %= 3;
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
    }

    /**
     * J�t�k v�g�nek az ellen�rz�s�t lebonyol�t� met�dus.
     * Mivel a j�t�kunk akkor �r v�get, ha a m�trixunkban minden helyen ugyan az a sz�m (a fel�leten sz�n) tal�lhat�,
     * �gy el�g kivenn�nk az els� helyen tal�lhat� sz�mot �s megn�zni, hogy mindenhol ugyan ez az �rt�k tal�lhat�-e.
     * Abban az esetben, ha valahol egy m�sik sz�mot tal�lunk, akkor biztosak lehet�nk abban, hogy a felhaszn�l� m�g
     * nem oldotta meg a feladv�nyt.
     */
    public boolean isGameEnd() {
        int oneColor = fields[0][0];
        for (int row = 0; row < size; ++row) {
            for (int column = 0; column < size; ++column) {
                if (fields[row][column] != oneColor) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getSize() {
        return size;
    }

    public int getSteps() {
        return steps;
    }
}
