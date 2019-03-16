package logic;

public class Player {
    public enum PlayerType{
        KNIGHT,
        VOLT,
        NOBODY;
    }
    private final PlayerType type;
    private int x;   
    private int y;
    //player konstruktora
    Player(int x, int y, PlayerType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
    //type gettere
    public PlayerType getType() {
        return type;
    }
    //x gettere
    public int getX() {
        return x;
    }
    //y gettere
    public int getY() {
        return y;
    }
    //x settere
    public void setX(int x) {
        this.x = x;
    }
    //y settere
    public void setY(int y) {
        this.y = y;
    }
    
}
