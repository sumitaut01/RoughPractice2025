package basics;

import javax.mail.Address;
import java.util.Objects;

public class ShallowCopyDeepCopy implements  Cloneable{

    public static void main(String[] args) throws CloneNotSupportedException {

        TestAddress testAddress=new TestAddress("bhandara", "rajgoplachari");
        TestPerson  testPerson=new TestPerson(35, "sumit",testAddress);

        System.out.println(testPerson);
        //TestPerson{age=35, name='sumit', address=TestAddress{city='bhandara', street='rajgoplachari'}}


        //deepcopy using clone
        TestPerson testPerson2= (TestPerson) testPerson.clone();
        System.out.println(testPerson2);
        //TestPerson{age=35, name='sumit', address=TestAddress{city='bhandara', street='rajgoplachari'}}

        testPerson2.setAge(40);
        System.out.println(testPerson2);
        //TestPerson{age=40, name='sumit', address=TestAddress{city='bhandara', street='rajgoplachari'}}

        System.out.println(testPerson);//TestPerson{age=35, name='sumit', address=TestAddress{city='bhandara', street='rajgoplachari'}}

        //notice that primitive change is different


        //if we change object then it wil be different
        //default behaviour of object closne is shalow

        testPerson2.setAddress(new TestAddress("nagpur","something"));
        System.out.println(testPerson2);
        //TestPerson{age=40, name='sumit', address=TestAddress{city='nagpur', street='something'}}
        System.out.println(testPerson);








    }
}



class TestPerson implements  Cloneable {
    int age;
    String name;
    TestAddress address;


    @Override
    public String toString() {
        return "TestPerson{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }

    public TestPerson(int age, String name, TestAddress testAddress) {
        this.age = age;
        this.name = name;
        this.address = testAddress;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public TestAddress getAddress() {
        return address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(TestAddress address) {
        this.address = address;
    }
}

class TestAddress implements  Cloneable {
    String city;
    String street;
    @Override
    public String toString() {
        return "TestAddress{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // shallow copy
    }
    TestAddress(String city, String street){
        this.city=city;
        this.street=street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
