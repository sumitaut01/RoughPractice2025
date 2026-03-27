package basics.lambdaexpressions;

import org.apache.http.io.SessionOutputBuffer;
import org.testng.annotations.Test;

import java.util.function.*;

public class RoughRefresher {
    public static void main(String[] args) {
        Supplier<String> st=()-> "Supplies String";
        System.out.println(st.get());//Supplies String


        Consumer<String> cs= s-> System.out.println(s);
        cs.accept("provided string");//provided string


        Predicate<String> ps= s->s.startsWith("S");

        System.out.println(ps.test("Sumit"));//true

        Function<String,Integer> func= s->s.length();
        System.out.println(func.apply("Sumit"));//5

        BiFunction<String,Integer,String> bifunc=(a,b)->a+b;
        System.out.println(bifunc.apply("Sumit", 39));









    }



    @Test
    public void Rough(){

        Supplier<String> st=()->"this is it";
        System.out.println(st.get());//this isit




    }
}
