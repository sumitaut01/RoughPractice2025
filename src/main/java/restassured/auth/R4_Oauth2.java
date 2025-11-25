package restassured.auth;

import io.restassured.RestAssured;

public class R4_Oauth2 {

    public static void main(String[] args) {
//1

        RestAssured.given()
                .auth()
                .oauth2("<access_token>")//  resuassured internally adds this Authorization: Bearer <token>
                .when()
                .get("https://yourapi.com/protected-endpoint")
                .then()
                .statusCode(200);


        //we can manually add as well given().header("Authorization", "Bearer " + token)
    }
}
