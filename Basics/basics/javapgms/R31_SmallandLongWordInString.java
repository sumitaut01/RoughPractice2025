package basics.javapgms;

public class R31_SmallandLongWordInString {

    public static void main(String[] args) {

        String []str="this is amazing world".split(" ");
        String smallest=str[0];
        String longest=str[0];

        for(int i=0;i<str.length;i++){

            if(str[i].length()>longest.length()){
                longest=str[i];
            }

            if(str[i].length()<smallest.length()){
                smallest=str[i];
            }

        }

        System.out.println(smallest);//is
        System.out.println(longest);//amazing

    }
}
