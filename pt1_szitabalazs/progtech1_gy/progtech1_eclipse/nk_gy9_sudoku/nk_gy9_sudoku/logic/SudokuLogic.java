package nk_gy9_sudoku.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * A j�t�k logik�j�t meghat�roz� oszt�ly.
 * @author Nagy Kriszti�n
 */
public class SudokuLogic {
    /**
     * A j�t�kt�r m�ret�t le�r� mez�
     */
    private static final int MAX_SIZE = 9;
    /**
     * Mez�ket tartalmaz� m�trix
     */
    private Field[][] fields;

    /**
     * A j�t�k logika param�ter n�lk�li konstruktora.
     */
    public SudokuLogic(){
        createNewGame();
    }

    /**
     * �j j�t�k l�trehoz�s��rt felel�s elj�r�s.
     */
    public final void createNewGame(){
        fields = new Field[MAX_SIZE][MAX_SIZE];
        for(int i = 0; i < MAX_SIZE; ++i){
            for(int j = 0; j < MAX_SIZE; ++j){
                fields[i][j] = new Field();
            }
        }
    }

    /**
     * Setter elj�r�s, mely be�ll�tja a mez�ben szerepl� sz�mot a k�vetkez� lehets�ges sz�mra.
     * @param x mez� sorindexe
     * @param y mez� oszlopindexe
     */
    public void setFieldValue(final int x, final int y){
        fields[y][x].value = getNextPossibleNumber(x,y);
    }

    /**
     * Getter f�ggv�ny, mely visszaadja a mez�ben szerepl� sz�mot.
     * @param x mez� sorindexe
     * @param y mez� oszlopindexe
     * @return mez�ben tal�lhat� sz�m
     */
    public int getFieldValue(int x, int y) {
        return fields[y][x].value;
    }

    /**
     * Elj�r�s amely be�ll�tja az adott mez�t megv�ltoztathatatlanra.
     * @param x mez� sorindexe
     * @param y mez� oszlopindexe
     */
    public void setFieldValueUnchangeable(final int x, final int y){
        fields[y][x].changeable = false;
    }

    /**
     * F�ggv�ny, amely megmondja hogy egy adott mez�n szerepl� sz�m megv�ltoztathat�-e.
     * @param x mez� sorindexe
     * @param y mez� oszlopindexe
     * @return v�ltoztathat�s�g
     */
    public boolean isFieldValueChangeable(final int x, final int y){
        return fields[y][x].changeable;
    }

    /**
     * Seg�df�ggv�ny, mely megvizsg�lja, hogy a megadott sz�m nem szerepel-e m�shol a sorban.
     * @return sorra n�zve lehets�ges-e a number elhelyez�se az adott mez�re.
     */
    private boolean isPossibleX(int y, int number) {
        for (int x = 0; x < MAX_SIZE; ++x) {
            if (fields[y][x].value == number)
                return false;
        }
        return true;
    }


    /**
     * Seg�df�ggv�ny, mely megvizsg�lja, hogy a megadott sz�m nem szerepel-e m�shol az oszlopban.
     * @return oszlopra n�zve lehets�ges-e a number elhelyez�se az adott mez�re.
     */
    private boolean isPossibleY(int x, int number) {
        for (int y = 0; y < MAX_SIZE; ++y) {
            if (fields[y][x].value == number)
                return false;
        }
        return true;
    }

    /**
     * Seg�df�ggv�ny, mely megvizsg�lja, hogy a megadott sz�m nem szerepel-e m�shol a blokkban.
     * @return blokkokra n�zve lehets�ges-e a number elhelyez�se az adott mez�re.
     */
    private boolean isPossibleBlock(int y, int x, int number) {
        // Meghat�rozzuk a kapott param�terek alapj�n az aktu�lis blokk bal fels� elem�nek index�t.
        int blockX = y < 3 ? 0 : y < 6 ? 3 : 6;
        int blockY = x < 3 ? 0 : x < 6 ? 3 : 6;
        // Bej�rjuk a blokkot �s megvizsg�ljuk, hogy szerepel-e benne a sz�m.
        for (int yy = blockX; yy < blockX + 3; ++yy) {
            for (int xx = blockY; xx < blockY + 3; ++xx) {
                if (fields[yy][xx].value == number)
                    return false;
            }
        }
        return true;
    }

    /**
     * Seg�df�ggv�ny, amely visszaadja egy adott mez�re vonatkoz�an, a k�vetkez� �rt�ket
     * Bemeneti param�terek: Az aktu�lis mez� elhelyezked�s�nek indexe a j�t�kt�bl�n
     * @return soron k�vetkez� �rt�k
     */
    private int getNextPossibleNumber(int x, int y) {
        final List<Integer> numbers = new ArrayList<>();
        final int startValue = fields[y][x].value + 1;
        for(int i = startValue; i < 10; ++i){
            numbers.add(i);
        }

        while (numbers.size() > 0) {
            int number = numbers.remove(0);
            if (isPossibleX(y, number) && isPossibleY(x, number) && isPossibleBlock(y, x, number)) {
                return number;
            }
        }
        return 0;
    }

    /**
     * A j�t�kt�bla megfejt�s�t ellen�rz� f�ggv�ny.
     * @return sikeresen megfejtette-e a j�t�kos a rejtv�nyt.
     */
    public boolean checkEndGame(){
       /*
        Megjegyz�s: Mivel a feladatban nem a felhaszn�l� �rja be a sz�mokat, hanem
        a programunk adja ki a r�k�vetkez� lehets�ges l�p�st, ez�rt el�g csak azt
        vizsg�lni, hogy van-e olyan mez� ami �resen �ll. (Az �res mez� a 0 �rt�ket veszi fel)
        */
        for(int i = 0; i < MAX_SIZE; ++i){
            for(int j = 0; j < MAX_SIZE; ++j){
                if(fields[i][j].value == 0) return false;
            }
        }
        return true;
    }

    /**
     * A j�t�kt�bla egy mez�j�t le�r� bels� oszt�ly
     */
    private class Field{
        private int value;
        private boolean changeable = true;
    }
}
