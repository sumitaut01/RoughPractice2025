package restassured.auth;

import io.restassured.RestAssured;

public class R2_Bearer {

    public static void main(String[] args) {
        RestAssured.given().auth().digest("postman", "password")
                .baseUri("https://postman-echo.com")
                .basePath("/digest-auth")
                .log().all()
                .get().then().log().all();
    }
}
