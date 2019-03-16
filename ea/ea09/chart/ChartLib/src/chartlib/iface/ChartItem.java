package chartlib.iface;

/**
 * Represents the actual object being displayd via a CharItemView
 * 
 */
public interface ChartItem {
    /**
     * Returns the value with wich the object should be represented on the chart
     * 
     * @return 
     */
    int getValue();
    
    /**
     * Returns the actual object
     * 
     * @return 
     */
    Object getContent();
    
    /**
     * Returns the label description of the item
     * 
     * @return 
     */
    String getLabel();
}
