package game.model;

import game.Palette;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MastermindEngine {

    public static final int TRY_SIZE = 10;
    public static final int COLOR_COUNTY = 4;
    private static final Palette[] colours = Palette.values();
    private Palette[][] userschoice;
    private Palette[] field;
    private int actualRow;

    public void startNewGame() {
        actualRow = 0;
        field = new Palette[COLOR_COUNTY];
        userschoice = new Palette[TRY_SIZE][COLOR_COUNTY];
        for (int i = 0; i < COLOR_COUNTY; i++) {
            Palette p =  getRandomColor();
            field[i] = p;
            System.out.println(p.name());
        }
    }

    private Palette getRandomColor() {
        return colours[new Random().nextInt(colours.length)];
    }


    public boolean isGameOver() {
        return actualRow > TRY_SIZE;
    }

    public boolean isGameOverWin() {
        return actualRow > 0 && actualRow <= TRY_SIZE && isCorrect(actualRow - 1) == 4 ;
    }

    public void click(int i, int j) {
        if (actualRow == i) {
            if (userschoice[i][j] == null) {
                userschoice[i][j] = colours[0];
            }
            int index = 0;
            for (int k = 0; k < colours.length; k++) {
                if (colours[k] == userschoice[i][j]) {
                    index = k;
                    break;
                }
            }
            if (index == colours.length - 1) {
                index = 0;
            } else {
                index++;
            }
            userschoice[i][j] = colours[index];
        }
    }

    public Color getBackgroundColor(int i, int j) {
        if (userschoice[i][j] == null) {
            if(actualRow == i){
                return null;
            }
            return Color.GRAY;
        } else {
            return userschoice[i][j].getColor();
        }
    }

    public int isCorrect(int j) {
        int counter = 0;
        for(int i = 0; i < COLOR_COUNTY;i++) {
            if (userschoice[j][i] != null && userschoice[j][i] == (field[i])) {
                counter++;
            }
        }
        return counter;
    }

    public int isInside(int i) {
        Set<Palette> choices = new HashSet<>(Arrays.asList(userschoice[i]));
        int counter = 0;
        List<Palette> fields = Arrays.asList(field);
        for(Palette p : choices) {
            if (fields.contains(p) ) {
                counter++;
            }
        }
        return counter;
    }

    public void next() {
        ArrayList<Palette> choices = new ArrayList<>(Arrays.asList(userschoice[actualRow]));
        choices.removeIf(i -> i == null);
        if(choices.size() == COLOR_COUNTY){
            actualRow++;

        }

    }
}

