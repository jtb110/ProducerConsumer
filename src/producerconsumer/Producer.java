/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonas
 */
public class Producer implements Runnable {

    private BlockingQueue<Long> BQin;
    private BlockingQueue<Long> BQout;

    public Producer(BlockingQueue<Long> BQin, BlockingQueue<Long> BQout) {
        this.BQin = BQin;
        this.BQout = BQout;

    }

    public void run() {
        Long c;
//when c is in the thread pool and NOT null
        while ((c = BQin.poll()) != null) {
            try {
                BQout.put(fib(c));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
