class Buffer {
    private int[] buffer = new int[10];
    private int count = 0;

    // Producer adds data to the buffer
    public synchronized void produce(int item) throws InterruptedException {
        while (count == buffer.length) {
            wait();  // Buffer is full, wait for space
        }
        buffer[count++] = item;
        System.out.println("Produced: " + item);
        notify();  // Notify consumer that there is data
    }

    // Consumer consumes data from the buffer
    public synchronized int consume() throws InterruptedException {
        while (count == 0) {
            wait();  // Buffer is empty, wait for data
        }
        int item = buffer[--count];
        System.out.println("Consumed: " + item);
        notify();  // Notify producer that space is available
        return item;
    }
}

class Producer extends Thread {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.produce(i);
                Thread.sleep(500);  // Simulate time taken to produce
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.consume();
                Thread.sleep(1000);  // Simulate time taken to consume
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumer2 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
