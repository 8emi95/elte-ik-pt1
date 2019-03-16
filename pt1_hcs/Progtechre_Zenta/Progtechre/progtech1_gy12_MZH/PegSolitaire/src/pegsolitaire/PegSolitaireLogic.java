package pegsolitaire;

public class PegSolitaireLogic {

    private class PegNode {

        boolean isExisting, hasPeg;
    }
    private final PegNode[][] pegs;

    public PegSolitaireLogic() {
        this(7, 7);
    }

    private PegSolitaireLogic(int width, int height) {
        if (width > 0 && height > 0) {
            pegs = new PegNode[height][width];
            newGame();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final void newGame() {
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                pegs[i][j] = new PegNode();
                setPeg(i, j, true, true);
            }
        }
        setPegBlock(0, 2, 0, 2);
        setPegBlock(5, 7, 0, 2);
        setPegBlock(0, 2, 5, 7);
        setPegBlock(5, 7, 5, 7);
        setPeg(3, 3, true, false);
    }

    public int getHeight() {
        return pegs.length;
    }

    public int getWidth() {
        return pegs[0].length;
    }

    public boolean isPegExisting(int x, int y) {
        return pegs[x][y].isExisting;
    }

    public boolean hasPeg(int x, int y) {
        return pegs[x][y].hasPeg;
    }

    private void setPeg(int x, int y, boolean isExisting, boolean hasPeg) {
        pegs[x][y].isExisting = isExisting;
        pegs[x][y].hasPeg = hasPeg;
    }

    private void setPegBlock(int xFrom, int xTo, int yFrom, int yTo) {
        for (int i = xFrom; i < xTo; i++) {
            for (int j = yFrom; j < yTo; j++) {
                setPeg(i, j, false, false);
            }
        }
    }

    public void doPegJump(int xFrom, int yFrom, int xTo, int yTo) {
        if (xFrom == xTo && Math.abs(yFrom - yTo) == 2) {
            doInternalPegJump(xFrom, yFrom, 0, yFrom - yTo < 0 ? 1 : -1);
        } else if (yFrom == yTo && Math.abs(xFrom - xTo) == 2) {
            doInternalPegJump(xFrom, yFrom, xFrom - xTo < 0 ? 1 : -1, 0);
        }
    }

    private void doInternalPegJump(int xFrom, int yFrom, int xDiff, int yDiff) {
        if (!pegs[xFrom][yFrom].isExisting) {
            return;
        }
        if (!pegs[xFrom + xDiff][yFrom + yDiff].isExisting) {
            return;
        }
        if (!pegs[xFrom + xDiff * 2][yFrom + yDiff * 2].isExisting) {
            return;
        }
        if (!pegs[xFrom][yFrom].hasPeg) {
            return;
        }
        if (!pegs[xFrom + xDiff][yFrom + yDiff].hasPeg) {
            return;
        }
        if (pegs[xFrom + xDiff * 2][yFrom + yDiff * 2].hasPeg) {
            return;
        }

        pegs[xFrom][yFrom].hasPeg = false;
        pegs[xFrom + xDiff][yFrom + yDiff].hasPeg = false;
        pegs[xFrom + xDiff * 2][yFrom + yDiff * 2].hasPeg = true;
    }

    public boolean isGameWon() {
        int countOfPegs = 0;
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                countOfPegs += pegs[i][j].hasPeg ? 1 : 0;
            }
        }
        return countOfPegs == 1;
    }
}
