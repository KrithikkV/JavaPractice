package aggreg;

public class RuntimeExceptionExample {
    public static void main(String[] args) {
        String name = null; // The variable exists, but it points to nothing

        try {
            // Attempting to get the length of a 'null' string
            System.out.println("Length of name: " + name.length());
        } 
        catch (NullPointerException e) {
            System.out.println("Error: You tried to perform an action on a null object!");
        }
    }
}
