package demo2draw.view;

import chartlib.iface.ChartItem;
import demo2draw.model.BankAccount;

/**
 * Specific implementation of the chartItem
 * where
 *  the content is a bank account
 *  its value is the balance.....
 * 
 */
public class AccountItem implements ChartItem {
    private BankAccount delegate;

    public AccountItem(BankAccount delegate) {
        this.delegate = delegate;
    }

    @Override
    public int getValue() {
        return delegate.getBalance();
    }

    @Override
    public Object getContent() {
        return delegate;
    }

    @Override
    public String getLabel() {
        return delegate.getAccountNumber() + "";
    }
    
}
