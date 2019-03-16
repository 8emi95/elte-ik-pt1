import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EgérTeszt extends JFrame
{
    private static final Dimension  címkeméret = new Dimension(100, 24);
    private JLabel  hely;
    private JLabel  gomb;
    private JLabel  esemény;

    public EgérTeszt()
    {
        JPanel  terület = new JPanel();
        terület.setPreferredSize(new Dimension(300, 200));
        terület.setBorder(BorderFactory.createEtchedBorder());
        terület.addMouseListener(egér);
        terület.addMouseMotionListener(egér);
        terület.addMouseWheelListener(egér);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel  info = new JPanel(new GridLayout(1, 3));
        hely = new JLabel();    hely.setPreferredSize(címkeméret);
        hely.setBorder(BorderFactory.createEtchedBorder());
        gomb = new JLabel();    gomb.setPreferredSize(címkeméret);
        gomb.setBorder(BorderFactory.createEtchedBorder());
        esemény = new JLabel(); esemény.setPreferredSize(címkeméret);
        esemény.setBorder(BorderFactory.createEtchedBorder());
        info.add(hely);
        info.add(gomb);
        info.add(esemény);
        add("North", info);
        add("Center", terület);
        pack();
        setVisible(true);
    }

    private MouseAdapter    egér = new MouseAdapter()
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            hely.setText("(" + e.getX() + "," + e.getY() + ")");
            esemény.setText("kattintás");
            switch ( e.getButton() )
            {
                case MouseEvent.BUTTON1:    gomb.setText("Gomb 1"); break;
                case MouseEvent.BUTTON2:    gomb.setText("Gomb 2"); break;
                case MouseEvent.BUTTON3:    gomb.setText("Gomb 3"); break;
                default:                    gomb.setText("");       break;
            }
        }

        @Override
        public void mouseMoved(MouseEvent e)
        {
            hely.setText("(" + e.getX() + "," + e.getY() + ")");
            esemény.setText("mozgatás");
            gomb.setText("");
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            hely.setText("");
            esemény.setText("elhagy");
            gomb.setText("");
        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
            hely.setText("");
            esemény.setText("belép");
            int b = e.getModifiersEx();
            if ( (b & MouseEvent.BUTTON1_DOWN_MASK) != 0 )  gomb.setText("Gomb 1");
            if ( (b & MouseEvent.BUTTON2_DOWN_MASK) != 0 )  gomb.setText("Gomb 2");
            if ( (b & MouseEvent.BUTTON3_DOWN_MASK) != 0 )  gomb.setText("Gomb 3");
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            hely.setText("(" + e.getX() + "," + e.getY() + ")");
            esemény.setText("lenyomva");
            switch ( e.getButton() )
            {
                case MouseEvent.BUTTON1:    gomb.setText("Gomb 1"); break;
                case MouseEvent.BUTTON2:    gomb.setText("Gomb 2"); break;
                case MouseEvent.BUTTON3:    gomb.setText("Gomb 3"); break;
                default:                    gomb.setText("");       break;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            hely.setText("(" + e.getX() + "," + e.getY() + ")");
            esemény.setText("felengedve");
            switch ( e.getButton() )
            {
                case MouseEvent.BUTTON1:    gomb.setText("Gomb 1"); break;
                case MouseEvent.BUTTON2:    gomb.setText("Gomb 2"); break;
                case MouseEvent.BUTTON3:    gomb.setText("Gomb 3"); break;
                default:                    gomb.setText("");       break;
            }
        }

        @Override
        public void mouseDragged(MouseEvent e)
        {
            hely.setText("(" + e.getX() + "," + e.getY() + ")");
            esemény.setText("húzás");
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e)
        {
            esemény.setText("görgetés");
            gomb.setText("" + e.getWheelRotation());
        }
    };

    public static void main(String[] args)
    {
        new EgérTeszt();
    }
}
