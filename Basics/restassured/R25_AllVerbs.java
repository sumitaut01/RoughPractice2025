package restassured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import static io.restassured.RestAssured.given;

public class R25_AllVerbs {


    public static void main(String[] args) {
        //1
       getDemo();

        //2 File upload
        Response resp= postFileUpload();
        System.out.println(resp.asString());//{"filename":"SerializationAndDeserialization.docx","size":"17894","status":"uploaded"}

        //3 Post with Authorization
         resp= postWithAuthorization();
        System.out.println(resp.asString());



    }

    public static RequestSpecification setRequestSpecification(){
      return  given().baseUri("http://localhost:8080/").basePath("api/");
    }


    public static void getDemo(){
    Response resp=setRequestSpecification().get("/hello");
        System.out.println(resp.getStatusCode());
        System.out.println(resp.asString());
        //200
        //{"message":"Hello from GET endpoint!"}

    }

    public void postDemo(){


    }


    public void postText(){


    }

    public static Response postFileUpload(){
        File file=new File("D:\\Resurrection 2025\\APISpringBoot\\RestApiPractice\\src\\main\\resources\\SerializationAndDeserialization.docx");
      return   setRequestSpecification().multiPart(file).
        multiPart("description", "description")
                .post("upload");

    }


    public static Response postWithAuthorization(){
        return   setRequestSpecification().header("Authorization","Bearer secret")
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"Sumit\", \"age\": 30 }")
                .post("secure-data");

    }
}
