package kiszuros_amoba;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author rckzz
 */
public class GameBase {

    private Player[][] table;
    private Player actualPlayer;
    private int windowSize;
    private int biggestRow;

    public GameBase(int size) {
        table = new Player[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = Player.NOBODY;
            }
        }
        windowSize = size;
        actualPlayer = Player.X;
    }

    public Player setValue(int i, int j) {

        if (table[i][j] != Player.NOBODY) {
            return table[i][j];
        } else {
            table[i][j] = actualPlayer;
            if (actualPlayer == Player.X) {
                actualPlayer = Player.O;
            } else if (actualPlayer == Player.O) {
                actualPlayer = Player.X;
            }
            return table[i][j];
        }

    }

    public Player[][] getGameTable() {
        return table.clone();
    }

    public void removeElement(int count, Player actual) {
        LinkedList<MyVector> vektorok = new LinkedList<>();
        for (int i = 0; i < windowSize; i++) {
            for (int j = 0; j < windowSize; j++) {
                if (table[i][j] == actual) {
                    vektorok.add(new MyVector(i, j));
                }
            }
        }
        if (count == 3) {
            MyVector tmpvekt = vektorok.get(ThreadLocalRandom.current().nextInt(0, vektorok.size()));
            table[tmpvekt.getX()][tmpvekt.getY()] = Player.NOBODY;
        } else if (count == 4) {
            for (int i = 0; i < 2; i++) {
                MyVector tmpvekt = vektorok.get(ThreadLocalRandom.current().nextInt(0, vektorok.size()));
                table[tmpvekt.getX()][tmpvekt.getY()] = Player.NOBODY;
            }
        }

    }

    public void removeElementIf(int size, Player actual) {

        checkRows(size, actual);
        checkColumns(size, actual);
        lowerTable(size, actual);
        mainDiagonal(size, actual);
        upperTable(size, actual);
        moreDiagonals(size, actual);
        removeElement(biggestRow, actual);
    }

    private void moreDiagonals(int size, Player actual) {
        int var = 1;
        int tmp = 0;
        int row;
        for (int i = 0; i <= size - 1; i++) {
            row = i;
            for (int j = 0; j < var; j++) {
                if (table[row][j] == actual) {
                    tmp++;
                    if (tmp == 3 && biggestRow == 0) {
                        biggestRow = 3;
                    } else if (tmp == 4 && biggestRow < 4) {
                        biggestRow = 4;
                    } else if (tmp == 5 && biggestRow < 5) {
                        biggestRow = 5;
                    }
                } else {
                    tmp = 0;
                }
                row--;
            }
            var++;
            tmp = 0;
        }
        var = 1;
        tmp = 0;
        for (int i = size - 1; i >= 0; i--) {
            row = i;
            int column = size - 1;
            for (int j = 0; j < var; j++) {
                //System.out.println(row+" "+column);
                if (table[row][column] == actual) {
                    tmp++;
                    if (tmp == 3 && biggestRow == 0) {
                        biggestRow = 3;
                    } else if (tmp == 4 && biggestRow < 4) {
                        biggestRow = 4;
                    } else if (tmp == 5 && biggestRow < 5) {
                        biggestRow = 5;
                    }
                } else {
                    tmp = 0;
                }
                column--;
                row++;
            }
            var++;
            tmp = 0;
        }
    }

    private void upperTable(int size, Player actual) {
        //felsőháromszög
        int var = 1;
        int tmp = 0;
        int row;
        for (int i = size - 1; i >= 0; i--) {
            row = i;
            for (int j = 0; j < var; j++) {
                if (table[j][row] == actual) {
                    tmp++;
                    if (tmp == 3 && biggestRow == 0) {
                        biggestRow = 3;
                    } else if (tmp == 4 && biggestRow < 4) {
                        biggestRow = 4;
                    } else if (tmp == 5 && biggestRow < 5) {
                        biggestRow = 5;
                    }
                } else {
                    tmp = 0;
                }
                row++;
            }
            var++;
            tmp = 0;
        }
    }

    private void mainDiagonal(int size, Player actual) {
        //főátló
        int tmp = 0;
        for (int i = 0; i < size; i++) {
            if (table[i][i] == actual) {
                tmp++;
                if (tmp == 3 && biggestRow == 0) {
                    biggestRow = 3;
                } else if (tmp == 4 && biggestRow < 4) {
                    biggestRow = 4;
                } else if (tmp == 5 && biggestRow < 5) {
                    biggestRow = 5;
                }
            } else {
                tmp = 0;
            }
        }
        int c = 0;
        tmp = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (table[i][c] == actual) {
                tmp++;
                if (tmp == 3 && biggestRow == 0) {
                    biggestRow = 3;
                } else if (tmp == 4 && biggestRow < 4) {
                    biggestRow = 4;
                } else if (tmp == 5 && biggestRow < 5) {
                    biggestRow = 5;
                }
            } else {
                tmp = 0;
            }
            c++;
        }
    }

    private void lowerTable(int size, Player actual) {
        //átlós
        int var = 1;
        int row;
        int tmp = 0;
        //alsóháromszög
        for (int i = size - 1; i >= 0; i--) {
            row = i;
            for (int j = 0; j < var; j++) {
                if (table[row][j] == actual) {
                    tmp++;
                    if (tmp == 3 && biggestRow == 0) {
                        biggestRow = 3;
                    } else if (tmp == 4 && biggestRow < 4) {
                        biggestRow = 4;
                    } else if (tmp == 5 && biggestRow < 5) {
                        biggestRow = 5;
                    }
                } else {
                    tmp = 0;
                }
                row++;
            }
            var++;
            tmp = 0;
        }
    }

    private void checkColumns(int size, Player actual) {
        //oszlopos
        int tmp = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[j][i] == actual) {
                    tmp++;
                    if (tmp == 3 && biggestRow == 0) {
                        biggestRow = 3;
                    } else if (tmp == 4 && biggestRow < 4) {
                        biggestRow = 4;
                    } else if (tmp == 5 && biggestRow < 5) {
                        biggestRow = 5;
                    }
                } else {
                    tmp = 0;
                }
            }
            tmp = 0;
        }
    }

    private void checkRows(int size, Player actual) {
        //sorfolytonos ellenőrzés
        int tmp = 0;
        biggestRow = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == actual) {
                    tmp++;
                    if (tmp == 3 && biggestRow == 0) {
                        biggestRow = 3;
                    } else if (tmp == 4 && biggestRow < 4) {
                        biggestRow = 4;
                    } else if (tmp == 5 && biggestRow < 5) {
                        biggestRow = 5;
                    }
                } else {
                    tmp = 0;
                }
            }
            tmp = 0;
        }
    }

    public boolean winnerFound() {
        boolean found = false;
        if (biggestRow == 5) {
            found = true;
        }
        return found;
    }

    public boolean isDraw() {
        boolean draw = false;
        int count = 0;
        for (int i = 0; i < windowSize; i++) {
            for (int j = 0; j < windowSize; j++) {
                if (table[i][j] != Player.NOBODY) {
                    count++;
                }
            }
        }
        return (count == windowSize * windowSize);

    }

    public Player getActualPlayer() {
        return actualPlayer;
    }
}
