public class CurrentAccount extends Account {

    private double overdraftLimit = 5000; // Allow up to 5000 overdraft

    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void withdraw(double amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new NegativeAmountException("Amount cannot be negative or zero!");
        }

        if (amount > balance + overdraftLimit) {
            throw new InsufficientFundsException("Overdraft Limit Exceeded!");
        }

        balance -= amount; // can go negative
    }

    @Override
    public void monthEndProcess() {
        // No interest, no special rules
    }
}
