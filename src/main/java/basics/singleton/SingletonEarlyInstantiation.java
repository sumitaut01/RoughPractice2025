package basics.singleton;

public class SingletonEarlyInstantiation {

    // Instance is created when the class is initialized
    private static final SingletonEarlyInstantiation instance =
            new SingletonEarlyInstantiation();

    // Private constructor
    private SingletonEarlyInstantiation() {
    }

    // Global access point
    public static SingletonEarlyInstantiation getInstance() {
        return instance;
    }
}


/*
Lazy  → create object inside getInstance()
        Early → create object while declaring instance
 */