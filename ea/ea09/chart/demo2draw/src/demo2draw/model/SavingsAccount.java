package demo2draw.model;

public class SavingsAccount extends BankAccount {
    
    private int interest;

    public SavingsAccount(int accountNumber, int balance, int interest) {
        super(accountNumber, balance);
        this.interest = interest;
    }

    public SavingsAccount(int accountNumber, int interest) {
        this(accountNumber, 0, interest);
    }

    public int getInterest() {
        return interest;
    }
    
}
