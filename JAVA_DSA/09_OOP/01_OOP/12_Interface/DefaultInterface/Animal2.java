// Interface after Java 8 with default method
interface AnimalInterface {
    void eat();

    // Default method (provides a default implementation)
    default void sleep() {
        System.out.println("Animal is sleeping");
    }
}

class Dog implements AnimalInterface {
    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    // No need to implement sleep() as it's already provided in the interface
}

class Main {
    public static void main(String[] args) {
        AnimalInterface dog = new Dog();
        dog.eat();
        dog.sleep();  // Calls the default implementation
    }
}

/* 
Dog is eating
Dog is sleeping
*/