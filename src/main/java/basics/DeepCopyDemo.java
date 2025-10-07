package basics;

class Address implements Cloneable {
    String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Address(this.city); // create new Address object
    }
}

class TestPerson2 implements Cloneable {
    String name;
    Address address;

    public TestPerson2(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Address clonedAddress = (Address) address.clone(); // deep copy
        return new TestPerson2(this.name, clonedAddress);
    }
}

public class DeepCopyDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("Pune");
        TestPerson2 p1 = new TestPerson2("Sumit", addr);
        TestPerson2 p2 = (TestPerson2) p1.clone(); // deep copy

        System.out.println("Before: " + p1.address.city + " | " + p2.address.city);
        p2.address.city = "Delhi";
        System.out.println("After: " + p1.address.city + " | " + p2.address.city);
    }
}
