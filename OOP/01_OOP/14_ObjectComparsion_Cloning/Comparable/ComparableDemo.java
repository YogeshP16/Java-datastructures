
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
- It's like students in a class naturally knowing their roll numbers.
- They can line up in order of their roll numbers without needing anyone else to tell them how to do it.
- The rule of sorting by roll number is built into them, so they can organize themselves automatically.
 */

class Student implements Comparable<Student>{
    int rollno;
    String name;

    // constructor
    public Student(int rollno, String name){
        this.name = name;
        this.rollno = rollno;
    }
    // compareTo -->  The compareTo method works by comparing the current object (this) to another object (other)
    public int compareTo(Student other){
        return this.rollno - other.rollno;
    }

    public String toString(){
        return "Student[rollno: " + rollno + ", name: " + name + "]";
    }


}


public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(3, "loki"),
            new Student(1, "zen"),
            new Student(2, "anu")
        );

        // natural sorting 
        Collections.sort(students);

        System.out.println("Students sorted by rollno");
        for(Student s :  students){
            System.out.println(s);
        }
        
    }

}

/*
Students sorted by rollno
Student[rollno: 1, name: zen]
Student[rollno: 2, name: anu]
Student[rollno: 3, name: loki]
 */
