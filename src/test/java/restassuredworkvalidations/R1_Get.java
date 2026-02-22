package restassuredworkvalidations;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Data;
import lombok.ToString;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

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

        SchemaValidator.validate(response, "orders_response_schema.json");
        new ResponseValidator(response).statusCode(200);

    }

//    @AfterClass
//    public void tearDown() {
//        if (wireMockServer != null) {
//            wireMockServer.stop();
//        }
//    }


    @Test
    public void ignoreUnknown_True() throws JsonProcessingException {
        String userExtraFields= """
                {
                  "id":             1,               
                  "name":           "Alice Kumar",   
                  "email":          "alice@test.com",
                  "createdAt":      "2024-01-15",    
                  "internalCode":   "XYZ-999",       
                  "experimentFlag": true,            
                  "score":          98.5             
                }                
                """;
        //  // ← known field → setId(1)
        // //  ← known field → setName("Alice Kumar")
        //  // ← known field → setEmail("alice@test.com")
        //  // ← UNKNOWN → setAdditionalProperty("createdAt", "2024-01-15")
        //  // ← UNKNOWN → setAdditionalProperty("internalCode", "XYZ-999")
        // // ← UNKNOWN → setAdditionalProperty("experimentFlag", true)
        // //  ← UNKNOWN → setAdditionalProperty("score", 98.5)

        User_IgnoreUnknown user=  new ObjectMapper().readValue(userExtraFields, User_IgnoreUnknown.class);
        System.out.println(user);//User(id=1, name=Alice Kumar, email=alice@test.com)
    }



    @Test
    public void ignoreUnknown_False_JsonSetterGetter() throws JsonProcessingException {
        String userExtraFields= """
                {
                  "id":             1,               
                  "name":           "Alice Kumar",   
                  "email":          "alice@test.com",
                  "createdAt":      "2024-01-15",    
                  "internalCode":   "XYZ-999",       
                  "experimentFlag": true,            
                  "score":          98.5             
                }                
                """;
        //  // ← known field → setId(1)
        // //  ← known field → setName("Alice Kumar")
        //  // ← known field → setEmail("alice@test.com")
        //  // ← UNKNOWN → setAdditionalProperty("createdAt", "2024-01-15")
        //  // ← UNKNOWN → setAdditionalProperty("internalCode", "XYZ-999")
        // // ← UNKNOWN → setAdditionalProperty("experimentFlag", true)
        // //  ← UNKNOWN → setAdditionalProperty("score", 98.5)

        User_IgnoreUnknown_False_WithAnySettetrGetter user=  new ObjectMapper().readValue(userExtraFields, User_IgnoreUnknown_False_WithAnySettetrGetter.class);
        System.out.println(user);

        //User_IgnoreUnknown_False_WithAnySettetrGetter(id=1, name=Alice Kumar, email=null, additionalProperties=
        //
        // {createdAt=2024-01-15,
        // score=98.5,
        // experimentFlag=true,
        // email=alice@test.com,
        // internalCode=XYZ-999}
        // )


        // Access individual unknown fields
        String code = (String) user.getAdditionalProperties().get("internalCode");
// → "XYZ-999"

        Boolean flag = (Boolean) user.getAdditionalProperties().get("experimentFlag");

    }
}


@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
class User_IgnoreUnknown {
    Integer id;
    String name;
    String email;
}


@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = false)
class User_IgnoreUnknown_False {
    Integer id;
    String name;
    String email;
}



@ToString
@JsonIgnoreProperties(ignoreUnknown = false)
class User_IgnoreUnknown_False_WithAnySettetrGetter {
    // ── Known, mapped fields ──────────────────────────────────────────
    private int    id;
    private String name;
    private String email;

    // ── Bucket for ALL unknown/extra fields ───────────────────────────
    private Map<String, Object> additionalProperties = new HashMap<>();

    // ── Standard getters/setters for known fields ─────────────────────
    public int    getId()              { return id; }
    public void   setId(int id)        { this.id = id; }
    public String getName()            { return name; }
    public void   setName(String n)    { this.name = n; }

    // ── @JsonAnySetter — receives unknown fields one by one ───────────
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);  // store in bucket
    }

    // ── @JsonAnyGetter — spreads the map back out as flat JSON fields ──
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
}


