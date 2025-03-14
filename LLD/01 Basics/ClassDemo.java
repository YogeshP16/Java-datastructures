class Student {
    String name;
    int age;
    char grade;

    // default constructor
    Student(){
        this.name = "Zekee";
        this.age = 12;
        this.grade = 's';
    }


    // constructor
    Student (String name, int age, char grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    void displayInfo() {
        System.out.println("I am " + name + ". I am " + age + " years old.");
        System.out.println("grade " +grade);
    }
}

public class ClassDemo {
    public static void main(String[] args) {

        // Before adding constructor
        // Student student = new Student();  
        // student.name = "Zen";
        // student.age = 23; 
        // student.grade = 'A';


        // adding constructor - parametrized one
        Student student = new Student("Zen", 23, 'A');
        student.displayInfo();  

        // constructor default one
        Student s2 = new Student();
        s2.displayInfo();
    }
}
