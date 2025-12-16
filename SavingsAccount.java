public class SavingsAccount extends Account {

    private double interestRate = 0.03; // 3% interest

    public SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void monthEndProcess() {
        double interest = balance * interestRate;
        balance += interest;
    }

    @Override
    public void withdraw(double amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new NegativeAmountException("Amount cannot be negative or zero!");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Savings Account: Not enough balance!");
        }
        balance -= amount;
    }
}
