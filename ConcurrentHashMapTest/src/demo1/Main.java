package demo1;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-26
 * Time: 下午7:49
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<String,Integer>();


        map.put("1",1);
        map.put("2",2);
        map.put("3",3);


//        map.forEach(new BiConsumer() {
//            @Override
//            public void accept(Object o, Object o2) {
//                System.out.println(o);
//                System.out.println(o2);
//            }
//
//            @Override
//            public BiConsumer andThen(BiConsumer after) {
//                System.out.println(after);
//                return null;  //To change body of implemented methods use File | Settings | File Templates.
//            }
//        });

//        map.forEach(3,new BiFunction<String, Integer, Object>() {
//            @Override
//            public Object apply(String s, Integer integer) {
////                System.out.println(s);
////                System.out.println(integer);
//                return null;  //To change body of implemented methods use File | Settings | File Templates.
//            }
//
//            @Override
//            public <V> BiFunction<String, Integer, V> andThen(Function<? super Object, ? extends V> after) {
//                return null;  //To change body of implemented methods use File | Settings | File Templates.
//            }
//        },new Consumer<Object>() {
//                    @Override
//                    public void accept(Object o) {
//                        System.out.println("acc"+o);
//                    }
//
//                    @Override
//                    public Consumer<Object> andThen(Consumer<? super Object> after) {
//                        System.out.println("andThen"+after);
//                        return null;  //To change body of implemented methods use File | Settings | File Templates.
//                    }
//                });


//          map.reduceKeys(3,new BiFunction<String, String, String>() {
//              @Override
//              public String apply(String s, String s2) {
//                  System.out.println(s);
//                  System.out.println(s2);
//                  return "4";  //To change body of implemented methods use File | Settings | File Templates.
//              }
//
//              @Override
//              public <V> BiFunction<String, String, V> andThen(Function<? super String, ? extends V> after) {
//                  return null;  //To change body of implemented methods use File | Settings | File Templates.
//              }
//          });




        Object result = map.reduceKeys(1,new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                System.out.println(s);
                System.out.println(s2);
                return "4";  //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public <V> BiFunction<String, String, V> andThen(Function<? super String, ? extends V> after) {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        System.out.println(result);

    }



}
