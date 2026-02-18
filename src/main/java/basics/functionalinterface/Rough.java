package basics.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Rough {


    public static void main(String[] args) {

        fa ff=()->System.out.println("runn");
        ff.test();


        //supplier
        Supplier<String> st= ()->"Sumit";
        st.get();

        //Predicate
        Predicate<String> stc= stx->stx.isEmpty();
        stc.test("sumit");
        //function

        Function<String,Integer> fff= s->s.length();
        fff.apply("sumit");

        //map


        //consumer

        Consumer<String> dd= s-> System.out.println(s);
        dd.accept("sumit");


    }
}


interface  fa{
    void test();
}
