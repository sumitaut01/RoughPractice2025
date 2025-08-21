package basics;

public class R14_GarbageCollector {
//    Garbage Collection (GC) is the process of automatically
//    identifying and removing objects from heap memory that are no longer used — to free up space and avoid memory leaks.

    public static void main(String[] args) {
        Dummy obj=new Dummy();
        System.out.println(obj.name);
        obj.name="sumit";
        System.out.println(obj.name);

        obj=null;
    }


}

class Dummy{
   public String name="dummy";
}
