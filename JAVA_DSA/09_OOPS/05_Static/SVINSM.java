// ACCESSING STATIC VARIABLE INSIDE NON STATIC METHODS --> you can directly accesss cuz it belongs to class

class SVINSM {  

    // Static variable
    static int staticVariable = 100;

    // Non-static method
    void instanceMethod() {
        // Accessing the static variable directly
        System.out.println("Accessing static variable: " + staticVariable);

        // Accessing the static variable using the class name (optional, but clearer)
        System.out.println("Accessing static variable via class name: " + SVINSM.staticVariable);
    }

    public static void main(String[] args) {
        // Creating an instance to call the non-static method
        SVINSM obj = new SVINSM();
        obj.instanceMethod();
    }
}
