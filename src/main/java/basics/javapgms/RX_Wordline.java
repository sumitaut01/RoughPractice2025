package basics.javapgms;

public class RX_Wordline {

    public static void main(String[] args) {


        String str = "American apocalyptic comedy film written, directed and produced by Seth Rogen and Evan Goldberg in their directorial debuts";

        int i=0, j=1;

        while(i<str.length()){
            System.out.println(str.substring(i,j));
            i++;
            j++;

        }

    }
}
