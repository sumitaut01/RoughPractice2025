package restassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Rough {

    @Test
    public void Rough1() throws JsonProcessingException {


        String str = """
                                
                [
                {
                                
                "userName": "sumit",
                 "Salary": 2000
                }
                ,
                
                {
                 "userName": "Neha",
                 "Salary": 10
                },
                
                 {
                 "userName": "sumit",
                 "Salary": 10
                }
                ]
                                
                """;


        JsonPath jsonPath=JsonPath.from(str);

        System.out.println(jsonPath.getString("[0].userName"));
        System.out.println(jsonPath.getString("[1].Salary"));

        System.out.println(jsonPath.getList("findAll{it->it.userName=='sumit'}.Salary"));//[2000, 10]


    }
}
