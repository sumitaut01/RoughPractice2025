package basics.singleton;

public class SingletonLazyInstantiation {

    private static volatile SingletonLazyInstantiation instance;

    // Private constructor
    private SingletonLazyInstantiation() {
    }

    // Global access point
    public static SingletonLazyInstantiation getInstance() {

        if (instance == null) {

            synchronized (SingletonLazyInstantiation.class) {

                if (instance == null) {
                    instance = new SingletonLazyInstantiation();
                }
            }
        }

        return instance;
    }
}

/*

Key points: private constructor + static instance + getInstance() + volatile + double-checked locking.

 */