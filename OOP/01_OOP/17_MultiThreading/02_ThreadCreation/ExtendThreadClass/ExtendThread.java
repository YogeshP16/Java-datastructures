class MyThread extends Thread {
    public void run(){
        System.out.println("code executed: " + Thread.currentThread().getName());
    }

}

public class ExtendThread {
    public static void main(String[] args) {

        System.out.println("Going inside main : " + Thread.currentThread().getName());

        MyThread t = new MyThread();
        t.start();

        System.out.println("Finish Main method: " + Thread.currentThread().getName());
        
    }

}
/*
Going inside main : main
Finish Main method: main
code executed: Thread-0
 */
