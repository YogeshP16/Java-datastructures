import java.util.ArrayList;
// import java.util.Comparator;
 import java.util.List;
// import java.util.Map;
// import java.util.Optional;
// import java.util.stream.Collectors;

public class O10_EmployeeExamples {
    public static void main(String[] args) {

    List<Employee> employees = new ArrayList<>();

    // Adding Employee objects with all details
     employees.add(new Employee(1, "John Doe", "Male", 30, "IT", 70000));
     employees.add(new Employee(2, "Jane Smith", "Female", 28, "HR", 65000));
     employees.add(new Employee(3, "Alice Brown", "Female", 35, "Finance", 80000));
     employees.add(new Employee(4, "Bob White", "Male", 40, "Marketing", 75000));
     employees.add(new Employee(5, "Charlie Green", "Male", 25, "Sales", 50000));
     employees.add(new Employee(5, "Zen", "Male", 25, "IT", 50000));

    // Find salary > 70000
    //=======================
    //  List<Employee> findSalary = employees.stream()
    //                              .filter(e -> e.getSalary() > 70000)
    //                              .collect(Collectors.toList());
    //  findSalary.forEach(System.out::println);

    //output
    // Employee [id=3, name=Alice Brown, sex=Female, age=35, dept=Finance, salary=80000]
    // Employee [id=4, name=Bob White, sex=Male, age=40, dept=Marketing, salary=75000]
//=============================================================================================================

    // Find Max salary employee
    //==============================
    // Optional<Employee> maxsalary = employees.stream()
    //                                .max(Comparator
    //                                .comparing(Employee::getSalary));
    // System.out.println(maxsalary);
    //output ->  Optional[Employee [id=3, name=Alice Brown, sex=Female, age=35, dept=Finance, salary=80000]]
    
//===============================================================================================================

    // Count Employees by dept
    //===========================
    //  Map<String, Long> empCountByDept = employees.stream()
    //      .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));

    //  empCountByDept.forEach((dept, count) -> System.out.println(dept + " -> " + count));

    /* output
    Sales -> 1
    Finance -> 1
    HR -> 1
    IT -> 2
    Marketing -> 1
    */
    
//=============================================================================================================
        // Employees by dept (Distinct)

        employees.stream().map(Employee::getDept).distinct().forEach(System.out::println);
        /*
            IT
            HR
            Finance
            Marketing
            Sales
         */
    }

}

class Employee{
    private int id;
    private String name;
    private String sex;
    private int age;
    private String dept;
    private long salary;

    
   


    public Employee(int id, String name, String sex, int age, String dept, long salary) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.dept = dept;
        this.salary = salary;
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", dept=" + dept
                + ", salary=" + salary + "]";
    }
}
    
