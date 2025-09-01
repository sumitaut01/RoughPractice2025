package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Rough {


    public static void main(String[] args) {


        Response response=RestAssured.given()
                .baseUri("").basePath("")
                .header("","").contentType(ContentType.JSON).auth().oauth2("")
                .body("string").post();
        System.out.println(response.jsonPath());
        System.out.println(response.asString());
    }
}
