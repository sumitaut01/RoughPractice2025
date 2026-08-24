//java.util.Objects is a utility class introduced to make null checks, equality checks, hash code generation, and validation easier.

package basics;


import java.util.Objects;


public class ObjectsDemo {


    public static void main(String[] args) {
        String s1 = null;
        String s2 = null;
        String s3 = "Hello";

        // 1. isNull()
        System.out.println("s1 is null: " + Objects.isNull(s1));
        System.out.println("s3 is null: " + Objects.isNull(s3));


        // 2. nonNull()
        System.out.println("s3 is non-null: " + Objects.nonNull(s3));


        // 3. equals() - null safe comparison
        System.out.println("s1 equals s2: " + Objects.equals(s1, s2)); // true
        System.out.println("s1 equals s3: " + Objects.equals(s1, s3)); // false
        System.out.println("s3 equals Hello: " + Objects.equals(s3, "Hello")); // true


        // 4. deepEquals() - compares array contents recursively
        String[] arr1 = {"A", "B"};
        String[] arr2 = {"A", "B"};


        System.out.println("equals(arr1, arr2): " + Objects.equals(arr1, arr2));
        System.out.println("deepEquals(arr1, arr2): " + Objects.deepEquals(arr1, arr2));


        // 5. requireNonNull()
        String name = Objects.requireNonNull(s3, "Name cannot be null");
        System.out.println(name);


        // 6. hash()
        System.out.println("Hash: " + Objects.hash("John", 25));


        // 7. toString()
        System.out.println(s1);          // "null"
        System.out.println(Objects.toString(s1, "N/A"));  // "N/A"
    }
}
   /* Most commonly used in real projects Null-safe equality

        Instead of:

        if(name != null && name.equals("John"))

        Use:

        if (Objects.equals(name, "John"))
        Null validation

        Constructor validation:

public Employee(String name) {
        this.name = Objects.requireNonNull(name, "Name is mandatory");
        }
        Streams filtering
        list.stream()
        .filter(Objects::nonNull)
        .forEach(System.out::println);
        hashCode generation
@Override
public int hashCode() {
        return Objects.hash(id, name);
        }
        equals() vs deepEquals()
        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 2, 3};


        System.out.println(Objects.equals(a1, a2));      // false
        System.out.println(Objects.deepEquals(a1, a2));  // true

        equals() compares object references for arrays, while deepEquals() compares the contents of arrays (including nested arrays). This is the main difference interviewers usually expect.

        */
