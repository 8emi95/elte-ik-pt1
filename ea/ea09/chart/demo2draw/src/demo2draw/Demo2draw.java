package demo2draw;

import demo2draw.view.AccountView;
import demo2draw.model.BankModel;

public class Demo2draw {

    public static void main(String[] args) {
        
        new AccountView(new BankModel()).setVisible(true);
    }
    
}
