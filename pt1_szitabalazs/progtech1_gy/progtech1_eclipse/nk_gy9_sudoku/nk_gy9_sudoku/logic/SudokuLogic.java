package nk_gy9_sudoku.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * A játék logikáját meghatározó osztály.
 * @author Nagy Krisztián
 */
public class SudokuLogic {
    /**
     * A játéktér méretét leíró mezõ
     */
    private static final int MAX_SIZE = 9;
    /**
     * Mezõket tartalmazó mátrix
     */
    private Field[][] fields;

    /**
     * A játék logika paraméter nélküli konstruktora.
     */
    public SudokuLogic(){
        createNewGame();
    }

    /**
     * Új játék létrehozásáért felelõs eljárás.
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
     * Setter eljárás, mely beállítja a mezõben szereplõ számot a következõ lehetséges számra.
     * @param x mezõ sorindexe
     * @param y mezõ oszlopindexe
     */
    public void setFieldValue(final int x, final int y){
        fields[y][x].value = getNextPossibleNumber(x,y);
    }

    /**
     * Getter függvény, mely visszaadja a mezõben szereplõ számot.
     * @param x mezõ sorindexe
     * @param y mezõ oszlopindexe
     * @return mezõben található szám
     */
    public int getFieldValue(int x, int y) {
        return fields[y][x].value;
    }

    /**
     * Eljárás amely beállítja az adott mezõt megváltoztathatatlanra.
     * @param x mezõ sorindexe
     * @param y mezõ oszlopindexe
     */
    public void setFieldValueUnchangeable(final int x, final int y){
        fields[y][x].changeable = false;
    }

    /**
     * Függvény, amely megmondja hogy egy adott mezõn szereplõ szám megváltoztatható-e.
     * @param x mezõ sorindexe
     * @param y mezõ oszlopindexe
     * @return változtathatóság
     */
    public boolean isFieldValueChangeable(final int x, final int y){
        return fields[y][x].changeable;
    }

    /**
     * Segédfüggvény, mely megvizsgálja, hogy a megadott szám nem szerepel-e máshol a sorban.
     * @return sorra nézve lehetséges-e a number elhelyezése az adott mezõre.
     */
    private boolean isPossibleX(int y, int number) {
        for (int x = 0; x < MAX_SIZE; ++x) {
            if (fields[y][x].value == number)
                return false;
        }
        return true;
    }


    /**
     * Segédfüggvény, mely megvizsgálja, hogy a megadott szám nem szerepel-e máshol az oszlopban.
     * @return oszlopra nézve lehetséges-e a number elhelyezése az adott mezõre.
     */
    private boolean isPossibleY(int x, int number) {
        for (int y = 0; y < MAX_SIZE; ++y) {
            if (fields[y][x].value == number)
                return false;
        }
        return true;
    }

    /**
     * Segédfüggvény, mely megvizsgálja, hogy a megadott szám nem szerepel-e máshol a blokkban.
     * @return blokkokra nézve lehetséges-e a number elhelyezése az adott mezõre.
     */
    private boolean isPossibleBlock(int y, int x, int number) {
        // Meghatározzuk a kapott paraméterek alapján az aktuális blokk bal felsõ elemének indexét.
        int blockX = y < 3 ? 0 : y < 6 ? 3 : 6;
        int blockY = x < 3 ? 0 : x < 6 ? 3 : 6;
        // Bejárjuk a blokkot és megvizsgáljuk, hogy szerepel-e benne a szám.
        for (int yy = blockX; yy < blockX + 3; ++yy) {
            for (int xx = blockY; xx < blockY + 3; ++xx) {
                if (fields[yy][xx].value == number)
                    return false;
            }
        }
        return true;
    }

    /**
     * Segédfüggvény, amely visszaadja egy adott mezõre vonatkozóan, a következõ értéket
     * Bemeneti paraméterek: Az aktuális mezõ elhelyezkedésének indexe a játéktáblán
     * @return soron következõ érték
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
     * A játéktábla megfejtését ellenörzõ függvény.
     * @return sikeresen megfejtette-e a játékos a rejtvényt.
     */
    public boolean checkEndGame(){
       /*
        Megjegyzés: Mivel a feladatban nem a felhasználó írja be a számokat, hanem
        a programunk adja ki a rákövetkezõ lehetséges lépést, ezért elég csak azt
        vizsgálni, hogy van-e olyan mezõ ami üresen áll. (Az üres mezõ a 0 értéket veszi fel)
        */
        for(int i = 0; i < MAX_SIZE; ++i){
            for(int j = 0; j < MAX_SIZE; ++j){
                if(fields[i][j].value == 0) return false;
            }
        }
        return true;
    }

    /**
     * A játéktábla egy mezõjét leíró belsõ osztály
     */
    private class Field{
        private int value;
        private boolean changeable = true;
    }
}
