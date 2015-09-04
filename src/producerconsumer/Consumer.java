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
public class Consumer implements Runnable {

    private BlockingQueue in;
    private long sum;

    public long getSum() {
        return sum;
    }

    public Consumer(BlockingQueue<Long> in) {
        this.in = in;
    }

    public void run() {
        Long c = null;
        while (true) {
            try {
                c = (Long) in.take();
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            sum += c;
            System.out.println("Num: " + c);
        }
    }

}
