package basics.javapgms;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SortBasedOnminutes {


    @Test
    public void Sort() {
//{ "4:59", "4:39", "9:32", "5:58", "9:35" }
//✅ Extracted Output (O/P):
//arduino
//Copy code
//{ "9:32", "9:35", "4:39", "5:58", "4:59" }


        String[] str = {"4:59", "4:39", "9:32", "5:58", "9:35"};


        System.out.println(Arrays.toString(str));

        for(int i=0;i<str.length-1;i++){

            for(int j=i+1;j<str.length;j++){
            if(Integer.parseInt(str[i].split(":")[1])<Integer.parseInt(str[j].split(":")[1]))
            {
                String temp=str[i];
                str[i]=str[j];
                str[j]=temp;
            }
            }
        }

        System.out.println(Arrays.toString(str));

    }
}
