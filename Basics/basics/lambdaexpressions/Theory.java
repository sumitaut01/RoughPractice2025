package basics.lambdaexpressions;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Theory {
    public static void main(String[] args) {
        //Without Lambda
        @FunctionalInterface
        interface i1 {
            void demo();
        }
        i1 i1 = new i1() {
            @Override
            public void demo() {
                System.out.println("test");
            }
        };

        i1.demo();//test


        //With Lambda

       // i1 ii = data -> System.out.println(data);


        //consumer
        Consumer<String> con= string-> System.out.println(string);
        con.accept("love");//love

        //supplier
        Supplier<String> st=()-> "Sumit";
        System.out.println(st.get());//Sumit


        //predicate
        Predicate<Integer> isRight= n->n>2;
        System.out.println(isRight.test(1));//false
        System.out.println(isRight.test(4));//true




        //function
        Function<String,Integer> func= string->string.length();
        System.out.println(func.apply("sagar"));

        //bifunction

    }
}
