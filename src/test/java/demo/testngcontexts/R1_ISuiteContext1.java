package demo.testngcontexts;

import org.testng.ITestContext;
import org.testng.annotations.Test;

//https://makeseleniumeasy.com/2020/01/06/testng-tutorials-68-sharing-data-between-tests-in-a-suite-using-isuite-itestcontext/
public class R1_ISuiteContext1 {


    @Test
    public void method1(ITestContext context){
        System.out.println("Method 1: Setting ITestContext in class 1 method 1");
        context.setAttribute("username", "myuser");


    }
}
