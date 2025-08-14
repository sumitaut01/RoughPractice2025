package basicsold.filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BuffereWriterDemo {

    public static void main(String[] args) {

//        Faster due to internal buffering
//✅ Allows newLine() for clean formatting
//✅ Great for writing multiple lines or big data
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("bfwritetr.txt"))){
            writer.write("new line");
            writer.newLine();
            writer.write("new line");
        }
        catch (Exception e){
            e.printStackTrace();
        }


        //Append to File (FileWriter(true))
        //new FileWriter("output.txt", true); // true = append mode
        try(BufferedWriter writer=new BufferedWriter(new FileWriter("bfwritetr2.txt",true))){
            writer.write("first line");
            writer.newLine();
            writer.write("new line");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //Appending

}
