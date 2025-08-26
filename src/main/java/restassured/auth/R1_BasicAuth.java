package restassured.auth;

//https://postman-echo.com/basic-auth
//postman/password
//# username /password encoded( NOT encrypted) in request

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class R1_BasicAuth {

    public static void main(String[] args) {
      //  Response response=RestAssured.given().auth().basic("postman", "password")
        RestAssured.given().auth().basic("postman", "password")
                .baseUri("https://postman-echo.com")
                .basePath("/basic-auth").log().all().get().then().log().all();

        //HTTP/1.1 200 OK
        //Date: Wed, 20 Aug 2025 04:07:09 GMT
        //Content-Type: application/json; charset=utf-8
        //Content-Length: 27
        //Connection: keep-alive
        //Server: nginx
        //ETag: W/"1b-o64KRFi1Uw+73hnrS1UFKUVInOY"
        //set-cookie: sails.sid=s%3ATTHP_UxGSX0v0WhC3dM_SumE1tGWSJfB.jvo%2Bq%2FaQZgbw%2BCBfWmBgD1uGYL1uCtKz8uFuDWlBofI; Path=/; HttpOnly
        //
        //{
        //    "authenticated": true
        //}
        //io.restassured.internal.ValidatableResponseImpl@26a2f7f9


//2 Invalid
       Response  response=RestAssured.given().auth().basic("postm", "password")
                .baseUri("https://postman-echo.com")
                .basePath("/basic-auth")
                .get();
        System.out.println(response.then().log().all());

    }
}
