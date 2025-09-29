package basics;

public class OverRidingCovarintObject1 {

    public static void main(String[] args) {
        Parent p=new Child();
        p.Method1(5);//From Child
       // From Parent char
        //From Parent Object

        p.Method2("Name");
    }


}



class Parent {
    public Number Method1(Number o) {
        System.out.println("From Parent char");
        return o;
    }


    public Object Method2(Object o) {
        System.out.println("From Parent Object");
        return o;
    }


}





class Child extends  Parent{
    public Integer Method1(Integer s) {
        System.out.println("From Child ");
        return s;
    }

    public String Method2(String o) {
        System.out.println("From Child String");
        return o;
    }

}