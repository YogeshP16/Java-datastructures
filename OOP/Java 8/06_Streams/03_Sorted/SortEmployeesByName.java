import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployeesByName {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(0, "Yogesh", "SDE", 30000));
        employees.add(new Employee(1, "Vignesh", "Manager", 50000));
        employees.add(new Employee(2, "Balaji", "Support", 20000));
        employees.add(new Employee(3, "Nithish", "HR", 30000));
        employees.add(new Employee(4, "Subash", "SDE", 40000));
        employees.add(new Employee(5, "Jeeva", "SDE", 40000));

        // Sort employees by name ASCENDING using lambda

        List<Employee> sortNames = employees.stream().sorted((o1, o2)-> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
        System.out.println(sortNames);
        
        // using method ref
        List<Employee> sortNames2 = employees.stream()
                                    .sorted(Comparator.comparing(Employee::getName)) // Sort by name in ascending order
                                    .collect(Collectors.toList());

        System.out.println(sortNames2);


        // sort descending
        List<Employee> sorList = employees.stream()
                                .sorted(Comparator.comparing(Employee::getName).reversed())
                                .collect(Collectors.toList());
        System.out.println(sorList);

         
       
    }
}

class Employee {
    int id;
    String name;
    String dept;
    int salary;

    public Employee(int id, String name, String dept, int salary) {
        this.id = id;
        this.name = name;
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

   
}


/*
### Ascending
[Employee [id=2, name=Balaji, dept=Support, salary=20000], 
Employee [id=5, name=Jeeva, dept=SDE, salary=40000], 
Employee [id=3, name=Nithish, dept=HR, salary=30000], 
Employee [id=4, name=Subash, dept=SDE, salary=40000], 
Employee [id=1, name=Vignesh, dept=Manager, salary=50000], 
Employee [id=0, name=Yogesh, dept=SDE, salary=30000]]

### Descending
[Employee [id=0, name=Yogesh, dept=SDE, salary=30000], 
Employee [id=1, name=Vignesh, dept=Manager, salary=50000],
 Employee [id=4, name=Subash, dept=SDE, salary=40000], 
 Employee [id=3, name=Nithish, dept=HR, salary=30000], 
 Employee [id=5, name=Jeeva, dept=SDE, salary=40000], 
 Employee [id=2, name=Balaji, dept=Support, salary=20000]]
 */