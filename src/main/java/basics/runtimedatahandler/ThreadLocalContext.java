package basics.runtimedatahandler;

import java.util.Map;
import java.util.HashMap;

public class ThreadLocalContext {

    private static final ThreadLocal<Map<String, Object>> contextMap =
            ThreadLocal.withInitial(HashMap::new);

    public static void set(String key, Object value) {
        contextMap.get().put(key, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return (T) contextMap.get().get(key);
    }

    public static void remove(String key) {
        contextMap.get().remove(key);
    }

    public static void clear() {
        contextMap.remove();
    }


    //option 2
    public static <T> T get(String key, Class<T> type) {
        Object value = contextMap.get().get(key);
        if (value == null) {
            return null;
        }
        if (!type.isInstance(value)) {
            throw new ClassCastException(
                    "Value for key '" + key + "' is of type " + value.getClass().getSimpleName()
                            + ", expected " + type.getSimpleName());
        }
        return type.cast(value);
    }


    public static void main(String[] args) {
        ThreadLocalContext.set("age", 25);
        Integer age = ThreadLocalContext.get("age");   // no cast needed at call site
        String name = ThreadLocalContext.get("name");
        /*
        This works because of generic type inference at the call site — the compiler infers T from the variable you're assigning to. The cast still happens internally (unchecked), so if you store a String and try to read it as Integer, you'll get a ClassCastException at the point of use, not inside get().
         */
        System.out.println(age);//25
        System.out.println(name);//null

        //option 2
        Integer age2 = ThreadLocalContext.get("age", Integer.class);



    }
}