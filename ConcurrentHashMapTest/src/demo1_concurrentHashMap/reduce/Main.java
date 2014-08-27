package demo1_concurrentHashMap.reduce;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * 指定并发程度
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-26
 * Time: 下午7:49
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();


        for (int i = 0; i < 100; i++) {
            map.put(String.valueOf(i), i);
        }

        Object result = map.reduce(4, new BiFunction() {
                    @Override
                    public Object apply(Object o, Object o2) {
                        Integer integer = (Integer) o2;
                        if (integer % 10 == 0) {
                            return o;
                        }

                        return null;  //To change body of implemented methods use File | Settings | File Templates.
                    }
                }, new BiFunction() {

                    /**
                     * o o2 都为匹配到的值
                     * see line:563:
                     *   for (Node<K,V> p; (p = advance()) != null; ) {
                     *      U u;
                     *      if ((u = transformer.apply(p.key, p.val)) != null)
                     *      r = (r == null) ? u : reducer.apply(r, u);
                     *   }
                     * @param o
                     * @param o2
                     * @return
                     */
                    public Object apply(Object o, Object o2) {
                        System.out.print("o:"+o);
                        System.out.println("o2:"+o2);
                        return null;  //To change body of implemented methods use File | Settings | File Templates.
                    }
                }
        );

        System.out.println(result);

    }


}
