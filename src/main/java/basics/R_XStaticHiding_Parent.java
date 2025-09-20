package basics;

public class R_XStaticHiding_Parent{
    public static int  sum(int x,int y){
        System.out.println("Parent called");
        return x+y;
    }
}


class R_XStaticHiding_Child extends  R_XStaticHiding_Parent {
    //@Override//Static methods cannot be annotated with @Override
    public static int  sum(int x,int y){
        System.out.println("Child called");
        return x+y;
    }
}

class Main{
    public static void main(String[] args) {

        R_XStaticHiding_Parent.sum(3, 4);
        R_XStaticHiding_Child.sum(3, 4);

        //Parent called
        //Child called
    }
}
