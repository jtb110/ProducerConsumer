package producerconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Jonas
 */
public class ProducerConsumer {

    private static BlockingQueue<Long> BQin = new ArrayBlockingQueue<>(20);
    private static BlockingQueue<Long> BQout = new ArrayBlockingQueue<>(20);

    public static void main(String[] args) throws InterruptedException {
        BQin.add((long) 4);
        BQin.add((long) 5);
        BQin.add((long) 8);
        BQin.add((long) 12);
        BQin.add((long) 21);
        BQin.add((long) 22);
        BQin.add((long) 34);
        BQin.add((long) 35);
        BQin.add((long) 36);
        BQin.add((long) 37);
        BQin.add((long) 42);

        List<Thread> thread = new ArrayList<>();
//Starts the 4 threads as required by assignment
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(new Producer(BQin, BQout));
            t.start();
            thread.add(t);
        }

        Consumer con = new Consumer(BQout);
        Thread t3 = new Thread(con);
        t3.start();

        for (Thread t : thread) {
            t.join();
        }
        t3.interrupt();
        System.out.println("Total fib sum; " + con.getSum());

    }

}
