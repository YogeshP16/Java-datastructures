// it ensure only one instance of the class is created

// early --  created when the class is loaded, which guarantees thread safety, 
// as the class loading process is inherently thread-safe.

public class Singleton {
    private static final Singleton instance = new Singleton();
    
    private Singleton(){

    }

    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        
        Singleton obj = Singleton.getInstance();

        System.out.println(obj);  // Singleton@4617c264
    }

}




// lazy --  delay the creation of the singleton instance until it is needed

class Singleton1{
    private static Singleton1 instance;
    private Singleton1(){}
    public static synchronized Singleton1 getInstance(){
        if (instance == null){
            instance =  new Singleton1();
        }
        return instance;
    }

}

