package restassured.auth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class R2_Bearer {

    public static void main(String[] args) {

//Because email should be unique
        String str= """
                
                {
                    "name": "Tenali Ramakrishna",
                    "gender": "male",
                    "email": "#RANDOM#.ramakrishna@15ce.com",
                    "status": "active"
                }
                """;

        str=str.replace("#RANDOM#", String.valueOf((int)Math.random()));

        System.out.println(str);

        RestAssured.given()
                .baseUri("https://gorest.co.in")
                .basePath("/public/v2/users")
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 35828e58794f1d639a1490cb7e338836d6cfc485897f798efab0900194d4d29c")
                .body(str)
                .log().all()
                .post().then().log().all();
    }
}


//curl -i -H "Accept:application/json" -H "Content-Type:application/json" -H
// "Authorization: Bearer 35828e58794f1d639a1490cb7e338836d6cfc485897f798efab0900194d4d29c" -XPOST "https://gorest.co.in/public/v2/users" -d '{"name":"Tenali Ramakrishna", "gender":"male", "email":"tenali.ramakrishna@15ce.com", "status":"active"}'