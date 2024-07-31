import java.util.Scanner;

public class CTUBankingApplication {

    private static double balance = 0.0;
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            
            while (!exit) {
                System.out.println("CTU Banking Application");
                System.out.println("1. Display Account Details");
                System.out.println("2. Deposit Amount");
                System.out.println("3. Save Amount");
                System.out.println("4. Withdraw Amount");
                System.out.println("5. Exit");
                System.out.print("Select an option: ");
                
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1 -> displayAccountDetails();
                    case 2 -> {
                        System.out.print("Enter the deposit amount: R");
                        double depositAmount = scanner.nextDouble();
                        deposit(depositAmount);
                    }
                    case 3 -> {
                        System.out.print("Enter the savings amount: R");
                        double savingsAmount = scanner.nextDouble();
                        save(savingsAmount);
                    }
                    case 4 -> {
                        System.out.print("Enter the withdrawal amount: R");
                        double withdrawalAmount = scanner.nextDouble();
                        withdraw(withdrawalAmount);
                    }
                    case 5 -> {
                        exit = true;
                        System.out.println("Exiting the application. Thank you!");
                    }
                    default -> System.out.println("Invalid choice. Please select a valid option.");
                }
                
                System.out.println();
            }
        }
    }
    
    private static void displayAccountDetails() {
        System.out.println("Account Details:");
        System.out.println("Current Balance: R" + balance);
        System.out.println();
    }
    
    private static void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of R" + amount + " successful.");
        System.out.println();
    }
    
    private static void save(double amount) {
        // Implement interest rate calculation based on amount and duration
        double interestRate = 0.0;
        if (amount >= 100 && amount <= 500) {
            interestRate = 0.005;
        } else if (amount > 500 && amount <= 1000) {
            interestRate = 0.02;
        } else if (amount > 1000) {
            interestRate = 0.05;
        }
        
        double interestEarned = amount * interestRate;
        balance += amount + interestEarned;
        
        System.out.println("Savings of R" + amount + " successful.");
        System.out.println("Interest earned: R" + interestEarned);
        System.out.println();
    }
    
    private static void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of R" + amount + " successful.");
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
        System.out.println();
    }
}
