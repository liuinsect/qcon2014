package demo1_lambda;

import demo1_lambda.andThen.Person;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-27
 * Time: 上午10:14
 * To change this template use File | Settings | File Templates.
 */
public class Man {

    private Person wife;

    private Person self;

    public Man(Person self) {
        this.self = self;
        this.wife = new Person();
    }
}
