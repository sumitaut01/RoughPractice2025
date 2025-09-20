package basics.javapgms;

import java.util.HashMap;
import java.util.HashSet;

public class R27_DuplicateWordsInString {

    public static void main(String[] args) {

        String st="this will have java selenium java selenium";

        String[] aSt=st.split(" ");

        HashSet<String> hs =new HashSet<String>();

        for(String s:aSt){
            if(!hs.add(s)){
                System.out.println(s);
            }
        }

        //java
        //selenium

    }
}
