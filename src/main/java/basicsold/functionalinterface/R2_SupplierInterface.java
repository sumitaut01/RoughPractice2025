package basicsold.functionalinterface;


import java.util.function.Supplier;

//        Supplier<T>	T get()	Returns value, takes nothing
public class R2_SupplierInterface {

    public static void main(String[] args) {
        Supplier<String> str=()-> "this from supplier";
        System.out.println(str.get());//this from supplier

    }


}
