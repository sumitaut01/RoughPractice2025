package zzRough;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class RoughZZ {


    @Test
    public void CharCount() {

        String name = " this is it";

        HashMap<Character, Integer> hm = new HashMap<>();

        for (Character c : name.toCharArray()) {

            if (!hm.containsKey(c)) {
                hm.put(c, 1);
            } else {
                hm.put(c, hm.get(c) + 1);
            }

        }

        System.out.println(hm);
    }


    @Test
    public void RevNum() {
        int num = 1234;
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        System.out.println(rev);
    }


    @Test
    public void RevString() {

        String s="this is it";
        System.out.println(s);
        for(int i=s.length()-1;i>=0;i--){
            System.out.print(s.charAt(i));
            //this is it
            //ti si siht
        }
    }


    @Test
    public void listDuplicate(){

        List<String> lst=new ArrayList<>();

        lst.add("sumit");
        lst.add("amit");
        lst.add("neha");
        lst.add("sumit");
        lst.add("raj");


        HashSet<String> str=new HashSet<>();

        for(String s: lst){
           str.add(s);
        }
        System.out.println(str);//[neha, amit, raj, sumit]
    }


    @Test
    public void Segregation(){

        int j=0;
        int arr[]={1,0,1,0,1};

        System.out.println(Arrays.toString(arr));

        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
              int  temp=arr[j];//
                arr[j]=arr[i];
               arr[i]=temp;
               j++;
            }
        }

        System.out.println(Arrays.toString(arr));



    }

    @Test
    public void SecondArray(){

        int arr[]={4,3,5,7,8};


        int max=0;
        int second=0;


        for( int i: arr){

          if(i>max) {
              second = max;
              max = i;
          }
          else {
           if(i>second){
              second=i;
           }
          }
        }

        System.out.println(max);
        System.out.println(second);
        //8
        //7

    }


    @Test(dataProvider = "mine")
    public void Reg(String first,String last){
        System.out.print(first);
        System.out.print(last);
    }


    @DataProvider(name = "mine")
    public Object[][] getData(){
        Object[][] data=new Object[2][2];
        data[0][0]="sumit";
                data[0][1]="raut";

        data[1][0]="amit";
        data[1][1]="raut";
        return data;
    }

}
