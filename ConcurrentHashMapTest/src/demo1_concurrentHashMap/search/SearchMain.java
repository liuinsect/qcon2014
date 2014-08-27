package demo1_concurrentHashMap.search;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * 指定并发程度
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-26
 * Time: 下午7:49
 * To change this template use File | Settings | File Templates.
 */
public class SearchMain {

    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<String,Integer>();


        for (int i = 0; i < 100; i++) {
            map.put(String.valueOf(i),i);
        }

        Object result = map.search(4,new BiFunction<String, Integer, Object>() {
            @Override
            public Object apply(String s, Integer integer) {
                System.out.println(integer);
                if( integer == 5 || integer ==15){//是倒着找的，找到就退出了。
                    return s;
                }

                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        System.out.println(result);

    }



}
