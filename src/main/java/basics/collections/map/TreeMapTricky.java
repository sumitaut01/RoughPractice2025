package basics.collections.map;

import java.util.TreeMap;

public class TreeMapTricky {


    public static void main(String[] args) {


        //   1. Duplicate Keys Without Looking Duplicate
        TreeMap<String, Integer> map = new TreeMap<>(
                (a, b) -> a.length() - b.length()
        );

        map.put("cat", 1);
        map.put("dog", 2);
        map.put("lion", 3);


        System.out.println(map);
//🤔 What most people say:
        //  {cat=1, dog=2, lion=3}
//✅ Actual thinking:
        //          "cat" (3), "dog" (3) → comparator returns 0
        //  So "dog" replaces "cat"
        //      ✅Output:
        //  {cat=2, lion=3}

//👉 Key stays "cat", value becomes 2
        System.out.println(map);
    }
}



