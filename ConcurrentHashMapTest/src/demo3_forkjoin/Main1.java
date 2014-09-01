package demo3_forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-9-1
 * Time: 下午3:43
 * To change this template use File | Settings | File Templates.
 */
public class Main1 {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.execute(new Task());
        System.out.println("1");

    }

    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("ss");
        }
    }


}
