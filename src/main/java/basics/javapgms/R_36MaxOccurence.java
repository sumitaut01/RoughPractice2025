package basics.javapgms;

import org.testng.annotations.Test;

import java.util.Arrays;

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
        int [] data=new int[256];
        for(int i=0;i<st.length();i++){
            data[st.charAt(i)]++;
        }

        //then logic to print max from array










    }







}