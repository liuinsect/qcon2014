package demo1_lambda.andThen;

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
        Person person = new Person();
        Address address = new Address();
        address.setCountry("china");
        person.setAddress(address);


        Function<Person, Address> personToAddress = Person::getAddress;
        Function<Address, String> addressToCountry = Address::getCountry;

        Function<Person, String> toCountry = personToAddress.andThen(addressToCountry);
        String result = toCountry.apply(person);
        System.out.println(result);

    }

}
