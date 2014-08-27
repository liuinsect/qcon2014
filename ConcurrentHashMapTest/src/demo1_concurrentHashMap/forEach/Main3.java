package demo1_concurrentHashMap.forEach;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 将key为 a b c的 键值对 做某件事情
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-26
 * Time: 下午7:49
 * To change this template use File | Settings | File Templates.
 */
public class Main3 {

    static class Node {

        private Integer num;

        Node(Integer num) {
            this.num = num;
        }

        public void doSomething() {
            System.out.println("this is " + num + " doSomething");
        }
    }


    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Node> map = new ConcurrentHashMap<Integer, Node>();


        for (int i = 0; i < 100; i++) {
            map.put(i, new Node(i));
        }

        map.forEach(3, new BiFunction<Integer, Node, Node>() {
                    @Override
                    public Node apply(Integer integer, Node node) {
                        if (integer % 10 == 0) {
                            return node;
                        }
                        return null;  //To change body of implemented methods use File | Settings | File Templates.
                    }

                }, new Consumer<Node>() {

                    @Override
                    public void accept(Node node) {
                        node.doSomething();
                    }

                }
        );

    }


}
