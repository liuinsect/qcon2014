package demo1_concurrentHashMap.reduce;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.ToLongBiFunction;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-27
 * Time: 下午3:38
 * To change this template use File | Settings | File Templates.
 */
public class ReduceLongMain {


    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();


        for (int i = 0; i < 100; i++) {
            map.put(String.valueOf(i), i);
        }

        Object result = map.reduceToLong(4, new ToLongBiFunction() {

            @Override
            public long applyAsLong(Object o, Object o2) {

                Integer integer = (Integer)o2;
                if( integer % 10 == 0 ){
                    return integer;
                }

                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

        },999, new LongBinaryOperator() {

                    @Override
                    public long applyAsLong(long left, long right) {
                        if( right == 0 ){
                            return 0;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("left:" + left);
                        sb.append("right:" + right);
                        System.out.println(sb);
                        return 0;  //To change body of implemented methods use File | Settings | File Templates.
                    }

                }
        );

        System.out.println(result);

    }


}
