package restassured;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.matching.StringValuePattern;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.eclipse.jetty.http.HttpTester;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class R14_HeadernHeaders {


    public static void main(String[] args) {

        WireMockServer wireMockServer = new WireMockServer(8089); // custom port
        wireMockServer.start();
        wireMockServer.stubFor(get(urlEqualTo("/api/user/1"))
                .withHeader("Content-Type", equalTo("application/json"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody("{ \"id\": 1, \"name\": \"Sumit\" }")));



        RequestSpecification request= RestAssured.given();
        request.baseUri("http://localhost:8089/");
        request.basePath("/api/user/1 ");
       // request.header(new Header("Content-Type", "application/jso"));
        //Content-Type: application/json
        // | Content-Type: application/jso; charset=ISO-8859-1   <<<<< Header does not match


        request.header(new Header("Content-Type", "application/json"));
        request.get().then().log().all();
        //HTTP/1.1 200 OK
        //Content-Type: application/json
        //Matched-Stub-Id: ae014b20-e52c-4f75-b870-54831c7ecd99
        //Content-Encoding: gzip
        //Transfer-Encoding: chunked
        //
        //{
        //    "id": 1,
        //    "name": "Sumit"
        //}


        Response response=request.get();
        String v1 = response.getHeaders().get("Content-Type").getValue();
        String v2 = response.getHeaders().getValue("Content-Type");

    }
}
