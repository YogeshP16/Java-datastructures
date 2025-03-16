import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String role;
    private String department;
    private double salary;
    private String city;
    private int age;
    private String gender;

    public Employee(int id, String name, String role, String department, double salary, String city, int age, String gender) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.department = department;
        this.salary = salary;
        this.city = city;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() { return age; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}

public class EmployeeProblems {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "Developer", "IT", 75000, "New York", 20, "female"),
            new Employee(2, "Bob", "Manager", "HR", 85000, "San Francisco", 45, "male"),
            new Employee(3, "Charlie", "Analyst", "Finance", 65000, "Chicago", 25, "male"),
            new Employee(4, "David", "Engineer", "IT", 80000, "Seattle", 30, "male"),
            new Employee(5, "Emma", "Consultant", "Marketing", 70000, "Boston", 30, "female"),
            new Employee(6, "Zen", "Consultant II", "Marketing", 80000, "Boston", 45, "male"),
            new Employee(7, "Zoya", "Developer", "IT", 70000, "Boston", 45, "female")
        );

        // Get the highest salary employee (1st highest)
        Optional<Employee> highest = employees.stream()
            .max(Comparator.comparing(Employee::getSalary));
        highest.ifPresent(emp -> System.out.println("Highest Salary Employee: " + emp));

        // Get the second highest salary employee (2nd highest)
        Optional<Employee> secondHighest = employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .skip(1)
            .findFirst();
        secondHighest.ifPresent(emp -> System.out.println("Second Highest Salary Employee: " + emp));

        // Find lowest salary employee
        Optional<Employee> lowest = employees.stream()
            .min(Comparator.comparing(Employee::getSalary));
        lowest.ifPresent(emp -> System.out.println("Lowest Salary Employee: " + emp));

        // Find second lowest salary employee
        Optional<Employee> secondLowest = employees.stream()
            .sorted(Comparator.comparing(Employee::getSalary))
            .skip(1)
            .findFirst();
        secondLowest.ifPresent(emp -> System.out.println("Second Lowest Salary Employee: " + emp));

        // Group employee by age and return total sum of salaries
        Map<Integer, Double> salaryByAge = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getAge,
                Collectors.summingDouble(Employee::getSalary)));

        salaryByAge.forEach((age, totalSalary) -> 
            System.out.println("Age: " + age + ", Total Salary: " + totalSalary));

    }
}
