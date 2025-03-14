// ✅ Parent Class (Super Class)
class Employee {
    protected String name;
    protected double salary;

    // ✅ Constructor
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // ✅ Method to Display Employee Info
    void displayInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: $" + salary);
    }
}

// ✅ Child Class (Inheriting from Employee)
class Manager extends Employee {
    private int teamSize;

    // ✅ Constructor (Uses Parent Constructor)
    Manager(String name, double salary, int teamSize) {
        super(name, salary); // ✅ Calls Employee Constructor
        this.teamSize = teamSize;
    }

    // ✅ Method to Display Manager Info
    @Override
    void displayInfo() {
        super.displayInfo(); // ✅ Calls Parent Method
        System.out.println("Team Size: " + teamSize);
    }
}

// ✅ Main Class
public class Inheritance3 {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 50000);
        Manager mgr = new Manager("Bob", 80000, 5);

        System.out.println("\n🔹 Employee Details:");
        emp.displayInfo();

        System.out.println("\n🔹 Manager Details:");
        mgr.displayInfo();
    }
}



