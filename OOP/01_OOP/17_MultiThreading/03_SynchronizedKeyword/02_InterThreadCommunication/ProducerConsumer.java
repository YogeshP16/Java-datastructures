class SharedBuffer {
    private int data;
    private boolean isEmpty = true;

    public synchronized void produce(int value) {
        while (!isEmpty) {
            try {
                wait(); // Wait until the buffer is empty
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data = value;
        isEmpty = false;
        System.out.println("Produced: " + data);
        notify(); // Notify the consumer
    }

    public synchronized int consume() {
        while (isEmpty) {
            try {
                wait(); // Wait until the buffer has data
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isEmpty = true;
        System.out.println("Consumed: " + data);
        notify(); // Notify the producer
        return data;
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        // Producer Thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}

/*
### How It Works:
    Producer adds an item to the buffer.
    If the buffer is full, the producer waits (wait()) for the consumer to consume an item and free space.
    Consumer retrieves an item from the buffer.
    If the buffer is empty, the consumer waits (wait()) for the producer to produce more items.
    After producing or consuming, the producer and consumer notify each other (notify()).

### Output
Produced: 1
Consumed: 1
Produced: 2
Consumed: 2
Produced: 3
Consumed: 3
Produced: 4
Consumed: 4
Produced: 5
Consumed: 5
 */