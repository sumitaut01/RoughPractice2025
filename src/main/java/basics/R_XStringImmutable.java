package basics;

//In Java, String is immutable, which means once a String object is created, it cannot be changed.
//        Any operation that seems to change a String actually creates a new object.


//Why Is String Immutable in Java?
//        Reason	Benefit
//        1. Security	Prevents hackers from changing file paths, class names, etc. (used in ClassLoader, File, URL, etc.)
//        2. Caching	Strings are cached in the String pool (reusable, saves memory)
//        3. Thread-safety	Immutable objects are inherently thread-safe
//        4. Hashing	Strings are commonly used in HashMap/Set — immutability ensures consistent hash codes

//Summary
//        Concept	String	StringBuilder
//        Immutable?	✅ Yes	❌ No
//        Thread-safe?	✅ Yes	❌ No (StringBuffer is)
//        Performance	Slower for changes	Faster for changes
//        Memory-efficient	✅ If reused (pooling)	Depends



//String Pool is Part of the Heap
//        🔹 The String pool (also called the intern pool) is a special area of the heap memory where string literals are stored and reused.
//        🧠 Explanation
//        Memory Area	Stores
//        Stack	Method calls, local variables (including references to objects)
//        Heap	All objects, including strings
//        String Pool	A special region within the heap for interned strings

public class R_XStringImmutable {


    public static void main(String[] args) {


        String s1="Sumit";//suit goes into shared string pool

        System.out.println(s1);//Sumit
        System.out.println(s1.concat("Raut"));//SumitRaut in heap. Raut in SCP
        System.out.println(s1);//Sumit //notice that string s1 did not chnage


        String a1="Sagar";
        String b1=a1; //sagar in string pool is referred/shared by b1

        System.out.println(a1==b1);//true coz they point to same object

        String c1=new String("Sagar");
        System.out.println(a1==c1);//false   as c1 a new object on heap


        System.out.println(a1.equals(c1));//true in string content comparison

    }
}
