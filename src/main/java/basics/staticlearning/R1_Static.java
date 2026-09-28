package basics.staticlearning;

public class R1_Static {


    static int  R1_static=5;

    static R1_Static instance=new R1_Static();
    public static void main(String[] args) {
        System.out.println(R1_static);
    }

    public static R1_Static getInstance(){
        return instance;
        }

    }


