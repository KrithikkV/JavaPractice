package aggreg;

public class MyDate {
    private int day;
    private int month;
    private int year;

    // Constructor
    public MyDate(int day, int month, int year) {
        this.year = year;
        
        // Simple validation for Month
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            this.month = 1; // Default fallback
            System.out.println("Invalid month. Set to 1.");
        }

        // Simple validation for Day (Max 31)
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            this.day = 1; // Default fallback
            System.out.println("Invalid day. Set to 1.");
        }
    }

    // A helper method to return a formatted string
    public String getFormattedDate() {
        return String.format("%02d/%02d/%d", day, month, year);
    }

    @Override
    public String toString() {
        return getFormattedDate();
    }
}