package chartlib.iface;

import java.util.List;

public interface ScaleModel {
    public int getBegin();
    public int getEnd();
    
    /**
     * List the values that should be marked on the scale
     * @return 
     */
    public List<Integer> getValues();

    public int getLength();
    
    public boolean useAuxiliaryLine();
}
