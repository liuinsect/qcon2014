package demo1_lambda.compose;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-27
 * Time: 上午10:40
 * To change this template use File | Settings | File Templates.
 */
public class Fathor extends Grandpa {

    private String name;

    public String getName() {
        System.out.println("this is getName");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
