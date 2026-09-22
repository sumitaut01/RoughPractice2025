package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class R_XRedicts {


    /*

    Default behaviour is to get the response from redirected endpoint
     */
    public static void main(String[] args) {

        given().baseUri("").basePath("")
                .header("","")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .redirects().follow(true)// so this is by default.. we dont need to do it explicity
                .get();

        //Same as
        given().baseUri("").basePath("")
                .header("","")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get();



        //So for API testing, if your requirement is "verify that this old endpoint returns 301",
        // explicitly use follow(false). Otherwise, you could accidentally test the redirected endpoint instead.

        given()
                .redirects().follow(false)
                .when()
                .get("/old-endpoint")
                .then()
                .statusCode(301);

    }
}
