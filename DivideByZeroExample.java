package aggreg;

public class DivideByZeroExample {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        try {
            // This line will throw an ArithmeticException
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } 
        catch (ArithmeticException e) {
            // This block executes if a division by zero occurs
            System.out.println("Error: Cannot divide by zero!");
            System.out.println("Exception Message: " + e.getMessage());
        } 
        finally {
            // This block always executes, regardless of an exception
            System.out.println("Execution completed.");
        }
    }
}
