package basics.javarecords;

public class RecordDemo {

    public static void main(String[] args) {
         record Employee(int id, String name) //stopped me from writing public ???
        {
        }

        Employee emp = new Employee(1, "Sumit");

        System.out.println(emp.id());
        System.out.println(emp.name());

        System.out.println(emp.id);
        System.out.println(emp.name);









    }
}



/*

With a record:

public record Employee(int id, String name) {
}

Java automatically generates:

employee.id()
employee.name()
toString()
equals()
hashCode()
constructor

Usage:

Employee emp = new Employee(1, "Sumit");


System.out.println(emp.id());
System.out.println(emp.name());
When to use records?

For immutable data objects:

API request/response DTOs
Configuration objects
Database result objects
Event messages
 */


/*


Introduced officially in Java 16.

Before records, for a simple data class you had to write:

public class Employee {
    private final int id;
    private final String name;


    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        ...
    }


    @Override
    public boolean equals(Object o) {
        ...
    }


    @Override
    public int hashCode() {
        ...
    }
}

Lots of boilerplate.
 */