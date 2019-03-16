package chartlib;

import chartlib.iface.ChartItem;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * Represents a single element displayed on a chart
 * for example a single column of a column chart
 * 
 */
public class ChartItemView {
    
    private ChartItem item;
    
    private Rectangle rectangle;

    public ChartItemView(ChartItem item) {
        this.item = item;
    }

    public ChartItem getItem() {
        return item;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public boolean contains(Point point) {
        return rectangle.contains(point);
    }
}
