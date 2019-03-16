package chartlib.scale;

import chartlib.iface.ScaleModel;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinearScale implements ScaleModel {

    private int begin;
    private int end;
    private int interval;
    
    private List<Integer> values = new LinkedList<>();

    public LinearScale(int begin, int end, int interval) {
        this.begin = begin;
        this.end = end;
        this.interval = interval;
        calculateValues();
    }
    
    @Override
    public int getBegin() {
        return begin;
    }

    @Override
    public int getEnd() {
        return end;
    }

    @Override
    public List<Integer> getValues() {
        return values;
    }

    private void calculateValues() {
        for(int i = begin; i < end; i += interval) {
            values.add(i);
        }
        values.add(end);
        values = Collections.unmodifiableList(values);
    }

    @Override
    public int getLength() {
        return getEnd() - getBegin();
    }

    @Override
    public boolean useAuxiliaryLine() {
        return false;
    }
    
}
