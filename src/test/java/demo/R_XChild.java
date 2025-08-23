package demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class R_XChild extends Rx_Base{


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod in R_XDemo");//Testing
    }
    @Test
    public void demo(){
        System.out.println("Testing");//Testing
    }

//    @AfterSuite
//    public void AfterSuite(){
//        System.out.println("AfterSuite in R_XDemo");//Testing
//    }

}
