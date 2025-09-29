package zzRough;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rough {
    @Test
    public void Test1() {
        String str = " This is it";
        String ptn = "t";
        Pattern p = Pattern.compile(ptn);
        Matcher m = p.matcher(str.toLowerCase());
        int count = 0;
        while (m.find()) {
            count++;
        }
        System.out.println(count);
    }

    @Test
    public void rev() {
        int num = 1245;
        int rev = Integer.MIN_VALUE;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        System.out.println(rev);//4345
    }

    @Test
    public void secondMaxFromArray() {
        int arr[] = {3, 6, 5, 2, 8};

        int max = 0;
        int smax = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                smax = max;
                max = arr[i];
            } else {
                if (smax < arr[i]) {
                    smax = arr[i];
                }
            }
        }

        System.out.println(max + " " + smax);//8/6

    }

    //segregate 0 and 1
    @Test
    public void test() {

        int arr[] = {0, 1, 0, 1, 1, 0};
        int j = arr[0];
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        System.out.println(Arrays.toString(arr));

    }


    @Test
    public void window() {

        int[] arr = {1, 4, 5, 2, 3};
        int k = 3;
        int len = arr.length;
        int max = 0;
        int curr = 0;
        int i = 0;
        int j = 0;
        for (i = 0; i <= len - k ; i++) {
            System.out.println("i is " + i);
            for (j = i; j < i + k; j++) {
                System.out.println("j is " + j + "value picked is " + arr[j]);
                curr = curr + arr[j];
            }
            System.out.println("i is " + i + " current sum is " + curr);
            max = Math.max(curr, max);
            System.out.println("i is " + i + " max sum is " + max);
            curr = 0;
        }
    }



    @Test
    public void sliding_window() {

        int[] arr = {1, 4, 5, 2, 3};
        int k = 3;
        int len = arr.length;
        int max = 0;
        int curr = 0;

        for(int i=0;i<k;i++){
            max+=arr[i];
            System.out.println("intial max sum "+max);
        }

        for(int j=k;j<len;j++){
            curr=max+arr[j]-arr[j-k];
            max=Math.max(max,curr);
        }
        System.out.println(max);//11
    }


    @Test
    public void ChapterCountMap(){

        String st="sumitraut";
        int[] data = new int[256]; //0 to 255
        for (int i = 0; i < st.length(); i++) {
            data[(int)st.charAt(i)]++;
        }


       for(int j=0;j<data.length;j++){
           if(data[j]!=0){
               char c=(char)j;
               int count=data[j];
               System.out.println(c+" "+count);
           }
       }
    }

    @Test
    public void enumTest(){




      enum myEnum{

          QA("qaurl"),
          UAT("uaturl");

          String url;

          myEnum(String str){
              this.url=str;
          }


          public String getStr(){
              return url;
          }
      }


        myEnum qa = myEnum.QA;
        System.out.println(qa.getStr());//qaurl




    }










}
