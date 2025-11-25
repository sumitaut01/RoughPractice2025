package demo.threadlocal;

public class Parent {

    private static final ThreadLocal<String> common = new ThreadLocal<>();

    public static String getCommon() {
        return common.get();
    }

    public static void setCommon(String value) {
        common.set(value);
    }

    public static void removeCommon() {
        common.remove(); // good practice to avoid memory leaks
    }
}
