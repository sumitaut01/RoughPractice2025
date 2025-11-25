package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.eclipse.jetty.http.HttpTester;

public class R2_RestAssuredBasic {


    public static void main(String[] args) {
        RequestSpecification request=RestAssured.given();
        request.baseUri("https://stapi.co/");
        request.basePath("api/v1/rest/season/search");
        request.accept(ContentType.JSON);
//        request.accept(ContentType.HTML);
//        A 406 Not Acceptable HTTP status code means:
//        The server cannot produce a response matching the list of acceptable values defined in the request's Accept header.
       Response response = request.get();
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
    }
}
