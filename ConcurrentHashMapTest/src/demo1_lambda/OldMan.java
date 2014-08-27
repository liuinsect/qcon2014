package demo1_lambda;

import demo1_lambda.andThen.Address;
import demo1_lambda.andThen.Person;

/**
 * Created with IntelliJ IDEA.
 * User: liukunyang
 * Date: 14-8-27
 * Time: 上午10:02
 * To change this template use File | Settings | File Templates.
 */
public class OldMan {

    private Person grandX;

    private Person self;


//    public OldMan(Person self) {
//        this.self = self;
//        Address address = new Address();
//        address.setCountry("africa");
//        this.grandX = new Person();
//        this.grandX.setAddress(address);
//    }

    public String setGrandX(Person grandX) {
        this.grandX = grandX;
        return "x";
    }

    public Address getAddrOfGrandX(){
        return grandX.getAddress();
    }
}
