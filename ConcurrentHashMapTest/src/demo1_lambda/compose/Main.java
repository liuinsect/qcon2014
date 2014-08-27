package demo1_lambda.compose;

import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-27
 * Time: 上午10:00
 * To change this template use File | Settings | File Templates.
 */
public class Main {


    public static void main(String[] args) {
        Grandpa grandpa = new Grandpa();
        Son son = new Son();
        son.setName("son");

        grandpa.setSon(son);

        Function<Fathor, String> getName = Fathor::getName;
        Function<Grandpa, Son> getSon = Grandpa::getGrandSon;
        //getSon的输出将会作为getName的输入
        //因此，getSon的返回值（"son"）必须要为getName对应的类型的子类的子类 以方便apply
        Function composeFunction = getName.compose(getSon);

        System.out.println(composeFunction.apply(grandpa));


    }

}
