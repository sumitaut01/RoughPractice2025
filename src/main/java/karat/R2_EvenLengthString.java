package karat;

import java.util.Objects;

public class R2_EvenLengthString {

    public static void main(String[] args) {

        String s="this is spart and null";
        System.out.println(printEven(s));//this is null

    }


    public static String printEven(String s){
        Objects.requireNonNull(s);

        String [] arrsplitStr=s.split("\\s+");
        if(arrsplitStr.length==0) return "";

        String result="";

        for(int i=0;i<arrsplitStr.length;i++){
            if((arrsplitStr[i].length()%2)==0){
                System.out.print(result+arrsplitStr[i]+" ");
            }
        }
        return result;//
    }
}
