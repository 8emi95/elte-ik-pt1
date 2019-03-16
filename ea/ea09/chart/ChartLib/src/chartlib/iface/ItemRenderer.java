package chartlib.iface;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;

public interface ItemRenderer {
    /**
     * Create a renderer for the given object
     * 
     * @param item
     * @return 
     */
    JComponent getItemRenderer(Object item);
    
    String getToolTipText(Object item);
    
    void highLight(Graphics g, Rectangle rectangle);
}
