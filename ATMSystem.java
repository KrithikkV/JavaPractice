//Implement an ATM system Functions and static data
import java.util.Scanner;

public class ATMSystem {
    // Global variable to maintain state
    static double balance = 1000.00; 
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("Welcome to the Java Bank ATM");

        do {
            displayMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
    }

    // --- Functional Methods ---
    //Display

    public static void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Select an option: ");
    }
  //Checking balance
    public static void checkBalance() {
        System.out.printf("Your current balance is: $%.2f\n", balance);
    }
  //Deposit 
    public static void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }
	//Withdraw
    public static void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();
        
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds! Transaction cancelled.");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash: $" + amount);
        }
    }
}