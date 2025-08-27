package demo.testngcontexts;

import org.testng.ITestContext;
import org.testng.annotations.Test;

//https://makeseleniumeasy.com/2020/01/05/testng-tutorials-67-sharing-data-among-test-methods-in-testng-using-itestcontext/
//ITestContext reference is created once and can be used with @Test annotated method by just passing it as a parameter.
// Actually scope of added variable in ITestContext is within current test. Outside of test, it will give you null.
public class R2_ITestContext {


    @Test
    public void method1(ITestContext context){

        String firstName="Sumit";
        context.setAttribute("firstName",firstName);
       // System.out.println(context.getAttribute("firstName"));
    }


    @Test
    public void method2(ITestContext context){
        String lastName="Raut";
        context.setAttribute("lastName",lastName);


        System.out.println("-----Separator");
        System.out.println( context.getAttribute("firstName") +" "+context.getAttribute("lastName"));

//        -----Separator
//        Sumit Raut

    }
}
