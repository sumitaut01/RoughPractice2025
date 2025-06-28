package basics;

//A Functional Interface is an interface with exactly one abstract method.
//
//        This makes it a target for lambda expressions and method references.

//Rule	Description
//        Exactly one abstract method	Required
//        Can have default or static methods	✅ Allowed (not abstract)
//        Can be annotated with @FunctionalInterface	✅ Recommended (optional)


//Built-in Functional Interfaces in java.util.function
//        Java provides many ready-to-use functional interfaces:
//
//        Interface	Signature	Description
//        Runnable	void run()	No input, no return
//        Supplier<T>	T get()	Returns value, takes nothing
//        Consumer<T>	void accept(T t)	Takes value, returns nothing
//        Function<T,R>	R apply(T t)	Takes input, returns output
//        Predicate<T>	boolean test(T t)	Takes input, returns boolean
//        BiFunction<T,U,R>	R apply(T t, U u)	Two inputs, one output
public class R18_FunctionalInterface_01 {


    public static void main(String[] args) {
        Greeting greet=()->System.out.println("some text");
        greet.sayHello();//some text
        }


    @FunctionalInterface//not mandatory
    interface Greeting {
        void sayHello();  // exactly one abstract method
    }


//    @FunctionalInterface
//    interface Broken {
//        void doSomething();
//        void doAnother(); // ❌ More than one abstract method = NOT functional
//    }

}
