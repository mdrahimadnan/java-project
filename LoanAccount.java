public class LoanAccount extends Account {

    private double principal;
    private double rate; // annual interest rate
    private double tenure; // in years
    private double outstanding;

    public LoanAccount(int accountNumber, String holderName, double principal, double rate, double tenure) {
        super(accountNumber, holderName, 0);
        this.principal = principal;
        this.rate = rate;
        this.tenure = tenure;
        this.outstanding = principal;
    }

    public double calculateEMI() {
        double monthlyRate = rate / (12 * 100);
        double months = tenure * 12;

        return (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                (Math.pow(1 + monthlyRate, months) - 1);
    }

    @Override
    public void monthEndProcess() {
        double emi = calculateEMI();
        outstanding -= emi;

        if (outstanding < 0)
            outstanding = 0;
    }

    public double getOutstanding() {
        return outstanding;
    }
}
