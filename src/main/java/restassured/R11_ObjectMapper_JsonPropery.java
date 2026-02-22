package restassured;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Data;
import lombok.ToString;
import org.testng.annotations.Test;


public class R11_ObjectMapper_JsonPropery {
    public static void main(String[] args) throws JsonProcessingException {

        // json property must match address name.. hence below will fail for address
        ObjectMapper objectMapper=new ObjectMapper();
        User user = new User("Sumit", 30);
        String body= objectMapper.writeValueAsString(user);//1
        System.out.println(body);//{"name":"Sumit"}
       // RestAssured.given().body(body).post();


        byte[] body2= objectMapper.writeValueAsBytes(user);//1
       // Response response=RestAssured.given().body(body2).post();

    }




    @Test
    public void ProperyNameMismatch() throws JsonProcessingException {

        String dummyJson= """
                
                {
                  "name": "sumit",
                  "lastName":"raut",
                  
                  "address":
                  {
                  "city":"bhandara",
                  "pincode":44904                
                  }                
                }
                
                """;

        Studentxx xx=new ObjectMapper().readValue(dummyJson, Studentxx.class);

        System.out.println(xx);

    }



    @Test
    public void ProperyNameMismatch_Fixed() throws JsonProcessingException {

        String dummyJson= """
                
                {
                  "name": "sumit",
                  "lastName":"raut",
                  
                  "addressxx":
                  {
                  "city":"bhandara",
                  "pincode":44904                
                  }                
                }
                
                """;

        Studentxx xx=new ObjectMapper().readValue(dummyJson, Studentxx.class);

        System.out.println(xx);
//Studentxx(name=sumit, lastName=raut, addressxx=Addressxx(city=bhandara, pincode=44904))
    }



    @Test
    public void UseJsonProperty() throws JsonProcessingException {

        String dummyJson= """
                
                {
                  "name": "sumit",
                  "lastName":"raut",
                  
                  "address":
                  {
                  "city":"bhandara",
                  "pincode":44904                
                  }                
                }
                
                """;

        Studentyy yy=new ObjectMapper().readValue(dummyJson, Studentyy.class);
        /*
        Notice the pojo change
        @JsonProperty("address")
    Addressyy  addressyy;
         */

        System.out.println(yy);
      //Studentyy(name=sumit, lastName=raut, addressyy=Addressyy(city=bhandara, pincode=44904))


    }


}

//-----------------------------------------------------------------------------------
@Data
@ToString
class Studentxx{
    String name;
    String lastName;
    Addressxx  addressxx;
}

@Data
@ToString
class Addressxx{
    String city;
    Integer pincode;
}



//-----------------------------------------------------------------------------------
@Data
@ToString
class Studentyy{
    String name;
    String lastName;
    @JsonProperty("address")
    Addressyy  addressyy;
}

@Data
@ToString
class Addressyy{
    String city;
    Integer pincode;
}

//-----------------------------------------------------------------------------------
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
