
public class EnumSingleton {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        instance.showmessage();

    }

}
enum Singleton{
    INSTANCE;
    public void showmessage(){
        System.out.println("hello from enum");
    }
}


/*
INSTANCE: The single instance of the Singleton class is created as an enum constant.
Method (showmessage): A regular method inside the enum to demonstrate functionality.
 */