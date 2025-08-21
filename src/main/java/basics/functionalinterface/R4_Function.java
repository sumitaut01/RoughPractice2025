package basics.functionalinterface;


import java.util.function.Function;

//F	Function<T,R>	R apply(T t)	Transforms T → R	F = Function = Transforms
public class R4_Function {

    public static void main(String[] args) {

        Function<String,String> fun= s->s.toUpperCase();
        System.out.println(fun.apply("sumit"));//sumit

    }
}
