package basics.javapgms;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;

public class R_36MaxOccurence {

    public static void main(String[] args) {

        String st = "Learning a little each dayaddsup";

        int[] data = new int[256];
        for (int i = 0; i < st.length(); i++) {
            data[st.charAt(i)]++;
        }

        // Find the character with the maximum occurrence
        int max = 0;
        char maxChar = ' ';

        // Iterate through the entire frequency array (256 characters)
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
                maxChar = (char) i;
            }
        }

        System.out.println("The maximum occurrence is: " + max);
        System.out.println("The character with maximum occurrence is: " + maxChar);//a

    }


    @Test
    public void rough(){
        String st = "Learning a little each dayaddsupxxxxxx";

        HashMap<Character,Integer> hm=new HashMap<>();
        for(Character c:st.toCharArray()){
          hm.put(c, hm.getOrDefault(c, 0)+1);
        }

        var result=hm.entrySet();
        int count=0;
        char c=' ';
        for( var x: result){
          if(x.getValue()>count){
           count=x.getValue();
           c=x.getKey();
          }
        }

        System.out.println(c +" "+count); //x 6
    }







}