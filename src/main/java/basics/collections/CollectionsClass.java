package basics.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsClass {

    public static void main(String[] args) {

        List<String> alist=new ArrayList<>();

        alist.add("afirst");
        alist.add("bsecond");
        alist.add("bnth");

        System.out.println(alist);//[afirst, bsecond, bnth]

        //1
        Collections.reverse(alist);
        System.out.println(alist);//[bnth, bsecond, afirst]

        //
        Collections.sort(alist);
        System.out.println(alist);//[afirst, bnth, bsecond]

        //
        Collections.synchronizedCollection(alist);
        /*
        Returns a synchronized (thread-safe) collection backed by the specified collection. In order to guarantee serial access, it is critical that all access to the backing collection is accomplished through the returned collection.
         */
    }

}
