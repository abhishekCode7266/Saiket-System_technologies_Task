import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {

    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();

        transactionHistory.add(
            "Account opened with balance: " + initialBalance
        );
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be positive."
            );
        }

        balance += amount;
        transactionHistory.add("Deposited: " + amount);
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be positive."
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Insufficient balance."
            );
        }

        balance -= amount;
        transactionHistory.add("Withdrew: " + amount);
    }

    public void showHistory() {

        System.out.println(
            "\nTransaction History for " + accountHolder + ":"
        );

        for (String entry : transactionHistory) {
            System.out.println("- " + entry);
        }
    }
}

class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(
        String accountHolder,
        double initialBalance,
        double interestRate
    ) {
        super(accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {

        double interest = getBalance() * interestRate / 100;

        deposit(interest);

        System.out.println(
            "Interest applied: " + interest
        );
    }
}

public class Basicbankingsystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter initial balance: ");
        double initial = readDouble(sc);

        System.out.print(
            "Enter interest rate (%) for this savings account: "
        );

        double rate = readDouble(sc);

        SavingsAccount account =
            new SavingsAccount(name, initial, rate);

        boolean running = true;

        while (running) {

            System.out.println("\n===== Banking Menu =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Apply Interest");
            System.out.println("5. Show Transaction History");
            System.out.println("6. Exit");

            System.out.print("Choose an option: ");

            int choice;

            try {

                choice =
                    Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {

                System.out.println(
                    "Please enter a valid number."
                );

                continue;
            }

            try {

                switch (choice) {

                    case 1:

                        System.out.print(
                            "Enter amount to deposit: "
                        );

                        account.deposit(readDouble(sc));

                        System.out.println(
                            "Deposit successful."
                        );

                        break;

                    case 2:

                        System.out.print(
                            "Enter amount to withdraw: "
                        );

                        account.withdraw(readDouble(sc));

                        System.out.println(
                            "Withdrawal successful."
                        );

                        break;

                    case 3:

                        System.out.println(
                            "Current balance: "
                            + account.getBalance()
                        );

                        break;

                    case 4:

                        account.applyInterest();

                        break;

                    case 5:

                        account.showHistory();

                        break;

                    case 6:

                        running = false;

                        System.out.println(
                            "Thank you for banking with us!"
                        );

                        break;

                    default:

                        System.out.println(
                            "Invalid option, try again."
                        );
                }

            } catch (IllegalArgumentException e) {

                System.out.println(
                    "Error: " + e.getMessage()
                );
            }
        }

        sc.close();
    }

    private static double readDouble(Scanner sc) {

        while (true) {

            try {

                return Double.parseDouble(
                    sc.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.print(
                    "Invalid number, try again: "
                );
            }
        }
    }
}