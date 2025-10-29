package selenium.softassertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class R1_SoftAssert {
    @Test
    public void SADemo() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(1, 2);//execution wont stop here even though its failing
        softAssert.assertEquals(1, 4);
        softAssert.assertAll();//this is required else everything is considered as pass

        //SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
        //SLF4J: Defaulting to no-operation (NOP) logger implementation
        //SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
        //
        //java.lang.AssertionError: The following asserts failed:
        //	expected [2] but found [1],
        //	expected [4] but found [1]
    }


    @Test
    public void RoughAssert(){

        Assert.assertEquals(2, 2);

        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("Sumit", 35);
        hm.put("Amit", 40);
        hm.put("Preeti", 39);

        HashMap<String,Integer> hm2=new HashMap<>();
        hm2.put("Sumit", 35);
        hm2.put("Preeti", 39);
        hm2.put("Amit", 40);


        Assert.assertEquals(hm,hm2); //passes. order changed still


        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        l1.add(1);
        l2.add(2);

        l2.add(1);
        l1.add(2);

        Assert.assertEquals(l1, l2);//java.lang.AssertionError: Lists differ at element [0]: 2 != 1


    }
}
