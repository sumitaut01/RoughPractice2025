package basics.RoughAll.rough;

public class RoughOOPs {

    public static void main(String[] args) {

        Child c=new Child(20);
        System.out.println(c.parentInt);//20


        System.out.println(c instanceof  markerDemo);//true


        System.out.println(c.childInt);//0
        System.out.println(c.parentInt);//20

    }
}

interface generic{


}

interface markerDemo{


}

class Parent{
    int parentInt;
    public int  m1(int num){
        return num;
    }
    public String  m1(String s){
        return s;
    }

    public String getValue(){
        return String.valueOf(parentInt);
    }

    public Parent( int parentInt){
        this.parentInt=parentInt;
    }

}



class Child extends Parent implements markerDemo{
    int childInt;

    public void setChildInt(int childInt){
        this.childInt=childInt;
    }
    public Child(int parentInt) {
        super(parentInt);
    }

    public void printData(){
        System.out.println(parentInt);
    }

    @Override
    public String getValue(){
        return String.valueOf(childInt);
    }

}
