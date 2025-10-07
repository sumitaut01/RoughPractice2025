package basics;

import com.google.common.collect.Maps;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class R20_StreamsMore {


    public static void main(String[] args) {

        List<String> myList=new ArrayList<String>();

        myList.add("Sumit");
        myList.add("Neha");
        myList.add("Amit");
        myList.add("Saswat");
        myList.add("Kapil");
        myList.add("Aabha");
        myList.add("Aastha");
        System.out.println(myList);

        Map<String,Integer> hm=new HashMap<>();
        hm.put("Sumit",39);
        hm.put("Neha", 36);
        hm.put("Amit", 41);
        hm.put("Saswat", 39);
        hm.put("KApil", 38);
        hm.put("Aabha", 21);
        hm.put("Aastha",16);
        System.out.println(hm);



        //1 Skip  Limit
        myList.stream().skip(2).limit(2);
        //[Sumit, Neha, Amit, Saswat, Kapil, Aabha, Aastha]

        myList.stream().skip(2).limit(2).forEach(System.out::println);
        //Amit
        //Saswat

        System.out.println("----");
        //2 Sorted
        myList.stream().sorted().forEach(System.out::println);
//        Aabha
//                Aastha
//        Amit
//                Kapil
//        Neha
//                Saswat
//        Sumit
        System.out.println("----");
        //reverse sorting..
        myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
        //Sumit
        //Saswat
        //Neha
        //Kapil
        //Amit
        //Aastha
        //Aabha


        System.out.println(myList.add("Sumit"));
        System.out.println(myList); //[Sumit, Neha, Amit, Saswat, Kapil, Aabha, Aastha, Sumit]

        //distinct
        myList.stream().distinct().forEach(System.out::println);
        //Sumit
        //Neha
        //Amit
        //Saswat
        //Kapil
        //Aabha
        //Aastha

        //filter
        myList.stream().filter(s->s.startsWith("S")).forEach(System.out::println);
        //Sumit
        //Saswat
        //Sumit



        //map
        myList.stream().filter(s->s.startsWith("S")).map(s->s.toUpperCase()).forEach(System.out::println);
        //SUMIT
        //SASWAT
        //SUMIT

        //map with function
        System.out.println("-------");
        Function<String,String> func=a->a.toUpperCase();
        myList.stream().map(func).forEach(System.out::println);
        //SUMIT
        //NEHA
        //AMIT
        //SASWAT
        //KAPIL
        //AABHA
        //AASTHA
        //SUMIT

        //reduce
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        int sum = nums.stream().reduce(0, Integer::sum);
        System.out.println(sum); // 10


        //..group by name
        List<String> names = Arrays.asList("Sumit", "Neha", "Amit", "Raj");
        Map<Integer, List<String>> grouped =
                names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(grouped);//{3=[Raj], 4=[Neha, Amit], 5=[Sumit]}


       // Example 2: Group by first letter
        Map<Character, List<String>> groupedByFirstChar =
                names.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(groupedByFirstChar);  //{A=[Amit], R=[Raj], S=[Sumit], N=[Neha]}


//✅ Output:

     //   {N=[Neha], S=[Sumit], A=[Amit], R=[Raj]}
      //  Example 3: Group + Count
        Map<Integer, Long> countByLength =
                names.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));

        System.out.println(countByLength);


//✅ Output:

      //  {3=1, 4=2, 5=1}



       // Step 7: Joining Strings
        List<String> words = Arrays.asList("Java", "Stream", "API");
        String joined = words.stream().collect(Collectors.joining(" - "));
        System.out.println(joined); // Java - Stream - API


        //list to map
       Map<String,Integer> hmx= words.stream().collect(Collectors.toMap(s ->s, s->s.length()));
        System.out.println(hmx);//{Java=4, Stream=6, API=3}






    }
}
