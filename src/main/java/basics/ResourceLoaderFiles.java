package basics;

import org.apache.xmlbeans.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceLoaderFiles {

    public static void main(String[] args) throws IOException {


//        InputStream inputStream=ResourceLoader.class.getClassLoader().getResourceAsStream("demo.txt");
//
//        Files.newInputStream(Path.of("demo.txt"));


        // when file available in resources folder
        InputStream inputStream=ResourceLoader.class.getClassLoader().getResourceAsStream("resourceloaderfile.txt");
        System.out.println(new String(inputStream.readAllBytes()));
        //this is line 1 of resourceloaderfile.txt
        //this is line 2 of resourceloaderfile.txt
        //this is line 3 of resourceloaderfile.txt


        InputStream inputStream2=ResourceLoader.class.getClassLoader().getResourceAsStream("level1//level1.txt");
        System.out.println(new String(inputStream2.readAllBytes()));
        //this is line 1 of resourceloaderfile.txt
        //this is line 2 of resourceloaderfile.txt
        //this is line 3 of resourceloaderfile.txt


    }
}
