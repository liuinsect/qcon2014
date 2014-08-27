package demo2_stampedLock;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-27
 * Time: 下午4:50
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    static class Reader implements Runnable{

        private StampedLock lock;

        Reader(StampedLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            long stamped = lock.readLock();
            try {
                Thread.sleep(1000*3);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            lock.unlock(stamped);

        }

    }

    static class Writer implements Runnable{

        private StampedLock lock;

        Writer(StampedLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            long stamped = lock.writeLock();
            try {
                Thread.sleep(1000*3);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            lock.unlock(stamped);
        }

    }


    public static void main(String[] args) {

    }




}
