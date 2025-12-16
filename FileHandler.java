import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class FileHandler {

    private static final String ACCOUNT_FILE = "accounts.dat";
    private static final String STATEMENT_FILE = "statements.txt";

    // Save all accounts to file
    public static void saveAccounts(Map<Integer, Account> accounts) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ACCOUNT_FILE))) {
            out.writeObject(accounts);
        } catch (Exception e) {
            System.out.println("❌ Error saving accounts: " + e.getMessage());
        }
    }

    // Load accounts from file
    public static Map<Integer, Account> loadAccounts() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ACCOUNT_FILE))) {
            return (Map<Integer, Account>) in.readObject();
        } catch (Exception e) {
            return new HashMap<>(); // Return empty map if file missing or error occurs
        }
    }

    // Write a transaction line to statements.txt
    public static void writeStatement(String message) {
        try (FileWriter fw = new FileWriter(STATEMENT_FILE, true)) {
            fw.write(message + "\n");
        } catch (Exception e) {
            System.out.println("❌ Error writing statement: " + e.getMessage());
        }
    }
}
