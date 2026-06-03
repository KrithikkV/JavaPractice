//Mobile Store -Inheritance
import java.util.Scanner;

// 1. Interface
interface DisplayType {
    String getTech(); 
}

// 2. Parent Class
class Device {
    protected int deviceId;
    protected String deviceName;
    protected int memory;

    public Device(int deviceId, String deviceName, int memory) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.memory = memory;
    }

    // Method to check ID without using a getter
    public boolean matchesId(int searchId) {
        return this.deviceId == searchId;
    }

    public void display() {
        System.out.printf("%-10d %-15s %-10d ", deviceId, deviceName, memory);
    }
}

// 3. Derived Class
class Mobile extends Device implements DisplayType {
    private int storage;
    private String model;

    public Mobile(int deviceId, String deviceName, int memory, int storage, String model) {
        super(deviceId, deviceName, memory);
        this.storage = storage;
        this.model = model;
    }

    @Override
    public String getTech() {
        return "AMOLED";
    }

    @Override
    public void display() {
        super.display(); 
        System.out.printf("%-15s %-10d %-15s\n", model, storage, getTech());
    }
}

// 4. Main Class
public class MobileStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mobile[] mobiles = new Mobile[10]; 
        int count = 0;
        boolean keepAdding = true;

        // Input Phase
        while (keepAdding && count < mobiles.length) {
            System.out.println("\n--- Enter Mobile Details (Entry " + (count + 1) + ") ---");
            System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
            System.out.print("Brand: "); String brand = sc.nextLine();
            System.out.print("Model: "); String model = sc.nextLine();
            System.out.print("RAM: "); int ram = sc.nextInt();
            System.out.print("Storage: "); int storage = sc.nextInt(); sc.nextLine();

            mobiles[count++] = new Mobile(id, brand, ram, storage, model);

            System.out.print("Add another? (y/n): ");
            if (sc.nextLine().equalsIgnoreCase("n")) keepAdding = false;
        }

        // Display All Phase
        System.out.println("\n--- All Registered Mobiles ---");
        printTable(mobiles, count);

        // Search Routine Phase
        boolean searchMode = true;
        while (searchMode) {
            System.out.print("\nEnter Device ID to search (or 0 to exit): ");
            int searchId = sc.nextInt();
            sc.nextLine(); 

            if (searchId == 0) {
                searchMode = false;
                System.out.println("Exiting search...");
                break;
            }

            boolean found = false;
            for (int i = 0; i < count; i++) {
                // Using the matcher method instead of a getter
                if (mobiles[i].matchesId(searchId)) {
                    System.out.println("\nDevice Found!");
                    System.out.printf("%-10s %-15s %-10s %-15s %-10s %-15s\n", 
                                      "ID", "Brand", "RAM", "Model", "Storage", "Display");
                    System.out.println("-".repeat(80));
                    mobiles[i].display();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Error: Device with ID " + searchId + " not found.");
            }
        }
        sc.close();
    }

    // Helper method to print the full list as a table
    public static void printTable(Mobile[] mobiles, int count) {
        System.out.println("=".repeat(80));
        System.out.printf("%-10s %-15s %-10s %-15s %-10s %-15s\n", 
                          "ID", "Brand", "RAM", "Model", "Storage", "Display");
        System.out.println("-".repeat(80));
        for (int i = 0; i < count; i++) {
            mobiles[i].display();
        }
        System.out.println("=".repeat(80));
    }
}