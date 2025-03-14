class ThreadDemo implements Runnable{
    @Override
    public void run(){
        System.out.println("run mehtod is called");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Thread t = new Thread(new ThreadDemo());
        t.start();

        Thread tl = new Thread(() -> System.out.println("Calling run method"));
        tl.start();
        
    }

}

/*
run mehtod is called
Calling run method
 */