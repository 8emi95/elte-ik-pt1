package colorpuzzle.logic;

import java.util.Random;

public class ColorGameLogic {
    private int[][] fields;
    private int size;
    private int steps;

    /**
     * Új játék létrehozásáért felelős logika, amely inicializálja a paraméterben kapott méret alapján a négyzetes játéktáblát
     * és véletlenszerűen feltölti a logikai játékteret 0-1-2 értékekkel, továbbá 0-ázzuk a lépések számát.
     *
     * @param size - a játéktér mérete. Mivel a feladat szerint csak négyzetes lehet, így elég egy paramétert használni.
     */
    public void newGame(final int size) {
        this.size = size;
        this.steps = 0;
        fields = new int[size][size];
        /*Random random = new Random();
        for (int row = 0; row < size; ++row) {
            for (int column = 0; column < size; ++column) {
                fields[row][column] = random.nextInt(3);
            }
        }*/
    }

    /**
     * Metódus, amely visszaadja az adott mezőn található értéket
     */
    public int getFieldValue(final int row, final int column) {
        return fields[row][column];
    }

    /**
     * Eljárás melynek a segítségével megváltoztatjuk a "gyújtópontban" levő mezőt és környezetét.
     * <p>
     * Például:
     * 0 0  0  0 0
     * 0 1 [0] 0 0
     * 0 2  0  2 0
     * 1 0  0  1 2
     * 1 1  1  2 1
     * <p>
     * []-jelölt mezőre kattintás esetén (+) alakzatban elhelyezkedő mezők értékének növelése 1-el.
     * Eredmény:
     * <p>
     * 0 0 1 0 0
     * 0 2 1 1 0
     * 0 2 1 2 0
     * 1 0 0 1 2
     * 1 1 1 2 1
     * <p>
     * Mivel a felhasználó interakcióba lépett a játéktáblával, amikor ezt a metódust megfuttatjuk, növeljük a lépések számát is.
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
     * Egy változás végrehajtása. Figyelünk arra az esetre, hogy ha a játékpálya széleinél kattintottunk, akkor
     * előfordulhat, hogy átlépjük az indexünkkel a mátrixunk határait. Ekkor ArrayIndexOutOfBoundsException keletkezik,
     * amit elnyelünk.
     */
    private void changeSingleFieldValue(final int row, final int column) {
        try {
            fields[row][column]++;
            fields[row][column] %= 3;
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
    }

    /**
     * Játék végének az ellenőrzését lebonyolító metódus.
     * Mivel a játékunk akkor ér véget, ha a mátrixunkban minden helyen ugyan az a szám (a felületen szín) található,
     * így elég kivennünk az első helyen található számot és megnézni, hogy mindenhol ugyan ez az érték található-e.
     * Abban az esetben, ha valahol egy másik számot találunk, akkor biztosak lehetünk abban, hogy a felhasználó még
     * nem oldotta meg a feladványt.
     */
    /*public boolean isGameEnd() {
        int oneColor = fields[0][0];
        for (int row = 0; row < size; ++row) {
            for (int column = 0; column < size; ++column) {
                if (fields[row][column] != oneColor) {
                    return false;
                }
            }
        }
        return true;
    }*/

    public int getSize() {
        return size;
    }

    public int getSteps() {
        return steps;
    }
}
