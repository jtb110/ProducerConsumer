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
public abstract class Producer implements Runnable {

    private BlockingQueue<Long> in;
    private BlockingQueue<Long> out;

    public Producer(BlockingQueue<Long> in, BlockingQueue<Long> out) {
        this.in = in;
        this.out = out;

    }

    public void Run() {
        Long c;
//when c is in the thread pool and NOT null
        while ((c = in.poll()) != null) {
            try {
                out.put(fibo(c));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private long fibo(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}
