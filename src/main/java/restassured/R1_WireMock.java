package restassured;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class R1_WireMock {

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
//        request.accept(ContentType.HTML);
//        A 406 Not Acceptable HTTP status code means:
//        The server cannot produce a response matching the list of acceptable values defined in the request's Accept header.
        Response response = request.get();
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());

      wireMockServer.stop();

    }



    @Test
    public void Test() throws IOException {

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
        Response response = request.get();

      //to match schema
        //   response.then().assertThat().body(matchesJsonSchemaInClasspath("user-schema.json"));


        System.out.println(response);//io.restassured.internal.RestAssuredResponseImpl@536ac72

        System.out.println(response.getStatusCode());//200

        //1 as byteArray
        byte[] respByteArray=response.asByteArray();
        System.out.println(Arrays.toString(respByteArray));//[123, 32, 34, 105, 100, 34, 58, 32, 49, 44, 32, 34, 110, 97, 109, 101, 34, 58, 32, 34, 83, 117, 109, 105, 116, 34, 32, 125]

        Files.write(Paths.get("byteArrayResponse.json"), respByteArray);
        //As String
        String resp= response.asString();
        System.out.println(resp); //{ "id": 1, "name": "Sumit" }

        //as POJO
        try {
            SampleUser user = response.as(SampleUser.class);// class

            System.out.println(user); //SampleUser(id=1, name=Sumit)
        }
        catch (Exception oex){
            oex.printStackTrace();
        }

        //Jsonpath
        JsonPath jsonpath=response.jsonPath();

        String name=jsonpath.getString("name"); //Sumit

        //path
        String idUsingPath=response.path("id");
        System.out.println(idUsingPath);


        //Extract with jsonpath
        String id=response.then().extract().jsonPath().getString("id");//1


        //
        System.out.println(response.then().extract().headers().toString());
        //Content-Type=application/json
        //Matched-Stub-Id=e1a4cb41-3700-4653-a745-562781caebc2
        //Content-Encoding=gzip
        //Transfer-Encoding=chunked

        System.out.println(response.then().extract().header("Content-Encoding"));
        //gzip

        wireMockServer.stop();
    }



    @Test
    public void compareResponses(){

        String s1="{ \"id\": 1, \"name\": \"Sumit\" }";
        String s2="{ \"id\": 1, \"name\": \"Sumit\" }";
        String s3="{ \"id\": 1, \"name\": \"Sumitr\" }";


        JsonPath jsonPath1=new JsonPath(s1);
        JsonPath jsonPath2=new JsonPath(s2);
        JsonPath jsonPath3=new JsonPath(s3);

        System.out.println(jsonPath1.getMap("").equals(jsonPath2.getMap("")));//true
        System.out.println(jsonPath2.getMap("").equals(jsonPath3.getMap("")));//false






    }



}

@Data
@Getter
@Setter
@ToString
class SampleUser
{
  int id;
  String name;
}

