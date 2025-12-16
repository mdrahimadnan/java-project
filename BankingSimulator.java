import java.util.Scanner;

public class BankingSimulator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();   // Service Layer Object

        while (true) {

            System.out.println("\n===== SMART BANKING SIMULATOR =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Calculate Loan / EMI");
            System.out.println("6. View Account Statement");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    service.createAccount(name, bal);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int accDep = sc.nextInt();
                    System.out.print("Enter Amount to Deposit: ");
                    double amtDep = sc.nextDouble();
                    service.deposit(accDep, amtDep);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int accW = sc.nextInt();
                    System.out.print("Enter Amount to Withdraw: ");
                    double amtW = sc.nextDouble();
                    service.withdraw(accW, amtW);
                    break;

                case 4:
                    System.out.print("Enter Sender Account Number: ");
                    int accFrom = sc.nextInt();
                    System.out.print("Enter Receiver Account Number: ");
                    int accTo = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double amtT = sc.nextDouble();
                    service.transfer(accFrom, accTo, amtT);
                    break;

                case 5:
                    System.out.print("Enter Principal: ");
                    double p = sc.nextDouble();
                    System.out.print("Enter Rate: ");
                    double r = sc.nextDouble();
                    System.out.print("Enter Time (years): ");
                    double t = sc.nextDouble();
                    service.calculateLoanEMI(p, r, t);
                    break;

                case 6:
                    System.out.print("Enter Account Number: ");
                    int accS = sc.nextInt();
                    service.viewStatement(accS);
                    break;

                case 7:
                    System.out.println("Thank you for using Smart Banking Simulator!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }
    }
}
