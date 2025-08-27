package zzRough;

import org.openqa.selenium.remote.http.UrlTemplate;

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
}
