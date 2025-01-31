import java.util.HashSet;
import java.util.Set;

public class ForEachSet {
    public static void main(String[] args) {

        Set<Person> person = new HashSet<Person>();
        person.add(new Person(1, "Yogesh", "Ece"));
        person.add(new Person(2, "Zen", "Cse"));

        person.forEach((result) -> {
            System.out.println(result.getId());
        });


        
    }

}
