
public interface AndroidUpdate {  // Interface

    // Abstract Method --> must implement in subclass
    // In SmartPhone class --> Implemneted
    void downloadUpdate(String UpdateOS);

    // Defaault method  --> Add new methods to interfaces without breaking old code.
    default void installUpdate(String UpdateOS){
        System.out.println("Installing OS: " + UpdateOS );

    }

     // Static method --> belongs to interface itself not object
     static String getOSInfo() {
        return "Android OS - Version 15.0 (Android Z)";
    }

    // It default takes constants (Final & static variables)
    final int MAX_MB = 345;
    int MAX_SIZE = 345; // default it takes final

}
