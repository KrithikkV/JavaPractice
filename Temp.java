
public class Temp {

    // Generic method to add two numbers
    // <T extends Number> ensures we only pass numeric types
    public static <T extends Number> double add(T num1, T num2) {
        // Convert both to double to perform the math
        return num1.doubleValue() + num2.doubleValue();
    }

    public static void main(String[] args) {
        // 1. Adding Integers
        int a = 10;
        int b = 20;
        System.out.println("Integer Addition: " + add(a, b));

        // 2. Adding Doubles
        double c = 15.5;
        double d = 4.5;
        System.out.println("Double Addition: " + add(c, d));

        // 3. Adding a Float and a Long
        float e = 10.2f;
        long f = 100L;
        System.out.println("Mixed Type Addition: " + add(e, f));
    }
}