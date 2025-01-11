class MyRunnable implements Runnable{
    public void run(){
        System.out.println("Code executed: " + Thread.currentThread().getName());
    }
}

public class ImplementRunnable {
    public static void main(String[] args) {
        System.out.println("Going inside Main method: " + Thread.currentThread().getName());

        MyRunnable runnableobj = new MyRunnable();
        Thread t = new Thread(runnableobj);
        t.start();

        System.out.println("Finish Main me: " + Thread.currentThread().getName());

    }

}

/*
Going inside Main method: main
Finish Main me: main
Code executed: Thread-0
 */