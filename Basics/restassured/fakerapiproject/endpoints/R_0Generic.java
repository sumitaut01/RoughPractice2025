package restassured.fakerapiproject.endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class R_0Generic {

    public static Response getProducts(){
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .baseUri("https://fakestoreapi.com/")
                .get("/products");
    }
}
