class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

public class InstanceOfExample {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        // Checking subclass relationships
        System.out.println(dog instanceof Animal);  // true (Dog is a subclass of Animal)
        System.out.println(dog instanceof Dog);    // true (dog is a Dog)
        System.out.println(cat instanceof Dog);    // false (cat is not a Dog)

        // Checking for null
        Animal nullAnimal = null;
        System.out.println(nullAnimal instanceof Animal); // false

        // Checking interface implementation
        Runnable runnable = new Thread();
        System.out.println(runnable instanceof Runnable); // true (Thread implements Runnable)
    }
}

/*
Here’s an **easy way to remember `instanceof`:**

### **"Is it a kind of?"**
- Use `instanceof` to check if an object is **a kind of** a specific class or interface.  
  Example:  
  - Is a `Dog` a kind of `Animal`? ✅  
  - Is a `Cat` a kind of `Dog`? ❌  

### **Key Mnemonic**
- **"Instance = Belongs"**:  
  - Checks if the object **belongs** to a class, subclass, or implements an interface.

### **Simple Example in Words**
- `dog instanceof Animal` → **"Is the dog a kind of Animal?"**  
- `thread instanceof Runnable` → **"Is the thread a kind of Runnable?"**

 */