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

    }

}
