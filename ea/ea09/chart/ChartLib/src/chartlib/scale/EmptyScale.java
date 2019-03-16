package chartlib.scale;

import chartlib.iface.ScaleModel;
import java.util.Collections;
import java.util.List;

public class EmptyScale implements ScaleModel {

    @Override
    public int getBegin() {
        return 0;
    }

    @Override
    public int getEnd() {
        return 1000;
    }

    @Override
    public List<Integer> getValues() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public int getLength() {
        return 1000;
    }

    @Override
    public boolean useAuxiliaryLine() {
        return false;
    }
}
