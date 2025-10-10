package restassured;

import java.io.File;

import static io.restassured.RestAssured.given;

public class R9_FileUpload {

    //multipart(
    //

    public static void main(String[] args) {


        given().multiPart("file1", new File("a.txt"))
                .multiPart("file2", new File("b.txt"))
                .post("/upload");
    }
}
