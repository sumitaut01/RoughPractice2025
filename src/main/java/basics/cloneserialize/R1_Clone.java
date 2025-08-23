package basics.cloneserialize;

import java.util.HashMap;

public class R1_Clone {

    public static void main(String[] args) {


        //public class HashMap<K,V> extends AbstractMap<K,V>
        //    implements Map<K,V>, Cloneable, Serializable {
        //because of Cloneable market interface ,it's possible

        HashMap<String ,String> map1=new HashMap<>();

        map1.put("firstName", "Sumit");
        map1.put("lastName", "Raut");
        System.out.println(map1);//{firstName=Sumit, lastName=Raut}

        HashMap<String ,String>  map2= (HashMap<String, String>) map1.clone();
        System.out.println(map2);//{firstName=Sumit, lastName=Raut}
        map2.put("firstName", "Amit");



        System.out.println(map1);//{firstName=Sumit, lastName=Raut}
        System.out.println(map2);//{firstName=Amit, lastName=Raut}

    }
}
