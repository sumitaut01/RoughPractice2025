package basics.collections;


//just rough work

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Rough {


    @Test
    public void List() {
        List<String> lstr = new ArrayList<>();
        lstr.add("sumit");
        lstr.add("neha");
        lstr.add("raj");


        //1
        for (String s : lstr) {
            System.out.println(s);
        }

        //2
        lstr.forEach(s -> System.out.println(s));
        //sumit
        //neha
        //raj


        //3
        System.out.println("reverse sorting");
        System.out.println(lstr.stream().sorted(Collections.reverseOrder()));// java.util.stream.SortedOps$OfRef@5fdef03a
        System.out.println(lstr.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()));//[sumit, raj, neha]

        //4
        System.out.println("normal sorting");
        Collections.sort(lstr);
        System.out.println(lstr);//[neha, raj, sumit]


        //5

    }


    @Test
    public void HashMapDemo() {


        Map<String, String> hm = new HashMap<>();
        hm.put("Name", "Sumit");
        hm.put("Branch", "IT");
        hm.put("Year", "2004");


        //1
        System.out.println("Normal sout");
        System.out.println(hm);

        //2
        System.out.println("viafor each");
        hm.keySet().stream().forEach(k -> System.out.println(k + "===>" + hm.get(k)));


        //3
        System.out.println("via entry set");
        for (Map.Entry<String, String> s : hm.entrySet()) {

            System.out.println(s.getKey());
            System.out.println(s.getValue());
        }

    }

    @Test
    public void SetDemo() {

        System.out.println("via for ss");
        Set<String> ss = new HashSet<>();
        ss.add("Sumit");
        ss.add("Amit");
        ss.add("Neha");

        //1
        System.out.println(ss);//[Neha, Amit, Sumit]

        //2
        System.out.println("via for each");
        for (String s : ss) {
            System.out.println(s);
        }


        //3 via stream
        ss.stream().forEach(s -> System.out.println(s));

        //4
        //sort
        System.out.println(ss.stream().sorted().collect(Collectors.toList()));

    }


    @Test
    public void ComparatorDemo(){
        Comparator<Data> dName= (a,b)-> a.name.compareTo(b.name);
        Data[] arr={new Data(222,"Zagar"),new Data(20,"Asmit")};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));


        Arrays.sort(arr,dName);
        System.out.println(Arrays.toString(arr));//[Data:value20 data:nameAsmit, Data:value10 data:nameZagar]

     //[value222 nameZagar, value20 nameAsmit] //as inserted
        //[value20 nameAsmit, value222 nameZagar]  //value sorting natural
        //[value20 nameAsmit, value222 nameZagar] // name sorting s in comparator
    }




    @Test
    public void ArrayListDemo(){

        ArrayList<String> st=new ArrayList<>();
        st.add("sumit");
        st.add("neha");
        st.add("amit");
        st.add("sumit");


        //remove duplicates
        System.out.println("before removing");
        System.out.println(st);
        HashSet<String> hs=new HashSet<>();
        for(int i=0;i<st.size();i++) {
            if (hs.add(st.get(i))) {
                hs.add(st.get(i));
            } else {
                st.remove(i);
            }
        }
        System.out.println("after  removing");
        System.out.println(st);



        st.forEach(s-> System.out.println(s));
        System.out.println("Iterating------");
        Iterator<String> it=st.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }


    @Test
    public void LinkedList(){

        List<String> str=new LinkedList<>();
        str.addLast("Last");
        str.add("sumit");
        str.add("sumit");
        str.add("Amit");
        str.addFirst("First");
        System.out.println(str);

    }


    @Test
    public void TreeMapDemo(){

        System.out.println();
        TreeMap<String,String> tm=new TreeMap<>();
        tm.put("name", "Sumit");
        tm.put("lastname", "Raut");
        tm.put("zone", "north");
        System.out.println(tm);





     //   Comparable<String> cc= ((a,b)-> Integer.compare(a);

    }








}


class Data implements Comparable<Data> {
    int value;
    String name;

    public Data(int value,String name){
        this.value=value;
        this.name=name;
    }
    @Override
    public String toString() {
        return "value" + value + " name" + name;
    }
    @Override
    public int compareTo(Data o) {
        return (this.value-o.value);
    }
}