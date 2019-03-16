import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.IOException;
import java.nio.file.Paths;

public class GamePanel extends JPanel {
    private final Engine engine;
    private final GameInfoPanel gameInfoPanel;
    private final GameFrame gameFrame;
    private String fileName;
    
    public GamePanel(Engine engine, GameInfoPanel gameInfoPanel, GameFrame gameFrame) {
        setBackground(java.awt.Color.BLACK);
        this.gameInfoPanel = gameInfoPanel;
        this.engine = engine;
        this.gameFrame = gameFrame;
        
        try {
            BufferedImage myPicture = ImageIO.read(new File(engine.getRandomCountry().getFlagUrl()));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            add(picLabel);            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
      
        JButton btn = new JButton("Tallózás");
        add(btn);
        btn.addActionListener(e -> {
            selectFile();
            //engine.constructEngine(fileName);
        });
         String[] countries = engine.getCountryNames().toArray(new String[engine.getCountryNames().size()]);
        JList<String> myList = new JList<String>(countries);
        add(myList);
        
        setVisible(true);
        


    }
       
    
    public void selectFile() {
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(Paths.get(".").toAbsolutePath().normalize().toString());
        chooser.setCurrentDirectory(workingDirectory);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("FLAG Images", "flag");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(gameFrame);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            fileName = chooser.getSelectedFile().getName();
        }
    }

    public String getFileName() {
        return fileName;
    }
}
