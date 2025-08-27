package basics;

import java.util.function.Function;
import java.util.function.Supplier;

public class R_XShortHand {

    public static void main(String[] args) {

     //   Supplier<ShortHandWork> supp=ShortHandWork::new;//supplier cant work with argument constructor
// public ShortHandWork(String name){
//        this.name=name;
//    }


        Function<String,ShortHandWork> func=ShortHandWork::new;
        ShortHandWork shortHandWork=func.apply("Sumit");



    }
}


class ShortHandWork{
    static String  staticField;
    String name;
    public ShortHandWork(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}


class Timepass{

    static String  staticField;
    String name;

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}