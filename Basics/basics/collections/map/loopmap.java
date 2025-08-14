package basics.collections.map;

public class loopmap {
}

//Suppose You Have:
//Map<String, Integer> map = new HashMap<>();
//map.put("Apple", 10);
//map.put("Banana", 20);
//map.put("Mango", 30);
//✅ 1. Loop through Keys Only
//for (String key : map.keySet()) {
//    System.out.println("Key: " + key);
//}
//map.keySet() returns a Set<K> of keys.
//
//✅ 2. Loop through Values Only
//java
//Copy
//Edit
//for (Integer value : map.values()) {
//    System.out.println("Value: " + value);
//}
//map.values() returns a Collection<V> of all values.
//
//✅ 3. Loop through Key–Value Pairs (Entry Set)
//java
//Copy
//Edit
//for (Map.Entry<String, Integer> entry : map.entrySet()) {
//    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//}
//Most common and efficient method.
//
//✅ 4. Using Lambda + forEach()
//map.forEach((key, value) -> System.out.println(key + " => " + value));
//Short and clean. Great for functional style.
//✅ 5. Using Iterator (when you need to remove entries)

//Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
//while (iterator.hasNext()) {
//    Map.Entry<String, Integer> entry = iterator.next();
//    System.out.println(entry.getKey() + " = " + entry.getValue());
//
//    // Safe removal during iteration
//    if (entry.getKey().equals("Banana")) {
//        iterator.remove();
//    }
//}
//✅ 6. Java 8 Streams
//map.entrySet()
//   .stream()
//   .filter(e -> e.getValue() > 10)
//   .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
//Useful for filtering, sorting, mapping, etc.
//
//📦 Summary Table
//Loop Type	Access	Code Snippet
//Keys	Only keys	for (K key : map.keySet())
//Values	Only values	for (V val : map.values())
//Key-Value	Both	for (Map.Entry<K,V> e : map.entrySet())
//Lambda	Both	map.forEach((k,v) -> {...})
//Iterator	Both + delete	Iterator<Map.Entry<K,V>>
//Stream API	Both + filter	map.entrySet().stream()...