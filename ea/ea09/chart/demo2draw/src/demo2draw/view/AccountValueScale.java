package demo2draw.view;

import chartlib.iface.ScaleModel;
import demo2draw.model.BankAccount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Specific implementation of the ScaleModel
 * 
 * displays only existing values on the scales
 */
class AccountValueScale implements ScaleModel {

    private List<Integer> values;
    private int maxValue;
    
    public AccountValueScale(List<BankAccount> accounts, int max) {
        maxValue = max;
        values = new ArrayList<>(accounts.size());
        for(BankAccount ba : accounts) {
            values.add(ba.getBalance());
        }
        Collections.sort(values);
        values = Collections.unmodifiableList(values);
    }

    @Override
    public int getBegin() {
        return 0;
    }

    @Override
    public int getEnd() {
        return maxValue;
    }

    @Override
    public List<Integer> getValues() {
        return values;
    }

    @Override
    public int getLength() {
        return getEnd() - getBegin();
    }

    @Override
    public boolean useAuxiliaryLine() {
        return true;
    }
    
}
