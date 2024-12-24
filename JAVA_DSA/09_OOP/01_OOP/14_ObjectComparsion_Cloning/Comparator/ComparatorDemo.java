

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*
It's like a teacher outside the class tells the students how to line up (e.g., by roll number).
The students follow the teacher’s rule, but they don’t know how to sort themselves.
The sorting rule is defined externally (by the Comparator), not by the students.

 */
class Student {
    public int rollNo;
    public String name;

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{rollNo=" + rollNo + ", name='" + name + "'}";
    }
}


// here's your teacher
class RollNoComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.rollNo - s2.rollNo; // Compare by roll number
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(3, "loki"),
            new Student(1, "zen"),
            new Student(2, "anu")
        );

        // Sorting by roll number using Comparator
        Collections.sort(students, new RollNoComparator());
        System.out.println("Students sorted by roll number:");
        for (Student student : students) {
            System.out.println(student);
        }   
    }
}
/*
Students sorted by rollno
Student[rollno: 1, name: zen]
Student[rollno: 2, name: anu]
Student[rollno: 3, name: loki]
 */