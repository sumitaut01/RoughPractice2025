package basics.javapgms;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class R_XStringContainsDigit {


    public static void main(String[] args) {

        String str="nacre123";
        for(Character ch:str.toCharArray()){
           if(ch>='0' && ch<='9'){
               System.out.println(ch);
           }
        }
    }



    @Test
    public void Test(){
        String str="nacre123";
        Pattern p=Pattern.compile("[0-9]+");
        Matcher m=p.matcher(str);
        boolean bFind=false;
        while(m.find()){
            bFind=true;
            System.out.println(bFind);
            System.out.println(m.group());
        }
    }
}
