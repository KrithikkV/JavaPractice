package aggreg;

public class ArrayExceptionExample {
    public static void main(String[] args) {
        // An array with 3 elements (indexes 0, 1, and 2)
        int[] scores = {85, 92, 78};

        try {
            // Attempting to access index 3 (which doesn't exist)
            System.out.println("The fourth score is: " + scores[3]);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: That index is out of range!");
            System.out.println("Actual array length: " + scores.length);
        }
    }
}
