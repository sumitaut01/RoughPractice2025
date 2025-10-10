package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

public class Rx_Cookie {


    public static void main(String[] args) {


        Cookie cookie = new Cookie.Builder("token","abc").setSecured(true).build();

        Response response=RestAssured.given()
                .baseUri("")
                .basePath("")
                .header("","").contentType(ContentType.JSON)
                .cookie(cookie)
                .body("")
                .post();

        System.out.println(response);

        System.out.println(response.then().extract().body().toString());
        System.out.println(response.then().extract().header(""));

        System.out.println(response.jsonPath().getString(""));



    }
}
