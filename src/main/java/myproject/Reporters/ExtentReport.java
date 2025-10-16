//package myproject.Reporters;
//
//import reporters.ExtentLogger;
//
//import java.lang.reflect.Method;
//
//public class ExtentReport {
//    private static ExtentReports extent;
//    private static ExtentTest test;
//
//    public static void initReport() {
//        extent = new ExtentReports();
//
//
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
//    public static void createTestWithAnnotation(Method m) {
//        String sTestName = m.getName();
//        try {
//            test = extent.createTest(sTestName).assignAuthor(m.getAnnotation(TestCaseDescription.class).author())
//                    .assignCategory((m.getAnnotation(TestCaseDescription.class).category()));
//            ExtentManager.setExtentTest(test);
//            System.out.println("Test Node created  in ExtentReport using createTestWithAnnotation method for :" + sTestName);
//
//        } catch (Exception oEx) {
//            createTest(sTestName);
//            System.out.println("Test Node created  in extent using createTest method for :" + sTestName);
//        }
//        ExtentLogger.logInfo("Test Execution started for :" + sTestName);
//    }
//
//
//
//
//
//}
//
//
//
