package basics.javapgms.citi_preparation;

import java.util.concurrent.ConcurrentHashMap;

public class Constructor_Question {


    public  Constructor_Question(){
        System.out.println("Default");
    }

    public  Constructor_Question(int x){
        System.out.println("parameter");
    }

    public  Constructor_Question(int x,int y){
        this(5);
        System.out.println("parameter with 2 args");
    }

    public static void main(String[] args) {

        Constructor_Question cq=new Constructor_Question(5);
        //parameter

        Constructor_Question cq2=new Constructor_Question(5,6);
        //parameter
        //parameter with 2 args

    }

}
