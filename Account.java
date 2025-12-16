import java.io.Serializable;
public abstract class Account implements Serializable {


    protected int accountNumber;
    protected String holderName;
    protected double balance;

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount <= 0) {
            throw new NegativeAmountException("Amount cannot be negative or zero!");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new NegativeAmountException("Amount cannot be negative or zero!");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient Balance!");
        }
        balance -= amount;
    }

    // For interest, EMI, month-end processes in children
    public abstract void monthEndProcess();
}
