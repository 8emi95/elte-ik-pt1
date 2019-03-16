package szamlalo;
import javax.swing.JLabel;

public class SzámlálóCímke extends JLabel {
    public SzámlálóCímke(){
        setText("Kattintások száma: 0");
    }
    
    public void setKattintasokSzama(int kattintasok) {
        setText("Kattintások száma: " + kattintasok);
    }
}
