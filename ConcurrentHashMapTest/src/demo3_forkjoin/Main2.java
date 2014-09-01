package demo3_forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-9-1
 * Time: 下午3:47
 * To change this template use File | Settings | File Templates.
 */
public class Main2 {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        int[] bucket = {1,2,3,4,5};

        Future<Integer> result = forkJoinPool.submit(new Task(bucket,0,5));

        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ExecutionException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    static class Task extends ForkJoinTask{

        private int[] bucket;
        private int startIndex;
        private int length;

        private int countResult;

        Task(int[] bucket,int startIndex,int length) {
            this.bucket = bucket;
            this.startIndex = startIndex;
            this.length = length;
        }

        @Override
        public Object getRawResult() {
            return countResult;  //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        protected void setRawResult(Object value) {
            countResult = (int) value;
        }

        @Override
        protected boolean exec() {
            int size = length;

            if( size  > 2 ){
                Task leftTask = null;
                Task rightTask = null;

                int middle = size/2;
                leftTask = new Task(bucket,startIndex, middle);
                if( size % 2 == 0 ){
                    rightTask = new Task(bucket,startIndex+middle, middle);
                }else{
                    rightTask = new Task(bucket,startIndex+middle, middle+1);
                }

                leftTask.fork();
                rightTask.fork();
                this.countResult = (int)leftTask.join() + (int)rightTask.join();
                return true;
            }

            int sum = 0;

            for (int i = 0; i < size; i++) {
                System.out.println(bucket[startIndex+i]);
                sum+=bucket[startIndex+i];
            }

            countResult = sum;
            return true;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }

}
