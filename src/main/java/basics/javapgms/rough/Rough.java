package basics.javapgms.rough;

import org.apache.http.io.SessionOutputBuffer;
import org.testng.annotations.Test;

import java.util.*;

public class Rough {

    @Test
    public void twoSum() {

        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int eSum = 9;

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            int lookup = eSum - i;

            if (hm.containsKey(lookup)) {
                System.out.println(i + " " + lookup);
            } else {
                hm.put(arr[i], i);
            }
        }
    }
    //5 4
    //6 3
    //7 2
    //8 1
    //9 0


    @Test
    public void charCount() {
        String str = "this is is";
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!hm.containsKey(c)) {

                hm.put(c, 1);
            } else {
                hm.put(c, hm.get(c) + 1);
            }
        }
        System.out.println(hm);//{ =2, s=3, t=1, h=1, i=3}
    }

    @Test
    public void charCountArray() {
        String str = "this is is";

        int[] data = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            data[(int) ch]++;
        }


        System.out.println(Arrays.toString(data));

        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                System.out.println(i + " " + data[i] + " " + (char) i);
            }
        }

    }


    @Test
    public void lastNonRepeatingChar() {
        String str = "this is is";
        HashMap<Character, Integer> hm = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            if (!hm.containsKey(c)) {

                hm.put(c, 1);
            } else {
                hm.put(c, hm.get(c) + 1);
            }
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (hm.get(ch) == 1) {
                System.out.println(ch + " " + hm.get(ch));//h 1
                break;
            }
        }
    }

    @Test
    public void Arran2nnd() {
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int first = arr[0], second = arr[0];


        for (int i : arr) {

            if (i > first) {

                second = first;
                first = i;
            } else {
                if (i > second) {
                    second = i;
                }
            }
        }

        System.out.println(first);//9
        System.out.println(second);//8
    }


    @Test
    public void ordering_Thisisit() {
        String str = "this is india";

        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // return o1.length()-o2.length(); //[is, this, india]

                return -(o1.length() - o2.length()); //[india, this, is]
            }
        });

        for (String s : str.split(" ")) {
            ts.add(s);
        }

        System.out.println(ts);


    }

    @Test
    public void ReverseNum() {
        int num = 12345;
        int rev = 0;

        System.out.println(num);
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        System.out.println(rev);

        //        12345
//        54321

    }


    @Test
    public void Move0and1() {

        int arr[] = {1, 0, 1, 0, 0, 1};
        int j = 0;
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }

        System.out.println(Arrays.toString(arr));
        //[1, 0, 1, 0, 0, 1]
        //[0, 0, 0, 1, 1, 1]

    }


    @Test
    public void factorial() {
        System.out.print(fact(5));//120
    }


    public static int fact(int n) {

        if (n == 1) return 1;
        int fact = n * fact(n - 1);
        return fact;

    }


    @Test
    public void reverse() {

        String str = "this is sparta";
        String rev = "";

        System.out.println(str);
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        System.out.println(rev);
    }


    @Test
    public void reverseArrayStringOnPlace() {
        String[] str = {" this", "is", "it"};

        System.out.println(Arrays.toString(str));
        //op    siht si ti
        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            String temp = "";
            for (int j = s.length() - 1; j >= 0; j--) {
                temp = temp + s.charAt(j);
            }
            str[i] = temp;
        }
        System.out.println(Arrays.toString(str));

        //[ this, is, it]
        //[siht , si, ti]
    }


    @Test
    public void maxOfSubArray() {


    }

    @Test
    public void longestCommonPrefix() {


    }

    @Test
    public void coforge() {
        String str = "aabbccadd";
        ////a2b2c2a1d2
        int count = 0;
        int i = 0;
        while (i < str.length()) {
            count = 0;
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                } else {

                    break;
                }
            }
            System.out.println(str.charAt(i) + "" + count);
            i = i + count;

        }
    }

    @Test
    public void ustccmasking() {
        String card = "1234567890123456";

        StringBuffer sb = new StringBuffer();


        for(int i=0;i<card.length();i++){
         if(i>=12){
          sb.append(card.charAt(i));
         }
         else{
             sb.append("*");
         }
        }

        System.out.println(sb);
        for(int i=0;i<sb.length()-1;i++){
          if((i+1)%4==0){
              sb.insert(i+1,"-");
          }
        }

        System.out.println(sb);




    }



}






