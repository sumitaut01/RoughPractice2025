package restassured.auth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class R2_Bearer {

    public static void main(String[] args) {

//Because email should be unique
        String strOriginal= """            
                {
                    "name": "Tenali Ramakrishna",
                    "gender": "male",
                    "email": "#RANDOM#.ramakrishna@15ce.com",
                    "status": "active"
                }
                """;
        String str1=strOriginal.replace("#RANDOM#", String.valueOf(Math.random()));

        System.out.println(str1);
        RestAssured.given()
                .baseUri("https://gorest.co.in")
                .basePath("/public/v2/users")
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 35828e58794f1d639a1490cb7e338836d6cfc485897f798efab0900194d4d29c")

                //below does the same under the hood
                //  .auth().oauth2("35828e58794f1d639a1490cb7e338836d6cfc485897f798efab0900194d4d29c")
                .body(str1)
                .log().all()
                .post().then().log().all()

                .statusCode(201);


        System.out.println("-----separator----");
        String str2=strOriginal.replace("#RANDOM#", String.valueOf(Math.random()));
        System.out.println(str2);

           RestAssured.given()
                   .baseUri("https://gorest.co.in")
                .basePath("/public/v2/users")
                .contentType(ContentType.JSON)
                   .auth().oauth2("35828e58794f1d639a1490cb7e338836d6cfc485897f798efab0900194d4d29c")
                .body(str2)
                .log().all()
                .post().then().log().all()

                   .statusCode(201);
}
}


//curl -i -H "Accept:application/json" -H "Content-Type:application/json" -H
// "Authorization: Bearer 35828e58794f1d639a1490cb7e338836d6cfc485897f798efab0900194d4d29c" -XPOST "https://gorest.co.in/public/v2/users" -d '{"name":"Tenali Ramakrishna", "gender":"male", "email":"tenali.ramakrishna@15ce.com", "status":"active"}'