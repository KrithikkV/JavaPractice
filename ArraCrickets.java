//Store and display details of Cricketer in the team
import java.util.Scanner;
//Cricketer class

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
        System.out.println("-------------------------");
    }
}
//driver class
public class CricketTeam {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum number of cricketers: ");
        int size = sc.nextInt();
        sc.nextLine(); // consume newline
        //Array of objects
        Cricketer[] cricketers = new Cricketer[size];
        int count = 0;

        int choice;
        do {
            System.out.println("\n===== Cricket Manager Menu =====");
            System.out.println("1. Add Cricketer");
            System.out.println("2. Display All Cricketers");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    if (count >= size) {
                        System.out.println("Cricketer list is full!");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter Country: ");
                    String country = sc.nextLine();
                    //Allocate for an object in the array
                    cricketers[count] = new Cricketer();
                    cricketers[count].getDetails(name, age, country);
                    count++;

                    System.out.println("Cricketer added successfully!");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No cricketers to display.");
                    } else {
                        System.out.println("\n--- Cricketer List ---");
                        for (int i = 0; i < count; i++) {
                            cricketers[i].displayDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting Cricket Manager. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}
