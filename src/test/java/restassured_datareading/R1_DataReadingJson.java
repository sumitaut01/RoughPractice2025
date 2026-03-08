package restassured_datareading;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

public class R1_DataReadingJson {
    @Test
    public void executeIntegratedFlow() throws IOException {
        // 1. Load the JSON into a nested Map
        File file = new File("src/test/resources/test-data.json");
        Map<String, Object> fullData = new ObjectMapper().readValue(file, Map.class);

        // 2. Access 'registration' block for Endpoint 1
        Map<String, Object> regData = (Map<String, Object>) fullData.get("registration");

        System.out.println(regData);

        Response regResponse = given()
                .contentType("application/json")
                .body(regData)
                .when()
                .post("/api/v1/register");

        String authToken = regResponse.jsonPath().getString("token");

        // 3. Access 'orderPlacement' block for Endpoint 2
        Map<String, Object> orderData = (Map<String, Object>) fullData.get("orderPlacement");
        System.out.println(orderData);

        given()
                .header("Authorization", "Bearer " + authToken)
                .body(orderData)
                .when()
                .post("/api/v1/orders")
                .then()
                .statusCode(201);
    }








}
