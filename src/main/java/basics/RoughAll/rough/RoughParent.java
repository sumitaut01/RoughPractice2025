package basics.RoughAll;

/*

OOPs concepts how its implemented in the automation scripts
framework management- scaling, reusable components

page object pattern
Final, finalise, finally---
Static keyword---
Waits used in selenium
Abstract and interface
Collections:
Concurrent HashMap
Learn about other collections also like list array and all


Approach of test automation framework

All git commands
Diff between git fetch and git pull

Multiple and multilevel inheritance
Threads
Checked and unchecked exception


Overloading vs overriding
Regular expressions
Access modifiers
 */
public class RoughParent {
   static int counter=1;

   private void private_Method(){
       System.out.println("this is private method");
   }

    public  void  general_Method(){
        System.out.println("this is general_Method in Rough");

    }
    public int sum_original_two(int x,int y){
       return x+y;
    }



    //notice non primitive integer
    public Number sum_original_two(Integer x,Integer y){
        return x+y;
    }

    public int sum_original_three(int x,int y,int z){
        return x+y+z;
    }



}


class RoughChild extends RoughParent {

    //will error out as return type must be same or covariant
    //also scope can be widened and not reduced
//    @Override
//    public String  sum_original_two(int x,int y){
//        return "Sum is "+(x+y);
//    }


    //not allowed... int long are primitive.. covariance not allowed
//    public long sum_original_two(int x,int y){
//        return Long.parseLong(x+y);
//    }



    //notice non primitive integer

    //parent Number  Child Integer ==>Allowed
    //parent Integer  Child Number ==>NOT Allowed

    public Integer sum_original_two(Integer x,Integer y){
        return (Integer)(x+y);
    }


}
