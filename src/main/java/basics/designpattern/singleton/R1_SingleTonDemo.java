package basics.designpattern.singleton;
public class R1_SingleTonDemo {
    private static R1_SingleTonDemo singleTonDemo;
    private R1_SingleTonDemo() {
    }

    //notice that we have used synchronized as it will prevent below problem
    //If two threads call getSingleTonDemo() at the same time when singleTonDemo == null,
    //they could both create separate instances momentarily.
    public static synchronized R1_SingleTonDemo getSingleTonDemo() {
        if (singleTonDemo == null) {
            singleTonDemo = new R1_SingleTonDemo();
        }
        return singleTonDemo;
    }
    //
    //Option 2: Double-checked locking (better)
    public static R1_SingleTonDemo getSingleTonDemo_DoubleChecked() {
        if (singleTonDemo == null) {
            synchronized (R1_SingleTonDemo.class) {
                if (singleTonDemo == null) {
                    singleTonDemo = new R1_SingleTonDemo();
                }
            }
        }
        return singleTonDemo;
    }
//✅ Thread-safe
//✅ Lazy initialization
//✅ Efficient


    //Option 3: Eager initialization (simplest)
    //public class SingleTonDemo {
    //    private static final SingleTonDemo INSTANCE = new SingleTonDemo();
    //    private SingleTonDemo() {}
    //    public static SingleTonDemo getInstance() {
    //        return INSTANCE;
    //    }
    //}
    //✅ Thread-safe (created when class loads)
    //❌ Always initialized, even if never used.

//Option 4: Using enum (modern & safest)
//public enum Singleton {
//    INSTANCE;
//}
//✅ Thread-safe
//✅ Serialization-safe
//✅ Simplest possible singleton form in Java.

    public static void main(String[] args) {

        System.out.println(getSingleTonDemo().hashCode());
        System.out.println(getSingleTonDemo().hashCode());

        System.out.println(System.identityHashCode(getSingleTonDemo()));
        System.out.println(System.identityHashCode(getSingleTonDemo()));

        //2104457164
        //2104457164
        //2104457164
        //2104457164
    }
//✅ Summary
//Approach	Lazy?	Thread-safe?	Recommended?
//Basic (yours)	✅ Yes	❌ No	Only for single-threaded
//synchronized	✅ Yes	✅ Yes	Simpler, slower
//Double-checked	✅ Yes	✅ Yes	👍 Best for performance
//Eager	❌ No	✅ Yes	For small lightweight singletons
//Enum	❌ No	✅ Yes	👍 Modern, safest (JVM handles it)
//
//In short:
//
//✅ Your class is a Singleton (works fine in single-threaded programs).
//⚠️ For production or multi-threaded code, prefer double-checked locking or an enum Singleton.

}
