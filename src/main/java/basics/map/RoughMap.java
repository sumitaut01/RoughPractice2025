package basics.map;

import io.reactivex.rxjava3.internal.schedulers.SchedulerMultiWorkerSupport;

import java.util.HashMap;

public class RoughMap {

    public static void main(String[] args) {

        HashMap<String,String> chm=new HashMap<>();
        chm.put("name", "sumit");
        chm.put("college", "kits");
        System.out.println(chm);
    }
}
