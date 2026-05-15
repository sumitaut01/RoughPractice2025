package basics.collections.map;

import org.testng.annotations.Test;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;

public class EnumMapDemo {
    //EnumMap is a Map implementation where keys must be enum constants.

    //EnumMap is better when keys are enums 👇
    //
    //Feature	EnumMap	HashMap
    //Performance	🚀 Faster	Slower
    //Memory	🟢 Less	More
    //Key type	Only enum	Any object
    //Ordering	Enum order	No guarantee


    public static void main(String[] args) {
        Map<Day, String> schedule = new EnumMap<>(Day.class);
        schedule.put(Day.MONDAY, "Gym");
        schedule.put(Day.TUESDAY, "Office");
        schedule.put(Day.WEDNESDAY, "Work From Home");

        System.out.println(schedule); //{TUESDAY=Office, MONDAY=Gym, WEDNESDAY=Work From Home}


    }



    @Test
    public void demo(){

        enum Operation {
            ADD, SUBTRACT
        }

        EnumMap<Operation, BiFunction<Integer, Integer, Integer>> ops = new EnumMap<>(Operation.class);

        ops.put(Operation.ADD, (a, b) -> a + b);
        ops.put(Operation.SUBTRACT, (a, b) -> a - b);
        System.out.println(ops.get(Operation.ADD).apply(5, 3)); // 8
    }


}

enum Day {
     TUESDAY,
             MONDAY,
    WEDNESDAY
}


//10. When NOT to use EnumMap
//When keys are not enums
//When keys are dynamic (user input, strings, IDs)
//When you don’t know keys at compile time
//✅ Final Summary
//Concept	Answer
//What	Map for enum keys
//Internal	Array (no hashing)
//Performance	Faster than HashMap
//Ordering	Enum order
//Null key	❌ Not allowed
//Use case	Fixed set of constants