package basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rough2 {


    public static void main(String[] args) {

        String str = "sutmit";
        String ptrn = "t";


        Pattern p = Pattern.compile(ptrn);
        Matcher m = p.matcher(str);
        int count = 0;
        while (m.find()) {
            count++;
            System.out.println(count);
        }
    }
}
