package basics.cloneserialize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class R1_Clone {

    public static void main(String[] args) {


        //public class HashMap<K,V> extends AbstractMap<K,V>
        //    implements Map<K,V>, Cloneable, Serializable {
        //because of Cloneable market interface ,it's possible to clone


        //Notice the behaviour when immutable and mutable objects are there
        //1 String is immutable


        HashMap<String ,String> map1=new HashMap<>();
        map1.put("firstName", "Sumit");
        map1.put("lastName", "Raut");
        System.out.println(map1);//{firstName=Sumit, lastName=Raut}

        HashMap<String ,String>  map2= (HashMap<String, String>) map1.clone();
        System.out.println(map2);//{firstName=Sumit, lastName=Raut}
        map2.put("firstName", "Amit");



        System.out.println(map1);//{firstName=Sumit, lastName=Raut}
        System.out.println(map2);//{firstName=Amit, lastName=Raut}


        //2

        Map<String, List<String>> original = new HashMap<>();
        original.put("fruits", new ArrayList<>(List.of("apple", "banana")));

        System.out.println(original);//{fruits=[apple, banana]}

        Map<String, List<String>> clone = new HashMap<>(original);
        clone.get("fruits").add("cherry");

        System.out.println(original.get("fruits")); // [apple, banana, cherry] 😱
//        Both maps still share the same inner List reference, so modifying that list affects both.
//
//                That’s what we call a shallow clone.



        //In short
        //
        //Structural changes in a cloned map (add/remove key) don’t affect the original.
        //
        //But if the map contains mutable objects (like lists, maps, or custom classes), changes inside those objects will reflect in both maps — unless you deep copy them.





    }
}
