//package com.reporters;
//import com.annotations.TestCaseDescription;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.config.ApiFactory;
//import com.utils.globalutils.GenericFunctions;
//
//import java.lang.reflect.Method;
//import java.util.Hashtable;
//import java.util.List;
//
//import static com.config.ConfigFactory.getConfig;
//import static com.google.common.base.Throwables.getStackTraceAsString;
//
//public class ExtentReport {
//    private static ExtentReports extent;
//    private static ExtentTest test;
//
//    public static void initReport() {
//        extent = new ExtentReports();
//        //String sEnv= getConfig().appurl().toLowerCase().contains("qa")?"QA_":"UAT_";
//        //String appUrl = getConfig().appurl().toLowerCase();
//        appUrl="qa";
//        String sEnv = appUrl.contains("qa") ? "QA_" :
//                appUrl.contains("uat") ? "UAT_" :
//                        "PROD_";
//        //experimental
//        if(ApiFactory.getConfig().runfromapixml().equalsIgnoreCase("true")){
//            //sEnv= ApiFactory.getConfig().appurl().toLowerCase().contains("qa")?"QA_API_":"UAT_API";
//
//             appUrl = ApiFactory.getConfig().appurl().toLowerCase();
//             sEnv = appUrl.contains("qa") ? "QA_API" :
//                    appUrl.contains("uat") ? "UAT_API" :
//                            "PROD_API";
//
//
//        }
//        ExtentSparkReporter spark = new ExtentSparkReporter(getConfig().reportpath()+"\\"+sEnv+"RunResult_"+ GenericFunctions.getDateTimeForReport()+".html");
//        try {
//            spark.loadXMLConfig("src/main/java/com/reporters/extentconfig.xml");
//            extent.attachReporter(spark);
//        } catch (Exception oEx) {
//            System.out.println("Error while loading Extent XML configuration."+getStackTraceAsString(oEx));
//            System.exit(1);
//        }
//
//    }
//
//    public static void flushReport() {
//        try{
//        extent.flush();
//        }
//     catch (Exception oEx) {
//        System.out.println("Error while flushing Extent Report. "+getStackTraceAsString(oEx));
//        System.exit(1);
//    }
//
//    }
//
//    public static void createTest(String testName) {
//        test = extent.createTest(testName);
//        com.reporters.ExtentManager.setExtentTest(test);
//    }
//
////    public static void createTestWithAnnotation(Method m) {
////        String sTestName = m.getName();
////        try {
////            test = extent.createTest(sTestName).assignAuthor(m.getAnnotation(TestCaseDescription.class).author())
////                    .assignCategory((m.getAnnotation(TestCaseDescription.class).category()));
////            ExtentManager.setExtentTest(test);
////            System.out.println("Test Node created  in ExtentReport using createTestWithAnnotation method for :" + sTestName);
////
////        } catch (Exception oEx) {
////            createTest(sTestName);
////            System.out.println("Test Node created  in extent using createTest method for :" + sTestName);
////        }
////        ExtentLogger.logInfo("Test Execution started for :" + sTestName);
////    }
////
////
////    public static void createTestWithAnnotationDynamicName(Method m, List<Object> data) {
////        String sTestName = m.getName();
////        sTestName=sTestName+"_Dynamic";
////        try {
////            test = extent.createTest(sTestName).assignAuthor(m.getAnnotation(TestCaseDescription.class).author())
////                    .assignCategory((m.getAnnotation(TestCaseDescription.class).category()));
////            ExtentManager.setExtentTest(test);
////            System.out.println("Test Node created  in ExtentReport using createTestWithAnnotationDynamicName method for :" + sTestName);
////
////        } catch (Exception oEx) {
////            createTest(sTestName);
////            System.out.println("Test Node created  in extent using createTest method for :" + sTestName);
////        }
////        ExtentLogger.logInfo("Test Execution started for :" + sTestName);
////    }
//
//
//}
//
//
//
//
