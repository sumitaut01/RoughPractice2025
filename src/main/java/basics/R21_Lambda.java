package basics;

public class R21_Lambda {

    public static void main(String[] args) {
        demo d=a-> "Welcome "+a;
        System.out.println(d.run("Sumit")); //Welcome Sumit

        demovoid d2=a-> System.out.println(a);
        d2.run("this is void function with sout"); //this is void function with sout


    }

    @FunctionalInterface
    interface demo{
        String run(String str);
    }


    @FunctionalInterface
    interface demovoid{
        void run(String str);
    }
}
