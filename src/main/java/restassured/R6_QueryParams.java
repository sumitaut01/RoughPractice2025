package restassured;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class R6_QueryParams {
    //GET http://localhost:8089/api/user?id=1&role=admin

    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(8089);
        wireMockServer.start();

        wireMockServer.stubFor(get(urlPathEqualTo("/api/user"))
                .withQueryParam("id", equalTo("1"))
                .withQueryParam("role", equalTo("admin"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"id\": 1, \"name\": \"Sumit\", \"role\": \"admin\" }")));

        System.out.println("WireMock is running on port 8089");


        RequestSpecification request= RestAssured.given();
        request.baseUri("http://localhost:8089/api/");
        request.basePath("user");
        request.queryParam("id",1);
        request.queryParam("role","admin");
        request.accept(ContentType.JSON);


        request.log().all();

        Response response = request.get();
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());




    }
}
