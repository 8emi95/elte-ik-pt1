
public class Launcher {

    public static void main(String[] args){
        GameFrame gameFrame = new GameFrame(new Engine("countries.flag"));
        gameFrame.setVisible(true);
    }
}
