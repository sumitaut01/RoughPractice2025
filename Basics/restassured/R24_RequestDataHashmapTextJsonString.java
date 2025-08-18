package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

public class R24_RequestDataHashmapTextJsonString {

    public static void main(String[] args) {

        //1 With HashMap
        HashMap<String, String> hm = new HashMap<>();
        hm.put("username", "sumit");
        hm.put("email", "s@s.com");
        hm.put("password", "mypass");
        postUserWithHashMap(hm);

//2 With String
        String st = """
                {
                  "id": 0,
                  "username": "string",
                  "email": "string",
                  "password": "string"
                }
                                
                """;
        postUserWithString(st);//{"id":11}

        //3 With UserObject

        Userdata userdata = new Userdata();
        userdata.setId(199);
        userdata.setPassword("ddd");
        userdata.setEmail("s@s.com");
        postUserWithUserObject(userdata);


    }


    public static void postUserWithHashMap(HashMap<String, String> hm) {

        //curl -X POST 'https://fakestoreapi.com/users' -H 'Content-Type: application/json' -d '{"username": "john_doe", "email": "john@example.com", "password": "pass123"}'
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .baseUri("https://fakestoreapi.com")
                .body(hm).post("/users");
        System.out.println(response.asString());//{"id":1}

    }


    public static void postUserWithString(String st) {
        //curl -X POST 'https://fakestoreapi.com/users' -H 'Content-Type: application/json' -d '{"username": "john_doe", "email": "john@example.com", "password": "pass123"}'
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .baseUri("https://fakestoreapi.com")
                .body(st).post("/users");
        System.out.println(response.asString());//{"id":11}

    }


    public static void postUserWithUserObject(Userdata userData) {
        //curl -X POST 'https://fakestoreapi.com/users' -H 'Content-Type: application/json' -d '{"username": "john_doe", "email": "john@example.com", "password": "pass123"}'
        Response response = RestAssured.given().contentType(ContentType.JSON)
                .baseUri("https://fakestoreapi.com")
                .body(userData).post("/users");
        System.out.println(response.asString());//{"id":11}

    }
}


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    class Userdata{
       int id;
           String      username;
        String    email;
        String     password;
    }


