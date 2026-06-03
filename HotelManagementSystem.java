
import java.io.*;
import java.util.Scanner;

interface Calc {
    public double discount() throws Exception;
}

abstract class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String name;
    protected int id;
    protected int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Customer ID: " + id);
        System.out.println("Customer Name: " + name);
    }
}

class Customer extends Person {
    private static final long serialVersionUID = 1L;
    protected String city;

    public Customer(int id, String name, int age, String city) {
        super(id, name, age);
        this.city = city;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Customer City: " + city);
    }
}

class FavCustomer extends Customer implements Calc {
    private static final long serialVersionUID = 1L;
    private int visits;
    private int price;

    public FavCustomer(int id, String name, int age, String city, int price, int visits) {
        super(id, name, age, city);
        this.price = price;
        this.visits = visits;
    }

    @Override
    public double discount() throws Exception {
        if (price <= 0) {
            throw new Exception("Invalid price amount.");
        } else if (visits > 5) {
            return price - (price * 0.1); // 10% discount
        } else {
            return price;
        }
    }

    @Override
    public void display() {
        super.display();
        try {
            System.out.println("Final Price (after discount if applicable): " + discount());
        } catch (Exception e) {
            System.out.println("Error calculating discount: " + e.getMessage());
        }
    }
}

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        File data = new File("customers.dat");
        int choice = 0;

        do {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("1) Enter details");
            System.out.println("2) Display details");
            System.out.println("3) Exit");
            System.out.print("Enter your choice: ");
            
            try {
                choice = input.nextInt();
                input.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.println("Enter the number of customers:");
                        int size = input.nextInt();
                        input.nextLine();
                        
                        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(data))) {
                            for (int i = 0; i < size; i++) {
                                System.out.println("\nRecording details for Customer " + (i + 1));
                                System.out.print("Enter ID: ");
                                int id = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter Name: ");
                                String name = input.nextLine();
                                System.out.print("Enter Age: ");
                                int age = input.nextInt();
                                input.nextLine();
                                System.out.print("Enter City: ");
                                String city = input.nextLine();
                                System.out.print("Enter Price: ");
                                int price = input.nextInt();
                                System.out.print("Enter Visits: ");
                                int visits = input.nextInt();
                                input.nextLine();

                                FavCustomer f = new FavCustomer(id, name, age, city, price, visits);
                                oos.writeObject(f);
                            }
                            System.out.println("Data saved successfully.");
                        } catch (IOException e) {
                            System.out.println("Error saving data: " + e.getMessage());
                        }
                        break;

                    case 2:
                        if (!data.exists()) {
                            System.out.println("No records found.");
                            break;
                        }
                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(data))) {
                            while (true) {
                                FavCustomer c = (FavCustomer) ois.readObject();
                                c.display();
                                System.out.println("--------------------");
                            }
                        } catch (EOFException e) {
                            System.out.println("All records displayed.");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Error reading data: " + e.getMessage());
                        }
                        break;

                    case 3:
                        System.out.println("Exiting... Varata mamae durrr!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
                input.nextLine(); // Clear scanner buffer
            }
        } while (choice != 3);
        
        input.close();
    }
}