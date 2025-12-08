package basics.log4j;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestLog4j {

      private static final Logger logger = LogManager.getLogger(TestLog4j.class);

      @Test
      public void exampleTest() {
            logger.info("Starting the test...");
            // Your Selenium code here
            logger.info("Test completed.");
      }

}
