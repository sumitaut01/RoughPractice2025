package restassuredworkvalidations;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class R1_Get {
    private WireMockServer wireMockServer;
//    @BeforeClass
//    public void setup() {
//        wireMockServer = new WireMockServer(9095);
//        wireMockServer.start();
//        configureFor("localhost", 9095);
//
//        // STUBBING
//        stubFor(get(urlEqualTo("/v1/orders/sampleorder"))
//                .withHeader("Authorization", equalTo("Bearer MY_SECRET_TOKEN"))
//                .willReturn(aResponse()
//                        .withStatus(200)
//                        .withHeader("Content-Type", "application/json")
//                        // WireMock automatically looks in src/test/resources/__files/
//                        .withBodyFile("__files/orders_response.json")));
//    }

    @Test
    public void getWork() {
        Response response = RestAssured.given()
                .baseUri("http://localhost:8080")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("/api/orders_response"); // Path goes here
//                .then()
//                .log().all()
//                .statusCode(200)
//                // Validate schema from src/test/resources
//                .body(matchesJsonSchemaInClasspath("orders_response_schema.json"))
//                .extract().response();

        SchemaValidator.validate(response,"orders_response_schema.json");
        new ResponseValidator(response).statusCode(200);

    }

//    @AfterClass
//    public void tearDown() {
//        if (wireMockServer != null) {
//            wireMockServer.stop();
//        }
//    }

}
