import javax.swing.*;
import java.awt.*;


public class GameFrame extends JFrame {

    private final Engine engine;
    private final GamePanel gamePanel;
    private final GameInfoPanel gameInfoPanel;

    public GameFrame(Engine engine) {
        setFrameProperties();
        applyNimbusLookAndFeelTheme();

        this.engine = engine;
        this.gameInfoPanel = new GameInfoPanel();
        this.gamePanel = new GamePanel(engine, gameInfoPanel, this);
        
        add(gameInfoPanel, BorderLayout.EAST);
        add(gamePanel, BorderLayout.CENTER);

        pack();
    }

    private void setFrameProperties() {
        setTitle("ultimate source of happiness for Balázs");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }
    
    
    private void applyNimbusLookAndFeelTheme(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }
    }

}