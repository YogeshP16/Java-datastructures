// Interface before Java 8
interface Animal {
    void eat();
    // Suppose you want add sleep() in interface or parent class 
    // you must need to implement this method to all subclasses else you get error
    // New method (will cause a compilation error in classes that implement Animal)
    void sleep();  // All implementing classes need to implement this method
}

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    // heres the implementation for Sleep method
    @Override
    public void sleep() {
        System.out.println("Dog is sleeping");
    }
}

class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat();
        dog.sleep();
    }
}
/* 
Dog is eating
Dog is sleeping
*/