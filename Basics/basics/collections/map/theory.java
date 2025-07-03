package basics.collections.map;

public class theory {
}

//Hashtable — Legacy Thread-Safe Map
//Hashtable extends Dictionary<K, V>
//
//It is a synchronized, thread-safe hash-based map
//
//Introduced before Map<K,V> and later retrofitted to implement it
//
//java
//Copy
//Edit
//public class Hashtable<K, V> extends Dictionary<K, V> implements Map<K, V>
//🛠️ Characteristics of Hashtable:
//Feature	Details
//Thread-safe?	✅ Yes (uses synchronized methods)
//Allows null keys/values?	❌ No null keys or values
//Performance	Slower than HashMap (due to locks)
//Legacy?	✅ Yes, replaced by ConcurrentHashMap for modern use
//Synchronized	Entire methods are synchronized (coarse-grained)
//
//🧠 Where They Stand in the Hierarchy
//mathematica
//Copy
//Edit
//                   Object
//                     |
//              Dictionary<K, V>   (Legacy)
//                     |
//                Hashtable<K, V>  (Legacy)
//                     |
//      -------------------------------
//      |                             |
//  Implements                     Extends
//     ↓                               ↓
// Map<K, V> --------------------> AbstractMap<K, V>
//                                  ↑
//                           HashMap<K, V>
//Hashtable implements Map, so it can be used wherever a Map is expected
//
//But it’s a legacy class, and modern code uses:
//
//HashMap (not thread-safe)
//
//ConcurrentHashMap (thread-safe)
