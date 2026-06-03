package aggreg;

public class Employee {
    private String name;
    private MyDate dob;
    private MyDate doj;

    public Employee(String name, MyDate dob, MyDate doj) {
        this.name = name;
        this.dob = dob;
        this.doj = doj;
    }

    public void display() {
        System.out.println("Employee: " + name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Date of Joining: " + doj);
    }

    public static void main(String[] args) {
        // Create MyDate objects
        MyDate birthday = new MyDate(15, 5, 1995);
        MyDate joiningDate = new MyDate(1, 10, 2022);

        // Create Employee object
        Employee emp = new Employee("Sarah Connor", birthday, joiningDate);
        
        emp.display();
    }
}
