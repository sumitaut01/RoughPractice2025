package restassured;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class R1_WireMock {

    public static void main(String[] args) {

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
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());


      wireMockServer.stop();

    }
}
