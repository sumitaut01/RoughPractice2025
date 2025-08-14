package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.eclipse.jetty.http.HttpTester;


public class R11_ObjectMapper {


    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        User user = new User("Sumit", 30);
        String body= objectMapper.writeValueAsString(user);//1
        System.out.println(body);//{"name":"Sumit"}
        RestAssured.given().body(body).post();


        byte[] body2= objectMapper.writeValueAsBytes(user);//1
        Response response=RestAssured.given().body(body2).post();








    }


}


class User{
    String name;
    int age;
    public User(String name,int age) {
        this.name = name;
        this.age=age;

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
