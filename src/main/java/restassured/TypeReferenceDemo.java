package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class TypeReferenceDemo {

    public static void main(String[] args) throws JsonProcessingException {

        String responseBody = """
                [
                  {
                    "firsName": "sumit",
                    "salary": 20000
                  },
                  {
                    "firsName": "Neha",
                    "salary": 10
                  }
                ]
                """;

        // Start WireMock
        WireMockServer wireMockServer = new WireMockServer(8089);
        wireMockServer.start();

        // Stub API
        wireMockServer.stubFor(get(urlEqualTo("/api/user/1"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody(responseBody)));

        // Call API using RestAssured
        Response response = RestAssured.given()
                .baseUri("http://localhost:8089")
                .basePath("/api/user/1")
                .accept(ContentType.JSON)
                .get();

        // Deserialize using TypeReference

        ObjectMapper mapper = new ObjectMapper();

        List<Users> users = mapper.readValue(
                response.asString(),new TypeReference<List<Users>>() {}
        );


        // Verify output
        users.forEach(u ->
                System.out.println(u.getFirsName() + " -> " + u.getSalary())
        );

        // Stop WireMock
        wireMockServer.stop();
    }
}

// POJO
class Users {

    private String firsName;
    private Integer salary;

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
