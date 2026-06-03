
import java.io.*;
import java.util.Scanner;

// 1. INTERFACE: The Emergency Protocol
interface AlertSystem {
    void triggerEmergency(String condition);
}

// 2. ABSTRACT CLASS: Base for all Seniors
abstract class Resident implements Serializable {
    private static final long serialVersionUID = 1L;
    protected int id;
    protected String name;
    protected int age;

    public Resident(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public abstract void checkVitalStatus();
}

// 3. SPECIALIZED CLASS: Implements Inheritance and Interface
class CriticalCareResident extends Resident implements AlertSystem {
    private double heartRate;
    private String primaryCondition;

    public CriticalCareResident(int id, String name, int age, double heartRate, String condition) {
        super(id, name, age);
        this.heartRate = heartRate;
        this.primaryCondition = condition;
    }

    @Override
    public void triggerEmergency(String condition) {
        System.out.println("!!! EMERGENCY ALERT for " + name + " !!!");
        System.out.println("Condition: " + condition + " detected. Contacting Hospital...");
    }

    @Override
    public void checkVitalStatus() {
        System.out.println("Monitoring Resident: " + name + " (Condition: " + primaryCondition + ")");
        if (heartRate > 100 || heartRate < 50) {
            triggerEmergency("Abnormal Heart Rate: " + heartRate + " bpm");
        } else {
            System.out.println("Vitals are stable.");
        }
    }
}

public class ElderlyCare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = "elderly_records.dat";

        System.out.print("Enter number of residents to register: ");
        int n = sc.nextInt();
        Resident[] residents = new Resident[n]; 

        // WRITING DATA Section
        // Use try-with-resources for ObjectOutputStream to ensure it closes
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (int i = 0; i < n; i++) {
                System.out.println("\nRegistering Resident #" + (i + 1));
                System.out.print("ID: "); int id = sc.nextInt();
                sc.nextLine(); // Buffer clear
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Age: "); int age = sc.nextInt();
                System.out.print("Current Heart Rate: "); double hr = sc.nextDouble();
                sc.nextLine();
                System.out.print("Medical Condition: "); String condition = sc.nextLine();

                if (age < 0) throw new Exception("Invalid Age provided.");

                residents[i] = new CriticalCareResident(id, name, age, hr, condition);
                oos.writeObject(residents[i]);
            }
        } catch (Exception e) {
            System.out.println("Error during registration: " + e.getMessage());
        }

        // READING DATA Section
        System.out.println("\n--- DAILY VITAL SIGN LOG ---");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            for (int i = 0; i < n; i++) {
                Resident r = (Resident) ois.readObject();
                r.checkVitalStatus();
                System.out.println("----------------------------");
            }
        } catch (EOFException e) {
            System.out.println("End of monitoring logs.");
        } catch (Exception e) {
            System.out.println("Error reading logs: " + e.getMessage());
        }

        sc.close();
    } // End of main
} // End of class