package basics.advancedcollections;


import java.util.Iterator;

public class CopyOnWriteArrayList {

    public static void main(String[] args) {


        java.util.concurrent.CopyOnWriteArrayList<Integer> lst=new java.util.concurrent.CopyOnWriteArrayList<Integer>();

        System.out.println("Before Adding Data ");
        System.out.println(lst);
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        System.out.println("After Adding Data ");
        System.out.println(lst);

        Iterator<Integer> lsyIt=lst.iterator();
        while(lsyIt.hasNext()){
            System.out.println(lsyIt.next());
        }
        System.out.println("After Adding Data ");
        System.out.println(lst);

        //changing while iterating
        System.out.println("Before Changing");
        System.out.println(lst);
        Iterator<Integer> lsyIt2=lst.iterator();
        while(lsyIt2.hasNext()){
            System.out.println(lsyIt2.next());
            lst.add(lst.size()+1);
        }

        System.out.println("After Changing");
        System.out.println(lst);
    }


}
