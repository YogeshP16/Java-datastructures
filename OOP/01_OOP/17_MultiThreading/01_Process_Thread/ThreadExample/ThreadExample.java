public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Create and start two thread
        Thread t1 = new Thread(() -> {System.out.println("t1 running");}); 

        Thread t2 = new Thread(() -> {System.out.println("t2 running");}); 

        t1.start();
        t2.start();
 
    }

    /*
    Main thread: main
    t1 running
    t2 running
    */

}
