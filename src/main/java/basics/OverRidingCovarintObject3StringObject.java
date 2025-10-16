package basics;

public class OverRidingCovarintObject3StringObject {

    public static void main(String[] args) {
        ParentO p = new Strings();
        p.method1("some");//from child
    }
}



class ParentO{
    public Object method1(Object o){
        System.out.println("from Parent");
        return o;
    }
}

class Strings extends ParentO {

    public String method1(Object o) {
        System.out.println("from child");
        return (String) o;
    }


}
