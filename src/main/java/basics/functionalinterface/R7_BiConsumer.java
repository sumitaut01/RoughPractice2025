package basics.functionalinterface;

import java.util.function.BiConsumer;

public class R7_BiConsumer {

//provide two inputs , return nothing
    public static void main(String[] args) {
        BiConsumer<String,String> bc= (a,b)-> System.out.println(a+b);
        bc.accept("Sumit", "Raut");//SumitRaut
    }
}
