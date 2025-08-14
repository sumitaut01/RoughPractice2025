package restassured;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class R20_JsonIgnoreUnknown {

    public static void main(String[] args) throws JsonProcessingException {

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
//        request.accept(ContentType.HTML);
//        A 406 Not Acceptable HTTP status code means:
//        The server cannot produce a response matching the list of acceptable values defined in the request's Accept header.
        Response response = request.get();


        ObjectMapper objectMapper=new ObjectMapper();
       // Dummy dummy=objectMapper.readValue(response.asString(),Dummy.class);
        //pojo has only id. hence will run into this error
        //SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
        //Exception in thread "main" com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "name" (class restassured.Dummy), not marked as ignorable (one known property: "id"])
        // at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 21] (through reference chain: restassured.Dummy["name"])


        ObjectMapper objectMapper2=new ObjectMapper();
        Dummy2 dummy2=objectMapper.readValue(response.asString(), Dummy2.class);

        System.out.println(dummy2);//Dummy2{id=1}

    }
}

class Dummy{
    int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //String name;
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Dummy2{
    int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dummy2{" +
                "id=" + id +
                '}';
    }
    //String name;
}
