package karat;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class R1_RearrangeArray {
    public static void main(String[] args) {

        /*
        // better ask what will null, blank values in input or target array
        //consider 10k+values
        // see relative placement ramains


         */

        String array[] = {"India", "America", "London", "America", "China"};
        String target = "America";

        //result [ "India","London","China","America","America"]
    }


    public static String[] rearrange(String[] data, String target) throws Exception {
        List<String> rearranged = new ArrayList<>();
        Objects.requireNonNull(data);
        Objects.requireNonNull(target);
        if(data.length==0){
            throw new Exception("Provided array is empty");
        }
        int count=0;

        for(int i=0;i<data.length;i++){
            if(String.valueOf(data[i]).equals(target)){
                count++;
            }
            else{
                rearranged.add(data[i]);
            }
        }

            for(int i=0;i<count;i++) {
                rearranged.add(target);
            }

            return  rearranged.toArray(new String[0]);
          //  return (String[]) rearranged.toArray();
    }




    @Test
    public void test_happyPath() throws Exception {
        String array[] = {"India", "America", "London", "America", "China"};
        String target = "America";
        Assert.assertArrayEquals(new String []{"India", "London",  "China","America","America"}, rearrange(array,target));
        System.out.println(Arrays.toString(rearrange(array,target)));//[India, London, China, America, America]
    }

    @Test
    public void test_notargetinarray() throws Exception {
        String array[] = {"India","China"};
        String target = "America";
        Assert.assertArrayEquals(new String []{"India","China"}, rearrange(array,target));
        System.out.println(Arrays.toString(rearrange(array,target)));//[India, China]
    }


    @Test
    public void test_nullasitem() throws Exception {
        String array[] = {null,"India","China"};
        String target = "America";
        Assert.assertArrayEquals(new String []{null,"India","China"}, rearrange(array,target));
        System.out.println(Arrays.toString(rearrange(array,target)));//[null, India, China]
    }


    @Test
    public void test_nullalongwithtarget() throws Exception {
        String array[] = {null,"America","America","India","China"};
        String target = "America";
        Assert.assertArrayEquals(new String []{null,"India","China","America","America"}, rearrange(array,target));
        System.out.println(Arrays.toString(rearrange(array,target)));//[null, India, China, America, America]
    }
}
