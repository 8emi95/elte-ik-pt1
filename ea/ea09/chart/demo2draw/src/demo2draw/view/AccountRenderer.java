package demo2draw.view;

import chartlib.iface.ItemRenderer;
import demo2draw.model.BankAccount;
import demo2draw.model.SavingsAccount;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class AccountRenderer extends JPanel implements ItemRenderer {

    private BankAccount account;
    
    @Override
    public JComponent getItemRenderer(Object item) {
        setItem(item);
        return this;
    }

    @Override
    public String getToolTipText(Object item) {
        setItem(item);
        return    "<html>"
                + "<b>Account information</b><br>"
                + "<b>NR: </b>" + account.getAccountNumber() + "<br>"
                + "<b>Balance: </b></i>" + account.getBalance() + "</i><br>"
                + "</html>";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final int w = getWidth();
        final int h = getHeight();
        
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = account instanceof SavingsAccount ? Color.RED : Color.CYAN;
        Color color2 = account instanceof SavingsAccount ? Color.ORANGE : Color.BLUE;
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w - 2, h);
    }

    private void setItem(Object item) {
        account = (BankAccount) item;
    }

    @Override
    public void highLight(Graphics g, Rectangle rectangle) {
        int w = rectangle.width - 2;
        int h = rectangle.height;
        int x = rectangle.x;
        int y = rectangle.y;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.darkGray);
        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g2d.drawRect(x, y, w, h);
    }
    
    
    
}
