package restassured.roughpractice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import restassured.roughpractice.serialization.Users;


import java.util.List;

public class R1_First {

    public static void main(String[] args) throws JsonProcessingException {
        //35828e58794f1d639a1490cb7e338836d6cfc485897f798efab0900194d4d29c
//curl -i -H "Accept:application/json"
// -H "Content-Type:application/json"
// -H "Authorization: Bearer 35828e58794f1d639a1490cb7e338836d6cfc485897f798efab0900194d4d29c"
// -XGET "https://gorest.co.in/public/v2/users"


        Response response=RestAssured.given()
                .baseUri("https://gorest.co.in/public/v2/users")
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 35828e58794f1d639a1490cb7e338836d6cfc485897f798efab0900194d4d29c")
                .accept(ContentType.JSON)
                .get();


        response.prettyPrint();

        List<Users> usersList=new ObjectMapper().readValue(response.asString(), new TypeReference<>() {
        });


        System.out.println(usersList);
        System.out.println(usersList.get(0));
        System.out.println(usersList.get(0).getEmail());





    }
}
