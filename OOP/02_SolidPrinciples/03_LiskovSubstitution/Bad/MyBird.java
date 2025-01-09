class Bird {
    public void fly() {
        System.out.println("I can fly!");
    }
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow flies high!");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {  // This doesn't make sense for a penguin
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}

public class MyBird {
    public static void main(String[] args) {
        Bird myBird = new Sparrow();
        myBird.fly(); // Works fine

        Bird myPenguin = new Penguin();
        myPenguin.fly(); // Throws an exception, breaking the principle
    }
}

/*
Sparrow flies high!
Exception in thread "main" java.lang.UnsupportedOperationException: Penguins can't fly!
        at Penguin.fly(MyBird.java:17)
        at MyBird.main(MyBird.java:27)

Liskov Sustitution --> subclass shoule be able to replace parent class without breaking logic;

here --> All birds can supposedly fly, but now we introduce a subclass Penguin. 
Penguins can't fly, so this violates the Liskov Substitution Principle because 
Penguin doesn't work the same way as other birds.
 */