package restassured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class RX_Hamcrest {

    public static void main(String[] args) {


        //hamcrest is hard assertion. It will fail on first failure
        //testng does capture the hamcreast failure



        Response response=given().baseUri("https://fakestoreapi.com/products").get();


        //Exception in thread "main" java.lang.AssertionError: 1 expectation failed.
        //JSON path size() doesn't match.
        //Expected: a value greater than <99999>
        //  Actual: <20>


//        SoftAssert softAssert=new SoftAssert();
//        try{
//            response.then().body("size()", greaterThan(99999));
//        }
//        catch (Exception oex){
//            softAssert.fail("failed for \"size()\", greaterThan(99999)");
//        }
//        finally {
//            softAssert.assertAll();
//        }




















    }
}
