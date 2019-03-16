package bead2.logic;

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

    @Override
    public String toString() {
        String playerToString;
        switch(this) {
            case ONE:
                playerToString = "Player1";
                break;
            case TWO:
                playerToString = "Player2";
                break;
            default:
                playerToString = "Nobody";
        }
        return playerToString;
    }
}