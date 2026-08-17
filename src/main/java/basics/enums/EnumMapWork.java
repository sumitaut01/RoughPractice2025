package basics.enums;

import java.util.EnumMap;

public class EnumMapWork {

    public static void main(String[] args) {
        enum Day {
            MONDAY, TUESDAY, WEDNESDAY
        }

        EnumMap<Day, String> schedule = new EnumMap<>(Day.class);

        schedule.put(Day.MONDAY, "Office");
        schedule.put(Day.TUESDAY, "Gym");
        System.out.println(schedule.get(Day.MONDAY));//Office


/*
Why not HashMap?

You could write:

Map<Day, String> schedule = new HashMap<>();

But EnumMap is better because:

1. Faster

Internally Java stores values in an array using enum ordinal.

MONDAY.ordinal()     // 0
TUESDAY.ordinal()    // 1

So lookup is almost:
array[0]
instead of hash calculations.

2. Less memory
No hash buckets, nodes, linked structures.
Just arrays.

3. Natural enum ordering
schedule.put(Day.WEDNESDAY, "WFH");
schedule.put(Day.MONDAY, "Office");
System.out.println(schedule);

Output:
{MONDAY=Office, WEDNESDAY=WFH}
Notice it follows enum declaration order.
 */
    }
}
