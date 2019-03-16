package chartlib.chart;

import chartlib.iface.ChartItem;
import chartlib.ChartItemView;
import chartlib.iface.ItemRenderer;
import chartlib.iface.ScaleModel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.CellRendererPane;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;

public class ColumnChart extends JPanel {
    private final ScaleModel verticalScale;
    private final ScaleModel horizontalScale;
    private final ItemRenderer renderer;
    
    /**
     * Distance from the left side of the parent
     */
    private int leftShift = 100;
    private int buttomShift = 100;
    private int topShift = 30;
    
    /**
     * Measures for the scales
     */
    private int scaleWidth;
    private int scaleHeight;
    /**
     * CellRendererPane is inserted in between cell renderers and the components that
     * use them.  It just exists to thwart the repaint() and invalidate() methods
     * which would otherwise propagate up the tree when the renderer was configured.
     * It's used by the implementations of JTable, JTree, and JList.  For example,
     * here's how CellRendererPane is used in the code the paints each row.
     * 
     * It also can be used to restrict the drawing area of a component to a specified
     * rectangle.
     */
    private CellRendererPane rendererPane = new CellRendererPane();
    private List<ChartItemView> itemViews = new LinkedList<>();
    /**
     * The highlighted element. Null if there is none.
     */
    private ChartItemView highlighted;

    public ColumnChart(ScaleModel horiziontalScal, ScaleModel verticalScale, ItemRenderer renderer, Collection<ChartItem> data) {
        this.horizontalScale = horiziontalScal;
        this.verticalScale = verticalScale;
        this.renderer = renderer;
        addItems(data);
        /**
         * Componenet listener that handle the resize event for the chart
         * in case of resize the scale measures and the size of the displayed 
         * chart elements has to be adjusted.
         */
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                computeRectangleForItems();
                scaleHeight = getHeight() - buttomShift - topShift;
                scaleWidth = getWidth() - leftShift * 2;
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // find out if we pointing on a chart item
                ChartItemView view = getViewAt(e.getPoint());
                // if we are and that view is not already highlighted
                //..highlight it.
                if(view != null && view != highlighted) {
                    highlight(view);
                } else if(view == null && highlighted != null) {
                // if we are not, and there is a highlighted one
                //..unhighlight it.
                    highlight(null);
                }
            }
            private void highlight(ChartItemView view) {
                highlighted = view;
                refresh();
            }
        });
        ToolTipManager.sharedInstance().registerComponent(this);
        add(rendererPane);
    }

    /**
     * redraw the chart
     */
    private void refresh() {
        invalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        drawHorizontalScale(g2d);
        drawVerticalScale(g2d);
        
        paintItems(g2d);
        g2d.dispose();
    }

    private void drawVerticalScale(Graphics2D g2d) {
        // draw the wertical axis
        g2d.drawLine(leftShift, topShift, leftShift, topShift + scaleHeight );
        int x = leftShift - 5;
        // draw the scale elements
        for(int v : verticalScale.getValues()) {
            int y = getVerticalScalePosition(v);
            g2d.drawLine(x, y, x + 10, y);
            g2d.drawString(""+v, x - topShift, y + 5);
            // draw auxiliary lines if needed
            if(verticalScale.useAuxiliaryLine()) {
                Color orig = g2d.getColor();
                Stroke origs = g2d.getStroke();
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 4, new float[]{3f, 5f}, 1));
                g2d.drawLine(x + 10, y, x + scaleWidth, y);
                g2d.setColor(orig);
                g2d.setStroke(origs);
            }
        }
    }

    private int getVerticalScalePosition(int v) {
        int h = getHeight() - buttomShift - topShift;
        double ratio = v / (double) verticalScale.getLength();
        
        return (int) (getHeight() - buttomShift - (h * ratio));
    }

    private void drawHorizontalScale(Graphics2D g2d) {
        // draw the horizontal axis
        g2d.drawLine(leftShift, topShift + scaleHeight, leftShift + scaleWidth, topShift + scaleHeight);
        int y = getHeight() - buttomShift - 5;
        // draw the horizontal scale elements
        for(int v : horizontalScale.getValues()) {
            int x = getHorizontalScalePosition(v);
            g2d.drawLine(x, y, x, y + 10);
            g2d.drawString(""+v, x - 10, y + 25);
        }
    }

    private int getHorizontalScalePosition(int v) {
        int w = getWidth() - leftShift * 2;
        double ratio = v / (double) horizontalScale.getLength();
        
        return (int) (leftShift + (w * ratio));
    }
    
    /**
     * Paint the chart items
     * @param g 
     */
    private void paintItems(Graphics g) {
        Iterator<ChartItemView> it = itemViews.iterator();
        while(it.hasNext()) {
            ChartItemView view = it.next();
            // Get the renderer and tell it what object to render
            Component rendererComponent = renderer.getItemRenderer(view.getItem().getContent());
            final Rectangle rect = view.getRectangle();
            // restrict the renderer area using RECT and paint
            rendererPane.paintComponent(g, rendererComponent, this, rect.x, rect.y, rect.width, rect.height, true);
            // if the current view is highlighted, ask the renderer to highlight itself
            if(highlighted != null && view == highlighted) {
                renderer.highLight(g, rect);
            }
            // draw the label
            g.drawString(view.getItem().getLabel(), rect.x, rect.height + 30 + rect.y);
        }
    }

    private void addItems(Collection<ChartItem> data) {
        Iterator<ChartItem> it = data.iterator();
        while(it.hasNext()) {
            ChartItem item = it.next();
            itemViews.add(new ChartItemView(item));
        }
        computeRectangleForItems();
    }

    private void computeRectangleForItems() {
        int i = 0;
        for(ChartItemView view : itemViews) {
            Rectangle rect = computeRectangleForItem(view.getItem(), i++);
            view.setRectangle(rect);
        }          
    }

    /**
     * Compute the displayed rectange for the chart item
     * 
     * @param item
     * @param index
     * @return 
     */
    private Rectangle computeRectangleForItem(ChartItem item, int index) {
        int scaleWidth = getWidth() - leftShift * 2;
        int w = scaleWidth / (itemViews.size()) - 20;
        
        int h = getHeight() - buttomShift - topShift;
        double ratio = item.getValue() / (double) verticalScale.getLength();
        h = (int) (h * ratio);
        
        int x = leftShift + 20 + index * (w + 20);
        int y = getHeight() - buttomShift - h;
        return new Rectangle(x, y, w, h);
    }

    @Override
    public String getToolTipText(MouseEvent event) {
        // Find a view we are pointing at
        ChartItemView view = getViewAt(event.getPoint());
        if(view != null) {
            // and ask the renderer for its tooltip
            return renderer.getToolTipText(view.getItem().getContent());
        }
        return "";
    }

    private ChartItemView getViewAt(Point point) {
        for(ChartItemView view : itemViews) {
            if(view.contains(point)) {
                return view;
            }
        }
        return null;
    }

}
