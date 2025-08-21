package basics;

public class R3_Class {

    int count;
    static int  staticCount;
    public  void  method1(){
        count++;
        System.out.println("count is "+count);

    }

    public  void  method2(){
         count++;
        System.out.println("count is "+count);
    }

    public  static void  method3(){
        //staticCount = count++;//not allowed. static field from non static context
        staticCount++;
        System.out.println("staticCount is "+staticCount);
    }


    public static void main(String[] args) {
        R3_Class r3Class=new R3_Class();
        r3Class.method1();//1
        r3Class.method1();//2
        r3Class.method2();//3
        R3_Class.method3();//1
        R3_Class.method3();//2

        R3_Class obj2=new R3_Class();
        obj2.method1();//1
        obj2.method2();//2
        R3_Class.method3();// 3 increments ststic one

    }

}
