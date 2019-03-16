import java.awt.*;
import javax.swing.*;

public class FlowLayoutTest extends JFrame{
    
    private Container cp = getContentPane();
    
    public FlowLayoutTest() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("FlowLayout");
        LayoutManager lm = new FlowLayout();
        cp.setLayout(lm);
        for (int i = 0; i <= 10; i++) {
            cp.add(new JTextField(5));
            cp.add(new JButton("Gomb "+i));
        }
        setSize(700,150);
        setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FlowLayoutTest();
    }
    
}
