package basics.filehandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesNio {

    public static void main(String[] args) throws IOException {

        FilesNio(); //{ "id": 1, "name": "Sumit" }
    }


    public static void FilesNio() throws IOException {
        String payload = Files.readString(Paths.get("byteArrayResponse.json"));

        //given().body(payload).post("/users");
        System.out.println(payload);
    }
}
