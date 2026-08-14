package basics.RoughAll.rough;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Streams {


    public static void main(String[] args) {


        Supplier<String> ss=()->"sumit";
        System.out.println(ss.get());

        Predicate<String> pp=s->s.length()>5;
        System.out.println(pp.test("something"));


        Function<String,Integer> yy= s->s.length();
        yy.apply("sumit");






    }
}
