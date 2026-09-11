package basics.collections.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> csh = new ConcurrentHashMap<>();
        csh.put("name", "sumit");
        csh.put("age", "35");

        // below differs from normal hashmap which accepts one null key
        csh.put(null, null);//null pointer exception
    }
}

//What is ConcurrentHashMap?
//ConcurrentHashMap<K, V> is part of java.util.concurrent.
//It's a thread-safe implementation of Map that allows high concurrency and non-blocking reads.
//
//✅ Use it when multiple threads need to access or modify a map concurrently.
//
//🔧 Key Features
//Feature	Description
//Thread-safe?	✅ Yes — no need to manually synchronize
//Locking behavior	Fine-grained locks on buckets (segments internally)
//Null keys/values?	❌ Not allowed (throws NullPointerException)
//Performance under concurrency	✅ Excellent
//Iteration	Weakly consistent — doesn’t throw ConcurrentModificationException
//Default concurrency level	Dynamic (not based on fixed segments since Java 8)
//
//⚙️ Internal Working (Simplified)
//Hashtable	ConcurrentHashMap
//Entire map is locked	Only part of map is locked (bucket or node)
//Synchronized methods	Uses synchronized blocks + CAS + Lock striping
//Slower under high threads	Scales well with multiple threads
//
//Java 8 onward, it uses a bucket-based array with Node<K,V> chains (or trees when needed), plus lock-free reads.