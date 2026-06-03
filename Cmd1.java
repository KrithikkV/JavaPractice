
public class Cmd1 {
    public static void main(String[] args) {
        // args is a standard fixed-size String array
        if (args.length == 0) {
            System.out.println("No arguments provided.");
            System.out.println("Usage: java CommandLineDemo <num1> <num2> ...");
            return;
        }

        System.out.println("Total arguments received: " + args.length);
        
        double sum = 0;
        int validCount = 0;

        // Iterate through the fixed-size array
        for (int i = 0; i < args.length; i++) {
            try {
                // Convert String argument to a numeric type (double)
                double val = Double.parseDouble(args[i]);
                sum += val;
                validCount++;
                System.out.println("Argument[" + i + "]: " + val);
            } catch (NumberFormatException e) {
                // Handle cases where input is not a number
                System.out.println("Argument[" + i + "]: '" + args[i] + "' is not a valid number.");
            }
        }

        System.out.println("----------------------------");
        System.out.println("Processed " + validCount + " numeric values.");
        System.out.println("Calculated Sum: " + sum);
    }
}