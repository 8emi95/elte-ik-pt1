// Minta.java
import javax.swing.*;
import java.awt.*;

public class Minta extends JFrame {
  Container cp = getContentPane();
  public Minta() {
    cp.setLayout(new FlowLayout());
    // utasítások
    pack();
    show();
  }

  public static void main (String args[]) {
    new Minta();
  }
}
