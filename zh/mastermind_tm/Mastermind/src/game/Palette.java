package game;

import java.awt.*;

public enum Palette {
    WHITE(Color.WHITE),BLACK(Color.BLACK),RED(255,51,51),GREEN(51,204,51),BLUE(51,153,255),YELLOW(255,255,102);


    Palette(int r, int g, int b) {
        this.color = new Color(r,g,b);
    }

    public Color getColor() {
        return color;
    }

    private final Color color;

    Palette(Color color) {
        this.color = color;
    }
}
