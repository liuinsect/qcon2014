package demo1_lambda.compose;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-27
 * Time: 上午10:40
 * To change this template use File | Settings | File Templates.
 */
public class Grandpa {

    private Son son;

    public Son getGrandSon(){
        System.out.println("this grand son");
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }
}
