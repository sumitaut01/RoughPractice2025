package basics;

//# Java Anonymous Class – `Checker<Boolean>`


public class AnonymousClassDemo {

    // Generic interface
    interface Checker<T> {
        T check(String value);
    }

    public static void main(String[] args) {

        // Create an anonymous object implementing Checker<Boolean>
        Checker<Boolean> checker = new Checker<Boolean>() {

            @Override
            public Boolean check(String value) {
                return value.contains("apple");
            }
        };

        // Call the method
        Boolean result = checker.check("I like apple");

        System.out.println(result);   // true
    }
}

//## What's happening?
//
//### 1. Interface
//
////```java
//interface Checker<T> {
//    T check(String value);
//}
//```
//
//`T` is a generic type.
//
//When we write:
//
//```java
//Checker<Boolean>
//```
//
//`T` becomes `Boolean`.
//
//So effectively:
//
//```java
//Boolean check(String value);
//```
//
//---
//
//### 2. Create the object
//
//```java
//Checker<Boolean> checker = new Checker<Boolean>() {
//
//    @Override
//    public Boolean check(String value) {
//        return value.contains("apple");
//    }
//};
//```
//
//The important part:
//
//```java
//new Checker<Boolean>() {
//    ...
//}
//```
//
//means:
//
//> Create an object that implements `Checker<Boolean>`, and here's the implementation of its `check()` method.
//
//This is an **anonymous class** because we haven't given the implementation class a name.
//
//---
//
//### 3. Call the method
//
//Only here does the method actually execute:
//
//```java
//checker.check("I like apple");
//```
//
//Flow:
//
//```text
//new Checker<Boolean>() { ... }
//          ↓
//     Object created
//          ↓
//       checker
//          ↓
//checker.check("I like apple")
//          ↓
//       method runs
//          ↓
//        true
//```
//
//### The key distinction
//
//```java
//new Checker<Boolean>() {
//    // method implementation
//}
//```
//
//**creates the object and defines its behavior.**
//
//Whereas:
//
//```java
//checker.check("I like apple");
//```
//
//**calls the method and executes the behavior.**
