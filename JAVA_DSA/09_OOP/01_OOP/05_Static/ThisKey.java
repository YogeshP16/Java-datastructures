class ThisKey {
    // Non-static variable
    int instanceVariable = 10;

    // Static method
    static void staticMethod() {
        // Trying to use `this` will result in an error
        // System.out.println(this.instanceVariable); // ERROR: Cannot use 'this' in static context

        System.out.println("Static methods cannot use 'this'.");
    }

    // Non-static method
    void instanceMethod() {
        // Using `this` is valid here
        System.out.println("Instance variable accessed with 'this': " + this.instanceVariable);
    }

    public static void main(String[] args) {
        // Calling static method
        ThisKey.staticMethod();

        // Creating an instance to call the non-static method
        ThisKey obj = new ThisKey();
        obj.instanceMethod();
    }

    /*
    Why this is Not Allowed in Static Methods:
        The this keyword refers to the current instance of the class.
        Static methods belong to the class itself, not any specific instance. 
        Since no instance context exists in a static method, this cannot be used.

    Valid Use of this in Non-static Methods:
        Non-static methods are called on specific instances of the class, so they have access to this to refer to the current object.
     */
}
