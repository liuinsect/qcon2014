package demo1_concurrentHashMap.forEach;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BiConsumer;

/**
 * 指定并发程度
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-26
 * Time: 下午7:49
 * To change this template use File | Settings | File Templates.
 */
public class Main2 {

    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<String,Integer>();


        for (int i = 0; i < 100; i++) {
            map.put(String.valueOf(i),i);
        }

        map.forEach(15, new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                StringBuilder sb = new StringBuilder();
                sb.append("this is :" + Thread.currentThread());
                sb.append("key:"+s);
                sb.append("value:"+integer);
                System.out.println(sb);
            }
        });

//        int n = 100;
//        int b=15;
//        System.out.println( n/= b);
//
//        System.out.println(ForkJoinPool.getCommonPoolParallelism());
//
//        int sp = ForkJoinPool.getCommonPoolParallelism() << 2; // slack of 4
//        System.out.println(sp);
//        System.out.println((n /= b)>= sp ? sp : (int)n);

    }



}
