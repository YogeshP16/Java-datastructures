
abstract class Bird {
    public abstract void makeSound();
}

abstract class FlyingBird extends Bird {
    public void fly() {
        System.out.println("I can fly!");
    }
}

class Sparrow extends FlyingBird {
    @Override
    public void makeSound() {
        System.out.println("Sparrow chirps!");
    }
}

class Penguin extends Bird {
    @Override
    public void makeSound() {
        System.out.println("Penguin honks!");
    }
}

public class BirdsFying {
    public static void main(String[] args) {
        Bird myBird = new Sparrow();
        myBird.makeSound(); // Works fine
        ((FlyingBird) myBird).fly(); // Works fine for flying birds

        Bird myPenguin = new Penguin();
        myPenguin.makeSound(); // Works fine, no confusion
    }
}

/*
Sparrow chirps!
I can fly!
Penguin honks!
 */