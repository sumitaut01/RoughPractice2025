package restassured;

import io.restassured.common.mapper.TypeRef;

import java.util.List;

import static io.restassured.RestAssured.given;

public class R_10ResponseAsTypeDef {


    /*

    1. Basic .as(ClassName.class) — Deserialize to a Single Object
This converts (deserializes) the JSON response into a Java object.
Example JSON response:
json{
  "id": 1,
  "name": "John",
  "age": 25
}
POJO class:
javapublic class User {
    private int id;
    private String name;
    private int age;

    // Getters and Setters
}
Using .as():
javaUser user = given()
    .when()
        .get("/users/1")
    .then()
        .extract().response().as(User.class);

System.out.println(user.getName()); // John
REST Assured uses Jackson or Gson under the hood to map JSON fields to Java fields.
     */

    public static void main(String[] args) {

        /*
       2. What is TypeRef (as typedef / generic type)?
The problem with .as() is it cannot handle generics like List<User> directly due to Java's type erasure — at runtime, Java doesn't know the generic type.
So this won't work properly:
javaList<User> users = response.as(List.class); // ❌ You get List<LinkedHashMap>, not List<User>
Solution — use TypeRef:
         */

        List<User> users = given()
                .when()
                .get("/users")
                .then()
                .extract().response().as(new TypeRef<List<User>>() {});

        System.out.println(users.get(0).getName()); // John


    }
}
