package basics;

import org.apache.xmlbeans.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceLoaderFiles {

    public static void main(String[] args) throws IOException {


        InputStream inputStream=ResourceLoader.class.getClassLoader().getResourceAsStream("demo.txt");

        Files.newInputStream(Path.of("demo.txt"));

    }
}
