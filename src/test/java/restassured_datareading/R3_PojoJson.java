package restassured_datareading;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.PriceRequest;
import pojo.PriceRequestLine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class R3_PojoJson {
    @Test(dataProvider = "jsonFlowProvider")
    public void testPriceComparison(Map<String, Object> testData) {
        // 1. Create the Main Request Object
        PriceRequest request = new PriceRequest();
        request.setCountryCode((String) testData.get("countryCode"));
        request.setCompanyCode((String) testData.get("companyCode"));
        request.setCustomerBranch((String) testData.get("customerBranch"));
        request.setCustomerNumber((String) testData.get("customerNumber"));
        request.setOrder((Boolean) testData.get("isOrder"));
        request.setClientSystem((String) testData.get("clientSystem"));

        // 2. Build the List of Products (The nested "priceRequestLines")
        // Let's say your JSON data provides an array of products
        List<Map<String, Object>> productsData = (List<Map<String, Object>>) testData.get("products");

        List<PriceRequestLine> lines = new ArrayList<>();
        for (Map<String, Object> p : productsData) {
            lines.add(new PriceRequestLine(
                    (String) p.get("partNumber"),
                    (Integer) p.get("qty")
            ));
        }

        // 3. Attach the list to the main request
        request.setPriceRequestLines(lines);


        System.out.println(request);

        // 4. Send the Request - RestAssured handles the conversion to JSON automatically
//        given()
//                .contentType("application/json")
//                .body(request)
//                .when()
//                .post("/api/v1/pricing")
//                .then()
//                .statusCode(200);
    }


    @DataProvider(name = "jsonFlowProvider")
    public Iterator<Object[]> getJsonData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // Read the file as a List of Maps
        List<Map<String, Object>> list = mapper.readValue(
                new File("src/test/resources/PricingRequestSample.json"),
                new TypeReference<List<Map<String, Object>>>() {
                }
        );

        // Convert List to Iterator for TestNG
        return list.stream()
                .map(data -> new Object[]{data})
                .iterator();
    }
}
