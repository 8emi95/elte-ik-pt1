package demo2draw.model;

import java.util.LinkedList;
import java.util.List;

public class BankModel {

    private List<BankAccount> accounts = new LinkedList<>();

    public BankModel() {
        accounts.add(new SavingsAccount(1233123, 9000, 7));
        accounts.add(new SavingsAccount(1411544, 1000, 7));
        accounts.add(new NormalAccount (1795156, 2000, 3000));
        accounts.add(new SavingsAccount(1658485, 5000, 7));
        accounts.add(new NormalAccount (1215468, 3000, 1000));
        accounts.add(new SavingsAccount(1948792, 7000, 7));
        accounts.add(new SavingsAccount(1885881, 500, 7));
    }

    public int getMaxBalance() {
        return accounts.stream().mapToInt(BankAccount::getBalance).max().getAsInt();
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

}
