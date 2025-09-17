package basics.functionalinterface;

import java.util.function.Predicate;

public class R6_Predicate {

    public static void main(String[] args) {

        Predicate<String> prd=s->s.isEmpty();//true

        System.out.println(prd.test("nonempty"));//flase

    }
}
