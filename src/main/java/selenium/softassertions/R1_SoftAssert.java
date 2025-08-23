package selenium.softassertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class R1_SoftAssert {
    @Test
    public void SADemo() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(1, 2);//execution wont stop here even though its failing
        softAssert.assertEquals(1, 4);
        softAssert.assertAll();//this is required else everything is considered as pass

        //SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
        //SLF4J: Defaulting to no-operation (NOP) logger implementation
        //SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
        //
        //java.lang.AssertionError: The following asserts failed:
        //	expected [2] but found [1],
        //	expected [4] but found [1]
    }
}
