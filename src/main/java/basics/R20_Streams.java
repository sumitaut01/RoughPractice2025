package basics;

//A Stream in Java represents a sequence of elements that supports various operations to process data (like filtering, mapping, sorting, reducing) in a pipeline.
//        Works with collections like List, Set
//        Does not store data, just processes it
//        Can be parallel or sequential
//
//Stream Pipeline = 3 Stages
//        Stage	Examples
//        Source	stream(), Arrays.stream(), etc.
//        Intermediate Ops	filter(), map(), sorted()
//        Terminal Op	forEach(), collect(), reduce()

//Common Intermediate Operations
//        Method	Description
//        filter()	Filters elements based on a predicate
//        map()	Transforms elements
//        sorted()	Sorts the stream
//        distinct()	Removes duplicates
//        limit(n)	Truncates the stream to n elements
//        skip(n)	Skips the first n elements
//        peek()	For debugging (like sout inside stream)


//Common Terminal Operations
//        Method	Description
//        forEach()	Consumes elements
//        collect()	Reduces stream to a collection
//        reduce()	Aggregates elements into one
//        count()	Returns number of elements
//        anyMatch()	Checks if any element matches
//        allMatch()	Checks if all elements match
//        findFirst()	Gets the first element (Optional)

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class R20_Streams {
    public static void main(String[] args) {


        List<String> names = List.of("Sumit", "Sagar", "Ram", "Shyam");
        names.stream()
                .filter(name -> name.startsWith("S"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

//    Output:
//
//    nginx
//            Copy
//    Edit
//            SAGAR
//    SUMIT


        List<Integer> data = List.of(1,2,3,4,5,10,20);

        Integer result=data.stream().filter(x->x>5).map(x->x*10).reduce(0, Integer::sum);
        System.out.println(result);
    }



    @Test
    public void Rough(){


        List<MyClassXX> lst=new ArrayList<>();
        lst.add(new MyClassXX(20,"Sumit"));
        lst.add(new MyClassXX(40,"Amit"));
        Supplier<List<MyClassXX>> xx=()->lst;
        System.out.println(xx.get()); //[20 Sumit, 40 Amit]




        Supplier<MyClassXX> obj=MyClassXX::new; // with method reference

        Supplier<MyClassXX> obj2=()->new MyClassXX();//with lambda




    }




    @Test
    public void Rough3(){
        List<String> lData=List.of("sumit","amit","neha");
        List<String> data=lData.stream().map(s->s.toUpperCase()).filter(s->s.startsWith("S")).collect(Collectors.toList());
        System.out.println(data);
    }

    @Test
    public void Rough4(){

        //arrray list
        //linkedlist
        //

        //set hashset lhst

        //map hashmap //treemap


        //


    }
}


class MyClassXX{
    int age;
    String name;

    public MyClassXX(int age,String name){
        this.age=age;
        this.name=name;
    }

    public MyClassXX(){
    }
    @Override
    public String toString(){
        return  age +" "+name;
    }

}
