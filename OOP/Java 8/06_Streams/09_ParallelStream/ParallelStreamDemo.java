import java.util.stream.IntStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {

        // stream
        IntStream range = IntStream.rangeClosed(10, 15);
        range.forEach(x -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + " value: " + x);
        });

        // parallel stream 
        IntStream range2 = IntStream.rangeClosed(10, 15);
        range2.parallel().forEach(x -> {
            System.out.println("Thread: " + Thread.currentThread().getName() + " value: " + x);
        });
    }

}

/*
 
hread: main value: 10
Thread: main value: 11
Thread: main value: 12
Thread: main value: 13
Thread: main value: 14
Thread: main value: 15
Thread: main value: 13
Thread: main value: 15
Thread: main value: 14
Thread: ForkJoinPool.commonPool-worker-1 value: 11
Thread: ForkJoinPool.commonPool-worker-2 value: 10
Thread: ForkJoinPool.commonPool-worker-3 value: 12

#### ForkJoinPool
 - A parallel execution framework used for handling recursive and parallelizable tasks.
 -  Uses a divide-and-conquer approach to split tasks into smaller subtasks and process them concurrently.

*/
