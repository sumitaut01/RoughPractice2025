package basics;

public class R14_GarbageCollector {
//    Garbage Collection (GC) is the process of automatically
//    identifying and removing objects from heap memory that are no longer used — to free up space and avoid memory leaks.

    Dummy obj=new Dummy();
    obj.name=null;

}

class Dummy{
   public String name="dummy";
}
