package restassured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.internal.ResponseSpecificationImpl;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RX_RequestSpec {


    public static void main(String[] args) {

        //Create user
        //curl -i
        // -H "Accept:application/json" -H "Content-Type:application/json" -H "Authorization: Bearer 35828e58794f1d639a1490cb7e338836d6cfc485897f798efab0900194d4d29c" -XPOST "http://gorest.co.in/public/v2/users"
        // -d '{"name":"Tenali Ramakrishna", "gender":"male", "email":"tenali.ramakrishna@15ce.com", "status":"active"}'


        String sBody = """
    {
        "name": "Tenali Ramakrishna",
        "gender": "male",
        "email": "tenali.ramakrishna15ce@example.com",
        "status": "active"
    }
    """;
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://gorest.co.in/public")
                .setBasePath("v2/")
                .addPathParam("users", "users")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("Authorization", "Bearer 35828e58794f1d639a1490cb7e338836d6cfc485897f798efab0900194d4d29c");
        RequestSpecification requestSpec = builder.build();

        ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);

        ResponseSpecification resp=responseSpecBuilder.build();
        RestAssured.given().spec(requestSpec).body(sBody).post("{users}")
                .then()
                .spec(resp); //Expected status code <200> but was <301>.

    }
}
