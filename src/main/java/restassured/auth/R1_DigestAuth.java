package restassured.auth;

import io.restassured.RestAssured;
import io.restassured.response.Response;

//Same as basis but encrypts credentials
public class R1_DigestAuth {

    public static void main(String[] args) {

        RestAssured.given().auth().digest("postman", "password")
                .baseUri("https://postman-echo.com")
                .basePath("/digest-auth")
                .log().all()
                .get().then().log().all();

        //Request method:	GET
        //Request URI:	https://postman-echo.com/digest-auth
        //Proxy:			<none>
        //Request params:	<none>
        //Query params:	<none>
        //Form params:	<none>
        //Path params:	<none>
        //Headers:		Accept=*/*
        //Cookies:		<none>
        //Multiparts:		<none>
        //Body:			<none>


        //HTTP/1.1 200 OK
        //Date: Wed, 20 Aug 2025 04:38:23 GMT
        //Content-Type: application/json; charset=utf-8
        //Content-Length: 27
        //Connection: keep-alive
        //Server: nginx
        //ETag: W/"1b-o64KRFi1Uw+73hnrS1UFKUVInOY"
        //set-cookie: sails.sid=s%3ABaKUSUcJnzeJPIf3Ihfdzrrun43dHZGA.f9JG0PnlP48Ft8b5CSsa2NU2MbEDXay6txKYDcBEqHY; Path=/; HttpOnly
        //
        //{
        //    "authenticated": true
        //}





    }
}
