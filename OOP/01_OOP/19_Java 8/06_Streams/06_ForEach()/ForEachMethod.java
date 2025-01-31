import java.util.ArrayList;
import java.util.List;

public class ForEachMethod {
    public static void main(String[] args) {

        List<Person> person = new ArrayList<Person>();
        person.add(new Person(1, "Yogesh", "Ece"));
        person.add(new Person(2, "Zen", "Cse"));

        // before java 8

        for (Person res : person) {
            System.out.println(res.getDept());
            
        } 

       

         // java 8

        person.forEach((result) -> {
            System.out.println(result.getName());
        });

       

         // forEach with stream

         person.stream().forEach((result) -> {
            System.out.println(result.getDept());
         });

       

        


        
    }

}
class Person{
    int id;
    String name;
    String dept;
    
    public Person(int id, String name, String dept) {
            this.id = id;
            this.name = name;
            this.dept = dept;
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

    
    

}
