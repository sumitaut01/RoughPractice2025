package testng;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class R3_ITestResultUsage {


    @Test
    public void demo() {
        System.out.println("This is demo");

        System.out.println(2 / 0);
    }


    @BeforeMethod
    public void bm() {
        System.out.println("inside bm");
    }

    @AfterMethod
    public void am(ITestResult result) {
        System.out.println("inside am");
        System.out.println(result.getMethod().getMethodName());//demo
        System.out.println(result.getStatus());//2
         /*
        int SUCCESS = 1;
        int FAILURE = 2;
        int SKIP = 3;
         */


        result.getThrowable().printStackTrace();
        /*

        java.lang.ArithmeticException: / by zero
	at testng.R3_ITestResultUsage.demo(R3_ITestResultUsage.java:15)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.testng.internal.invokers.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:141)
	at org.testng.internal.invokers.TestInvoker.invokeMethod(TestInvoker.java:687)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethod(TestInvoker.java:230)
	at org.testng.internal.invokers.MethodRunner.runInSequence(MethodRunner.java:63)
	at org.testng.internal.invokers.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:995)
	at org.testng.internal.invokers.TestInvoker.invokeTestMethods(TestInvoker.java:203)
	at org.testng.internal.invokers.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:154)
	at org.testng.internal.invokers.TestMethodWorker.run(TestMethodWorker.java:134)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at org.testng.TestRunner.privateRun(TestRunner.java:741)
	at org.testng.TestRunner.run(TestRunner.java:616)
	at org.testng.SuiteRunner.runTest(SuiteRunner.java:421)
	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:413)
	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:373)
	at org.testng.SuiteRunner.run(SuiteRunner.java:312)
	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:95)
	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1274)
	at org.testng.TestNG.runSuitesLocally(TestNG.java:1208)
	at org.testng.TestNG.runSuites(TestNG.java:1112)
	at org.testng.TestNG.run(TestNG.java:1079)
	at com.intellij.rt.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:66)
	at com.intellij.rt.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:105)
         */

    }
}
