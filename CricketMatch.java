package d4;

import java.util.Scanner;

class Cricketer {
    private String name;
    private int age;
    private String country;

    // Method to set details
    public void getDetails(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Country : " + country);
    }
}

public class CricketMatch
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cricketer cricketer = new Cricketer();

        int choice;
        do {
            System.out.println("\n===== Cricket Manager Menu =====");
            System.out.println("1. Enter Cricketer Details");
            System.out.println("2. Display Cricketer Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Country: ");
                    String country = sc.nextLine();

                    cricketer.getDetails(name, age, country);
                    System.out.println("Cricketer details saved successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Cricketer Details ---");
                    cricketer.displayDetails();
                    break;

                case 3:
                    System.out.println("Exiting Cricket Manager. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println("-------------");
        } while (choice != 3);

        sc.close();
    }
}

