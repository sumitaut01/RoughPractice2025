package demo.testngcontexts;

import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.annotations.Test;

//https://makeseleniumeasy.com/2020/01/06/testng-tutorials-68-sharing-data-between-tests-in-a-suite-using-isuite-itestcontext/
public class R1_ISuiteContext2 {

    @Test
    public void method2(ITestContext context){

        System.out.println("Method 2: Setting ITestContext in class 2 method 2");
        context.setAttribute("password", "mypassword");


        //below one wont work as username was set in different test class
        System.out.println("--From Test Context---");
        System.out.println(context.getAttribute("username")+ " "+context.getAttribute("password"));

        //below one will work if used from .xmml
        System.out.println("--From Suite Context---");
        ISuite suite=context.getSuite();
        System.out.println((String)suite.getAttribute("username")+ " "+(String)suite.getAttribute("password"));





    }
}
