package basicsold.filehandling;

// Summary
//         Class	Reads from	Speed	Extra Features
//         FileReader	File	Slow (1 char)	Basic read
//         BufferedReader	FileReader	Fast (buffered)	readLine() etc.
//
//         FileReader
//         Reads data character by character
//         Good for small files
//         Not very efficient for larger files (slow)
//         FileReader fr = new FileReader("file.txt");
//         int ch;
//         while ((ch = fr.read()) != -1) {
//         System.out.print((char) ch);
//         }
//         ❗️This reads one character at a time, causing frequent disk access — slow!
//
//
//         BufferedReader
//         Wraps around another Reader like FileReader
//         Adds a buffered layer, reading a chunk (like 8KB) at once internally
//         Improves performance for large files
//         Also provides readLine() method (very handy!)
//
//         BufferedReader br = new BufferedReader(new FileReader("file.txt"));
//         String line;
//         while ((line = br.readLine()) != null) {
//         System.out.println(line);
//         }


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderDemo {

    public static void main(String[] args) throws IOException {

        try(FileWriter writer=new FileWriter("demo.txt")){
            writer.write("first");
            writer.write("second");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(FileReader reader=new FileReader("demo.txt")){
            int ch;
            while((ch = reader.read()) != -1)
                System.out.println((char)ch);

            }
        }

    }

//    f
//            i
//    r
//            s
//    t
//            s
//    e
//            c
//    o
//            n
//d