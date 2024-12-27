
interface  Animal {
    void sound();
}

class Dog implements Animal{
    public void sound(){
        System.out.println("bark");
    }
}

class Cat implements Animal{
    public void sound(){
        System.out.println("Meow");
    }
}

class AnimalFact {
    public static Animal getAnimal(String type){
        return switch (type.toUpperCase()){
            case "DOG" -> new Dog();
            case "CAT" -> new Cat();
            default ->  null;
        };
    }
}

public class FactoryDemo2 {
    public static void main(String[] args) {

        Animal obj = AnimalFact.getAnimal("CAT");
        obj.sound();
        
    }

}
