package demo2draw.model;

public class NormalAccount extends BankAccount {
    private int overdraftLimit;

    public NormalAccount(int accountNumber, int balance, int overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public NormalAccount(int accountNumber, int overdraftLimit) {
        this(accountNumber, 0, overdraftLimit);
    }

    public int getOverdraftLimit() {
        return overdraftLimit;
    }

}
