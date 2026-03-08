package restassured_datareading;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



public class R2_DataReading_DataProvider {

    @Test(dataProvider = "jsonFlowProvider")
    public void testIntegratedEndpoints_JsonArray(Map<String, Object> testData) {

        System.out.println("Running Scenario: " + testData.get("scenario"));

        // --- STEP 1: Registration ---
        Map<String, Object> reg = (Map<String, Object>) testData.get("registration");

        System.out.println(reg);

        // 2. Now access 'type' inside that map
        String userType = (String) reg.get("type");
        System.out.println(userType);

//        String userId = given()
//                .body(reg)
//                .when()
//                .post("/register")
//                .then()
//                .extract().path("id");

        // --- STEP 2: Order Placement ---
        Map<String, Object> order = (Map<String, Object>) testData.get("order");
        System.out.println(order);
       // order.put("userId", userId); // Link Step 1 to Step 2

//        given()
//                .body(order)
//                .when()
//                .post("/orders")
//                .then()
//                .statusCode(201);
    }



    @DataProvider(name = "jsonFlowProvider")
    public Iterator<Object[]> getJsonData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Read the file as a List of Maps
        List<Map<String, Object>> list = mapper.readValue(
                new File("src/test/resources/test-data_array.json"),
                new TypeReference<List<Map<String, Object>>>() {}
        );

        // Convert List to Iterator for TestNG
        return list.stream()
                .map(data -> new Object[] { data })
                .iterator();
    }

    @Test(dataProvider = "jsonFlowProvider")
    public void testWithJsonPath(Map<String, Object> testData) throws JsonProcessingException {
        // 1. Convert Map to JSON String
        String jsonString = new ObjectMapper().writeValueAsString(testData);

        // 2. Now use JsonPath.from()
        JsonPath jp = JsonPath.from(jsonString);

        // 3. Access nested data using dot notation
        String userType = jp.getString("registration.type");
        System.out.println("User Type is: " + userType);
    }

}
