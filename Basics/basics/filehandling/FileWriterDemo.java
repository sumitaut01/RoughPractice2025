package basics.filehandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

    public static void main(String[] args) {

//        Overwrites file if it already exists
//        Not buffered — not ideal for large or repeated writes

       try (FileWriter writer=new FileWriter("out.txt")){
           writer.write("Hello from FileWriter!");


       } catch (IOException e) {
           e.printStackTrace();
       }

    }
}
