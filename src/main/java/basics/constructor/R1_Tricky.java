package basics.constructor;

public class R1_Tricky {
    int age;
 //if we have params constructor, then default constructor is not provided while object creation

//    R1_Tricky(){
//        this.age=20;
//        System.out.println("Inside Default Constructor");
//    }

    R1_Tricky(int age){
        this.age=age;
        System.out.println("Inside Params Constructor");
    }

    public static void main(String[] args) {

       // R1_Tricky r1=new R1_Tricky();  // this will compile error as it will say matching constructor missing

    }
}
