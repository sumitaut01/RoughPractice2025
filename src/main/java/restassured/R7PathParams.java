package restassured;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.eclipse.jetty.http.HttpTester;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class R7PathParams {
//http://localhost:8089/api/user/create
    public static void main(String[] args) {

        //Prefer suing path parameter for pathsegments:


                WireMockServer wireMockServer = new WireMockServer(8089);
                wireMockServer.start();
                wireMockServer.stubFor(post(urlEqualTo("/api/1/user/create"))
                        .withHeader("Content-Type", equalTo("application/json"))
                        .withRequestBody(equalToJson("{ \"name\": \"Sumit\" }"))
                        .willReturn(aResponse()
                                .withStatus(201)
                                .withHeader("Content-Type", "application/json")
                                .withBody("{ \"message\": \"User created successfully\" }"))
                );
                System.out.println("WireMock is running on http://localhost:8089");

        RequestSpecification request = RestAssured.given();

        request.contentType(ContentType.JSON);
        request.baseUri("http://localhost:8089");
        request.basePath("/api/");
        request.pathParam("endPoint", "1");

        request.body("{ \"name\": \"Sumit\" }");
        Response response = request.post("{endPoint}"+"/user/create");


        response.then().log().body();





            }
        }


