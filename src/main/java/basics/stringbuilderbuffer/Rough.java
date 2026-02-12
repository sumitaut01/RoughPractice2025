package basics.stringbuilderbuffer;

public class Rough {

    public static void main(String[] args) {

        StringBuilder sb=new StringBuilder();
        sb.append("s");
        sb.insert(0,"x");
        System.out.println(sb);//xs
        System.out.println(sb.delete(0, 1));//s
        System.out.println(sb.delete(0, 1)); //blank

    }
}
