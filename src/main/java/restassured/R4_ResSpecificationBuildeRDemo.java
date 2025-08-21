package restassured;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class R4_ResSpecificationBuildeRDemo {

    public static void main(String[] args) {

        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectContentType("application/json");
        ResponseSpecification responseSpec = builder.build();

        WireMockServer wireMockServer = new WireMockServer(8089); // custom port
        wireMockServer.start();
        wireMockServer.stubFor(get(urlEqualTo("/api/user/1"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{ \"id\": 1, \"name\": \"Sumit\" }")));



        RequestSpecification request= RestAssured.given();
        request.baseUri("http://localhost:8089/");
        request.basePath("/api/user/1 ");
        request.accept(ContentType.JSON);
//        request.accept(ContentType.HTML);
//        A 406 Not Acceptable HTTP status code means:
//        The server cannot produce a response matching the list of acceptable values defined in the request's Accept header.
        Response response = request.get();
        response.then().spec(responseSpec);

        response.then().log().all();
        //HTTP/1.1 200 OK
        //Content-Type: application/json
        //Matched-Stub-Id: 32185753-bf27-4706-bb29-0c501977642f
        //Content-Encoding: gzip
        //Transfer-Encoding: chunked
        //
        //{
        //    "id": 1,
        //    "name": "Sumit"
        //}





        builder.expectStatusCode(200);
        builder.expectContentType("application/jso");
        responseSpec = builder.build();
        response = request.get();
        response.then().spec(responseSpec);

        //Exception in thread "main" java.lang.AssertionError: 1 expectation failed.
        //Expected status code <400> but was <200>.





        // Also we can use RestAssure.expect to

        ResponseSpecification responseSpecification=RestAssured.expect();
        responseSpecification.contentType(ContentType.JSON);
        //responseSpecification.header("","");
        responseSpecification.statusCode(2003);

        request.get().then().spec(responseSpecification);
        //Exception in thread "main" java.lang.AssertionError: 1 expectation failed.
        //Expected status code <2003> but was <200>.
        //	at java.base/jdk.internal.reflect.DirectConstructorHandleAccessor.newInstance(DirectConstructorHandleAccessor.java:62)

    }
}
