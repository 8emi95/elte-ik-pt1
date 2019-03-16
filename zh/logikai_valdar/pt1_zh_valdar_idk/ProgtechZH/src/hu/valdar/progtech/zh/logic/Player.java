
package hu.valdar.progtech.zh.logic;

public enum Player {
    ONE, TWO, NOBODY;

    public Player getOpponent() {
        switch (this) {
        case ONE:
                return TWO;
        case TWO:
                return ONE;
        default:
                return NOBODY;
        }
    }
}
