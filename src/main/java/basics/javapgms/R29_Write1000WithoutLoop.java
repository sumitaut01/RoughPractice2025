package basics.javapgms;

public class R29_Write1000WithoutLoop {

    public static void main(String[] args) {


        print(5);


    }


    public  static void  print(int n){
        if(n>0){
            System.out.println("something"+n);
            print(n-1);
        }
    }

}
