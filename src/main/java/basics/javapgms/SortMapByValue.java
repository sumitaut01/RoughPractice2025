package basics.javapgms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortMapByValue {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        map.put("api", 3);
        map.put("qa", 1);
        map.put("dev", 2);


        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        for (Entry<String, Integer> e : list)
            System.out.println(e.getKey() + " → " + e.getValue());
    }
    }

//qa → 1
//dev → 2
//api → 3