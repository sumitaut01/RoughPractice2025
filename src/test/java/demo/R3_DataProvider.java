package demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class R3_DataProvider {

    @Test(dataProvider = "custom")
    public void Test(String col1,String col2) {
        System.out.println(col1 +"==>"+col2);
        //first==>firstdata
        //second==>secondData
    }


    @DataProvider(name="custom")
    public Object[][] myMethod() {

        Object data[][] = new Object[2][2];
        data[0][0] = "first";
        data[0][1] = "firstdata";
        data[1][0] = "second";
        data[1][1] = "secondData";
        return data;
    }
}
