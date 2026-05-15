package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class logifFails {

  @Test
          public void Pass(){



        RestAssured.given().
                baseUri("").basePath("")
                // .header("").
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("").log().all()
                .post()
                .then().log().ifValidationFails();


    }


    @Test
    public void Fail(){
        RestAssured.given().
                baseUri("").basePath("")
                // .header("").
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("").log().all()
                .post()
                .then().log().ifValidationFails();


    }
}
