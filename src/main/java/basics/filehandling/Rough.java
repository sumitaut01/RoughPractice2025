package basics.filehandling;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Rough {


    @Test
    public void WriteReader() throws IOException {

        FileWriter fw=new FileWriter("fw.txt");
        fw.write("this is it");
        fw.close();


        FileReader reader=new FileReader("fw.txt");





    }
}
