package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class XmlRequest {

//https://ecs.syr.edu/faculty/fawcett/handouts/cse686/code/calcWebService/Calc.asmx
    @Test
    public void Test(){

       Response response= RestAssured.given().
                baseUri("").basePath("")
               // .header("").
                .contentType(ContentType.XML)
                .accept(ContentType.XML)
                .body("")
                .post();


       XmlPath xmlPath=response.xmlPath();



    }
}
