package basics.functionalinterface;

import java.util.function.BiFunction;

//BiFunction<T, U, R> — Two inputs, one output
public class R5_BiFunction {
    public static void main(String[] args) {

        BiFunction<String,String,Integer> bf= (a,b)-> (a+b).length();
        System.out.println(bf.apply("sumit","neha"));//9
    }
}
