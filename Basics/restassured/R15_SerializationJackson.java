package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.Getter;
import lombok.Setter;


//
public class R15_SerializationJackson {

    public static void main(String[] args) throws JsonProcessingException {

        Student stu = new Student("Sumit", 12);
        ObjectMapper objectMapper = new ObjectMapper();
        String deser = objectMapper.writeValueAsString(stu);
        System.out.println(deser);//{"name":"Sumit","age":12}


        // with object only. not converting to string.. jackson takes care of it
        //jackson needs getters and setters else we get  No serializer found for class restassured.UserDemo
        //Serialization does not need default constructor
        //Deser will need no args constructor unless you are using some other alternatives
        serialization();

    }


    public static void serialization() {
        // we can send java object as per Pavan.. no need of object mapper
//x-api-key: reqres-free-v1
        UserDemo demo=new UserDemo("sumit", "s@s.com","pass");
      int status=  RestAssured.given().baseUri("https://reqres.in")
                .header("x-api-key", "reqres-free-v1").contentType(ContentType.JSON)
                .body(demo)
                .post("/register").getStatusCode();

        System.out.println(status);
    }
}

    class UserDemo{
    @Getter
            @Setter
        String username;
        String email;
        String password;

      //  public UserDemo(){};

        public UserDemo(String username, String email, String password) {
            this.username = username;
            this.email = email;
            this.password = password;
        }
    }




