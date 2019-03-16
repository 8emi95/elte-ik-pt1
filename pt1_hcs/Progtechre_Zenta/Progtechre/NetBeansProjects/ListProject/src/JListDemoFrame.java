import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class JListDemoFrame extends JFrame implements ListSelectionListener{

    private String[] honapok = {"január", "február", "március", "április", "május", "június", "július", "augusztus", "szeptember", "október", "november", "december"};
    private JList lsHonapok = new JList(honapok);
    
    public JListDemoFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 150, 300, 200);
        setLayout(new FlowLayout());
        add(new JScrollPane(lsHonapok)); //a csúszkát adja hozzá
        lsHonapok.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsHonapok.addListSelectionListener(this);
        lsHonapok.setSelectedIndex(0);
        lsHonapok.setVisibleRowCount(5);
        setVisible(true);
    }
    
    public void valueChanged(ListSelectionEvent e){
        setTitle((String)lsHonapok.getSelectedValue());
    }
    
    public static void main(String[] args) {
        new JListDemoFrame();
    }
    
}
