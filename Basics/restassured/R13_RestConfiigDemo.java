package restassured;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.config;

public class R13_RestConfiigDemo {
//What is RestAssuredConfig?
//RestAssuredConfig is a configuration object that lets you customize behaviors like:
//
//timeouts
//
//logging
//
//encoder/decoder behavior
//
//JSON/XML parsing
//
//HTTP client settings
//
//SSL settings
//
//You use it when you want to override RestAssured’s default internal behavior.
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
        config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 5000));
        request.config(config);

        request.get();

//




    }
}
