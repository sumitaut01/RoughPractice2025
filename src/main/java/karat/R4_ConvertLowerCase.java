package karat;

import java.util.Objects;

public class R4_ConvertLowerCase {


    public static void main(String[] args) {

        Character ch=null;
        System.out.println(ch);
        System.out.println(Character.toLowerCase(ch));

        System.out.println(ch);


    }


    public static  char[] testCharacters(char[] inputChars){
        if(Objects.isNull(inputChars)){
            return null;
        } else if (inputChars.length==0) {
            return new char[]{};
        }
        for (int i=0;i< inputChars.length;i++){
            inputChars[i]=Character.toLowerCase(inputChars[i]);
        }
        return inputChars;
    }
}
