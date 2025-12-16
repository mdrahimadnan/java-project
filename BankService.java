import java.util.HashMap;
import java.util.Map;

public class BankService {

    private Map<Integer, Account> accounts;
    private int accountCounter = 1001;

    public BankService() {
        accounts = FileHandler.loadAccounts();  // Load saved data
    }

    // CREATE ACCOUNT
    public void createAccount(String name, double balance) {
        int accNo = accountCounter++;

        Account acc = new SavingsAccount(accNo, name, balance);
        accounts.put(accNo, acc);

        FileHandler.saveAccounts(accounts);
        FileHandler.writeStatement("Created Account " + accNo + " | Holder: " + name + " | Balance: " + balance);

        System.out.println("\n===== ACCOUNT CREATED =====");
        System.out.println("Account Number : " + accNo);
        System.out.println("Holder Name    : " + name);
        System.out.println("Balance        : " + balance);
        System.out.println("===========================\n");
    }

    // DEPOSIT
    public void deposit(int accNo, double amount) {
        Account acc = accounts.get(accNo);

        if (acc == null) {
            System.out.println("❌ Account Not Found!");
            return;
        }

        try {
            acc.deposit(amount);

            FileHandler.saveAccounts(accounts);
            FileHandler.writeStatement("Deposit " + amount + " into " + accNo);

            System.out.println("✅ Deposit Successful! New Balance: " + acc.getBalance());

        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    // WITHDRAW
    public void withdraw(int accNo, double amount) {
        Account acc = accounts.get(accNo);

        if (acc == null) {
            System.out.println("❌ Account Not Found!");
            return;
        }

        try {
            acc.withdraw(amount);

            FileHandler.saveAccounts(accounts);
            FileHandler.writeStatement("Withdraw " + amount + " from " + accNo);

            System.out.println("✅ Withdrawal Successful! New Balance: " + acc.getBalance());

        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    // TRANSFER
    public void transfer(int from, int to, double amount) {
        Account accFrom = accounts.get(from);
        Account accTo = accounts.get(to);

        if (accFrom == null || accTo == null) {
            System.out.println("❌ One or both accounts do not exist!");
            return;
        }

        try {
            accFrom.withdraw(amount);
            accTo.deposit(amount);

            FileHandler.saveAccounts(accounts);
            FileHandler.writeStatement("Transfer " + amount + " from " + from + " to " + to);

            System.out.println("\n===== TRANSFER SUCCESSFUL =====");
            System.out.println("Amount : " + amount);
            System.out.println("From   : " + from);
            System.out.println("To     : " + to);
            System.out.println("================================\n");

        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    // EMI
    public void calculateLoanEMI(double p, double r, double t) {
        LoanAccount loan = new LoanAccount(9999, "Loan Holder", p, r, t);

        double emi = loan.calculateEMI();

        FileHandler.writeStatement("EMI Calculated for Loan: " + emi);

        System.out.println("\n===== EMI DETAILS =====");
        System.out.println("Principal : " + p);
        System.out.println("Rate      : " + r);
        System.out.println("Time      : " + t);
        System.out.println("EMI       : " + emi);
        System.out.println("========================\n");
    }

    // STATEMENT
    public void viewStatement(int accNo) {
        Account acc = accounts.get(accNo);

        if (acc == null) {
            System.out.println("❌ Account Not Found!");
            return;
        }

        System.out.println("\n===== ACCOUNT STATEMENT =====");
        System.out.println("Account Number : " + acc.getAccountNumber());
        System.out.println("Holder Name    : " + acc.getHolderName());
        System.out.println("Balance        : " + acc.getBalance());
        System.out.println("=============================\n");
    }
}
