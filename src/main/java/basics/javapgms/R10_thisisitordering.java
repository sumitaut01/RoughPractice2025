package basics.javapgms;

import java.util.Arrays;

public class R10_thisisitordering {

    public static void main(String[] args) {

        String str="this is sumit";
        // 1 lets try linear search


        String []aStr=str.split(" ");
        for(int i=0;i<aStr.length-1;i++){
            for (int j=1;j<aStr.length;j++){
                if(aStr[i].length()>aStr[j].length()){
                    String temp=aStr[i];
                    aStr[i]=aStr[j];
                    aStr[j]=temp;
                }
            }
        }

        System.out.println(Arrays.toString(aStr));//[is, this, sumit]





    }
}
