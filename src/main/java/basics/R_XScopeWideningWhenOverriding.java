package basics;

public class R_XScopeWideningWhenOverriding {



}



class Human{
 public void method1(){
     System.out.println("Some impl");
 }
}


class Male extends Human{

//    @Override
//    protected void method1(){
//        //'method1()' in 'basics.Male' clashes with 'method1()' in 'basics.Human';
//        // attempting to assign weaker access privileges ('protected'); was 'public'
//        System.out.println("Some impl");
//    }
}