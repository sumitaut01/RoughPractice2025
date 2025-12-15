package basics.javapgms;

import org.testng.annotations.Test;

import java.util.HashMap;

public class RX_CoforgePattern {

    public static void main(String[] args) {

        String str = "aabbccadd";

        System.out.println(str);
        int count;
        for (int i = 0; i < str.length(); i = i + count) {
            count = 0;
            for (int j = i; j < str.length(); j++) {
                if (String.valueOf(str.charAt(j)).equals(String.valueOf(str.charAt(i)))) {
                    count++;
                }
                else{

                    break;
                }
            }
            System.out.print(String.valueOf(str.charAt(i)) + count);
        }
    }


//a2b2c2a1d2



    @Test
    public void Rough(){
        String str = "aabbccadd";
        int count;
        for(int i=0;i<str.length();i=i+count){
            count=0;
            for(int j=i;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    count++;
                }
                else{
                    break;
                }
            }
            System.out.println(str.charAt(i)+""+count);

        }


    }

}