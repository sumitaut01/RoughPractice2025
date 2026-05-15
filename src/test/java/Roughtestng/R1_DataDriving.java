package Roughtestng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class R1_DataDriving {
    @Test(dataProvider = "data")
    public void DataDriving(String first,String second){
        System.out.println(first+" "+second);
    }

    @Test(priority =-1)
    public void Priority(){
        System.out.println("running method");
    }


    @Test(invocationCount = 2,enabled = false)
    public void DataDriving(){
        System.out.println("running method");
    }

    //Returning 2 d array
    @DataProvider(name="data")
    public Object[][] data(){
        return new Object[][]
                {
                        {"username","password"},
                        {"sumit","password"},
                        {"neha","password"}
                };
    }
}
