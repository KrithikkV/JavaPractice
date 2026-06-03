package aggreg;

public class ThrowExample {
    
    // Method that validates age and throws an exception manually
    static void checkEligibility(int age) {
        if (age < 18) {
            // "throw" creates a new instance of an exception
            throw new ArithmeticException("To vote - You must be at least 18 years old.");
        } else {
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {
        try {
            // Calling the method with an invalid value
            checkEligibility(11); 
        } 
        catch (ArithmeticException e) {
            // Catching the exception we threw above
            System.out.println("Caught an Exception: " + e.getMessage());
        }

        System.out.println("The program continues to run...");
    }
}