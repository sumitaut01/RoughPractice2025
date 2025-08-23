package basics;

public class RX_toString {

    public static void main(String[] args) {

        Something something=new Something(12,"Sumit");
        System.out.println(something.toString());
    }
}

    class Something{
        int someval1;
        String someStringval2;

        public Something(int someval1, String someStringval2) {
            this.someval1 = someval1;
            this.someStringval2 = someStringval2;
        }

        @Override
        public String toString(){
            return "values from class Something "+ someval1 +" "+someStringval2;

        }


    }

