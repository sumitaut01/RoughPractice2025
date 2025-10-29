package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RoughAll {

    public static void main(String[] args) throws JsonProcessingException {


        Response response=RestAssured.given().header("","")
                .contentType(ContentType.JSON)
                .baseUri("")
                .basePath("")
                .queryParam("S", "s")
                .pathParam("pathparakey", "2")
                .auth().oauth2(" ")
                .post("{pathparakey}/somemoreurl");


        JsonPath jsonpath=response.jsonPath();

        Temp t=response.as(Temp.class);


        ObjectMapper objectMapper= new ObjectMapper();
        Temp xx=objectMapper.readValue(response.asString(), Temp.class);







    }


}


class Temp{


}
