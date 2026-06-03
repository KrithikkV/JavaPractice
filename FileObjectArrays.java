import java.io.*;

// The class structure
class Employee1  implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    Employee1(){
    	this.id=0;
    	this.name
    }
    // Constructor that matches your previous error's needs
    Employee1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to show the data
    public void display() {
        System.out.println("ID: " + id + " | Name: " + name);
    }
}

public class FileObjectArrays {
    // 'throws Exception' is the secret to removing try-catch blocks
    public static void main(String[] args) throws Exception {
        String filename = "employee_records.dat";

        // 1. Create a standard Array (Fixed size)
        Employee1[] staff = new Employee1[2];
        staff[0] = new Employee1(101, "Arjun");
        staff[1] = new Employee1(102, "Sneha");

        // 2. WRITE the whole array to the file
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        oos.writeObject(staff); // Saves the entire array at once
        oos.close();
        System.out.println("Step 1: Array saved to file.");

        // 3. READ the whole array from the file
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        // Read and cast back to the Employee array type []
        Employee1[] loadedStaff = (Employee1[]) ois.readObject();
        ois.close();

        // 4. Print the results
        System.out.println("Step 2: Data loaded from file:");
        for (int i = 0; i < loadedStaff.length; i++) {
            loadedStaff[i].display();
        }
    }
}
/*import java.io.*;

//1. Employee class MUST be outside FileObjectArrays
class Employee1 implements Serializable {
 private static final long serialVersionUID = 1L;
 int id;
 String name;

 // The Constructor (The compiler is looking for this)
 Employee1(int id, String name) {
     this.id = id;
     this.name = name;
 }

 // The Method (The compiler is looking for this)
 public void display() {
     System.out.println("ID: " + id + " | Name: " + name);
 }
}

public class FileObjectArrays {
 public static void main(String[] args) {
     String filename = "data.txt";
     
     // Create the array
     Employee1[] staff = new Employee1[2];
     staff[0] = new Employee1(101, "Arjun");
     staff[1] = new Employee1(102, "Sneha");

     // WRITING SECTION
     ObjectOutputStream oos = null;
     try {
         oos = new ObjectOutputStream(new FileOutputStream(filename));
         oos.writeObject(staff);
         System.out.println("Objects saved successfully.");
     } catch (IOException e) {
         System.out.println("Error while writing: " + e.getMessage());
     } finally {
         try {
             if (oos != null) oos.close();
         } catch (IOException e) {}
     }

     // READING SECTION
     ObjectInputStream ois = null;
     try {
         ois = new ObjectInputStream(new FileInputStream(filename));
         
         // Cast back to Employee array
         Employee1[] result = (Employee1[]) ois.readObject();
         
         System.out.println("Loading data...");
         for (int i = 0; i < result.length; i++) {
             result[i].display(); // Now the compiler sees this method
         }
     } catch (IOException | ClassNotFoundException e) {
         System.out.println("Error while reading: " + e.getMessage());
     } finally {
         try {
             if (ois != null) ois.close();
         } catch (IOException e) {}
     }
 }
}*/

