package zzRough;

import org.openqa.selenium.remote.http.UrlTemplate;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class R3_Regex {

    public static void main(String[] args) {


        String str="Sumit Raut";
        String ptrn="t";
        Pattern ptr=Pattern.compile(ptrn);//what pattern
        Matcher mtchr=ptr.matcher(str);//in what string
        int count=0;
        while(mtchr.find()){
             count++;
        }
        System.out.println(count);
    }




    @Test
    public void rough(){
      String s="Sumit Raut";
      String pattern="t";

      Pattern p=Pattern.compile(pattern);
      Matcher m= p.matcher(s);
      int count=0;
      while (m.find()){
          System.out.println(m.start() +" "+m.end());
          count++;
      }
        System.out.println(count);
//        4 5
//        9 10

        //2


    }
}
