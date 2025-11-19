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

        System.out.println("Before: " + p1.address.city + " | " + p2.address.city);//Before: Pune | Pune
        p2.address.city = "Delhi";
        System.out.println("After: " + p1.address.city + " | " + p2.address.city);//After: Pune | Delhi
    }
}


//Deep Copy vs Shallow Copy in your code
//✔ You implemented deep copy properly because:
//
//You cloned the Address object separately
//
//You built a new Person with a new Address object
//
//✔ What would shallow copy do?
//
//If clone() looked like:
//
//return super.clone();
//
//
//Then both persons would share the SAME address.
//
//Changing city in p2 would change p1!
//
//After: Delhi | Delhi  ❌ unwanted behavior
//
//
//Your code avoids this.
//
//⭐ What’s important to understand (Interview Level)
//✔ Deep copy
//
//→ Entire object graph is duplicated
//→ All nested objects are also cloned
//
//✔ Shallow copy
//
//→ Only top-level object is cloned
//→ Nested objects are shared
//
//✔ Why manual deep cloning?
//
//Because Java’s default super.clone() only does shallow copying.
//
//⭐ Memory Explanation (Important)
//
//When you run:
//
//p2 = p1.clone();
//
//
//Memory looks like this:
//
//p1 --------> [Person object] --------> [Address object: city="Pune"]
//p2 --------> [Person object] --------> [Address object: city="Pune"]
//
//
//After:
//
//p2.address.city = "Delhi"
//
//
//Now:
//
//p1.address.city = "Pune"
//p2.address.city = "Delhi"
//
//
//Two separate Address objects.
//
//⭐ Why Strings don’t need deep cloning?
//
//Because String is immutable in Java.
//That’s why cloning name is not needed.
//
//⭐ Final Explanation (Short)
//
//Your code demonstrates deep copy:
//
//When cloning TestPerson2, you also clone its Address.
//
//So both objects are independent after cloning.
//
//Changing cloned object does NOT affect original.
//
//This is exactly how deep copy should be implemented in Java using clone.