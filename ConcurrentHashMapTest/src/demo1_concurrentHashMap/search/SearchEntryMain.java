package demo1_concurrentHashMap.search;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 指定并发程度
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-26
 * Time: 下午7:49
 * To change this template use File | Settings | File Templates.
 */
public class SearchEntryMain {

    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<String,Integer>();


        for (int i = 0; i < 100; i++) {
            map.put(String.valueOf(i),i);
        }

        Object result = map.searchEntries(4, new Function<Map.Entry<String, Integer>, Object>() {
            @Override
            public Object apply(Map.Entry<String, Integer> stringIntegerEntry) {
                if( stringIntegerEntry.getValue() == 8 ){
                    return stringIntegerEntry;
                }
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        System.out.println(result);

    }



}
