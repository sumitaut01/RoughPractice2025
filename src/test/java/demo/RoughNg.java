package demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoughNg {
    @Test(enabled = false)
    public void demo() {


    }


    @Test(dataProvider = "mine")
    public void demo2(String userName,String lastName,String designation) {
        System.out.println(userName +"  "+lastName +" "+ designation);
    }

     @DataProvider(name="mine")
    public Object[][] data() {
        Object[][] data = new Object[2][3];
        data[0][0] = "sumit";
        data[0][1] = "raut";
         data[0][2] = "QA";
        data[1][0] = "neha";
        data[1][1] = "deshmukh";
         data[1][2] = "DEV";
        return data;

    }
}


