package basics.javapgms;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseNumber {
    public static void main(String[] args) {
        int num = 12345;

        String s = String.valueOf(num);
        List<String> list = Arrays.asList(s.split(""));

        Collections.reverse(list);

        String result = String.join("", list);
        System.out.println(result); // 54321
    }




    @Test
    public void Rough(){
      int num=5432;

      int rev=0;
      while(num>0){
          rev=rev*10 + num%10;
          num=num/10;
      }
        System.out.println(rev);//2345

    }
}
