
// wrap up the implementation of the data numbers & methods in the data
// Getters are methods used to retrieve or get the value of a private field.
// Setters are methods used to update or set the value of a private field.

class Person2 {
    private String name;
    private int age;
    
    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { if(age > 0) this.age = age; }
}

public class Main {
    public static void main(String[] args) {
        Person2 person = new Person2("John", 25);
        person.setName("Alice");
        person.setAge(30);
        System.out.println(person.getName() + " is " + person.getAge() + " years old.");
    }
}
