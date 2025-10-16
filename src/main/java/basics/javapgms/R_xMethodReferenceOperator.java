package basics.javapgms;

import java.util.List;
import java.util.stream.Collectors;

public class R_xMethodReferenceOperator {
  //Step 1: What is :: called?
    //The :: operator is called the Method Reference Operator in Java.
    //It was introduced in Java 8 along with lambda expressions and the Stream API
    //It provides a shorthand, cleaner way of writing some lambdas — it references an existing method instead of re-writing its body.
    //🔹 Step 2: The intuition
    //Whenever you write a lambda like this:
    //x -> System.out.println(x)
    //You can replace it with:
    //System.out::println
    //✅ Both are equivalent.
    //The :: just says “use this existing method reference instead of writing a new lambda.”


//    Step 7: Behind the scenes
//
//    Each :: reference is just syntactic sugar for a lambda with a matching signature.
//
//    For example:
//
//    Method Reference	Equivalent Lambda
//    System.out::println	x -> System.out.println(x)
//    String::toUpperCase	s -> s.toUpperCase()
//    Integer::parseInt	s -> Integer.parseInt(s)
//    ArrayList::new	() -> new ArrayList<>()
}

class Employee {
    String name;
    Employee(String name) { this.name = name; }
}

 class Demo {
    public static void main(String[] args) {
        List<String> names = List.of("Sumit", "Amit", "Neha");

        // Create Employee objects from names
        List<Employee> employees = names.stream()
                .map(Employee::new) // constructor reference
                .collect(Collectors.toList());

        // Print all names using method reference
        employees.stream()
                .map(e -> e.name)
                .forEach(System.out::println);
    }

    //Sumit
     //Amit
     //Neha
}

