package basics;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract  class R17_AbstractClass {
//    Can have both abstract and concrete methods
//    Cannot be instantiated (no new R17_AbstractClass())
//    May have constructors, fields, static methods
//    Used when classes share common code + contract
    R17_AbstractClass(String name){
        System.out.println("original name:"+name);
        R17_AbstractClass.name=name;
        System.out.println("original name:"+name);


        System.out.println("original vaue of a"+a);
        a=11;
        System.out.println("original vaue of a"+a);

    }
    static  String name="sagar";
    int a=10;
   abstract void am_print();
    void print(){
        System.out.println("non abstract method");
    }
}

class abstractimpl extends R17_AbstractClass {

    abstractimpl(String name) {
        super(name);
        System.out.println("inside  impl class constructor");
    }

    @Override
    void am_print() {
        System.out.println("abstract method implemented");
    }


    public static void main(String[] args) {
        R17_AbstractClass obj = new abstractimpl("sumit");
        obj.am_print();//abstract method implemented
        obj.print();//non abstract method


        abstractimpl new2=  new abstractimpl("neha");
        new2.am_print();
        new2.print();
    }
}

    //Example From Java
//    public abstract class AbstractMap<K,V> implements Map<K,V> {
//        /**
//         * Sole constructor.  (For invocation by subclass constructors, typically
//         * implicit.)
//         */
//        protected AbstractMap() {
//        }
//        public abstract Set<Entry<K, V>> entrySet();
//    }
//
//    public class HashMap<K,V> extends java.util.AbstractMap<K,V>
//            implements Map<K,V>, Cloneable, Serializable {
//}



