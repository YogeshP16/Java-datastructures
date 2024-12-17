// Non-Static Inner Class

class OuterClass {
    private String message = "Hello from OuterClass!";

    // Member Inner Class
    class InnerClass {
        void displayMessage() {
            System.out.println("Message: " + message);
        }
    }

    public static void main(String[] args) {
        OuterClass outer = new OuterClass(); // Create object of OuterClass
        OuterClass.InnerClass inner = outer.new InnerClass(); // Create object of InnerClass
        inner.displayMessage();
    }
}

// Static Nested Class
class OuterClass1 {
    private static String staticMessage = "Hello from Static Nested Class!";

    // Static Nested Class
    static class StaticNestedClass {
        void displayMessage() {
            System.out.println("Message: " + staticMessage);
        }
    }

    public static void main(String[] args) {
        // No need for an instance of OuterClass to create StaticNestedClass
        OuterClass1.StaticNestedClass nested = new OuterClass1.StaticNestedClass();
        nested.displayMessage();
    }
}
