class StudentInfo {
    // ✅ Private variables (data hiding)
    private String name;
    private int age;
    private char grade;

    // ✅ Constructor
    StudentInfo(String name, int age, char grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // ✅ Getter Methods (To Read Data)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGrade() {
        return grade;
    }

    // ✅ Setter Methods (To Modify Data)
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) { // ✅ Validation: Age should be positive
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }

    public void setGrade(char grade) {
        if (grade == 'A' || grade == 'B' || grade == 'C') {
            this.grade = grade;
        } else {
            System.out.println("Invalid grade!");
        }
    }

    // ✅ Display Info Method
    void displayInfo() {
        System.out.println("I am " + name + ". I am " + age + " years old.");
        System.out.println("Grade: " + grade);
    }
}

public class Encapsulation2 {
    public static void main(String[] args) {
        StudentInfo student = new StudentInfo("Zen", 23, 'A');

        student.displayInfo();

        System.out.println("\n🔹 Updating Student Info...");
        student.setAge(25);  // Updating age using setter
        student.setGrade('B');  

        System.out.println("\n🔹 After Update:");
        student.displayInfo();
    }
}
