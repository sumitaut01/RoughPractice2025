package basics.filehandling;

import java.io.*;

public class ByteReading {

    public static void main(String[] args) throws IOException {


//        BufferedWriter bw=new BufferedWriter(new FileWriter("sample.txt"));
//        bw.write("some text");
//        bw.close();
        BufferedReader reader=new BufferedReader(new FileReader("sample.txt"));

        StringBuilder contentBuilder = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            // Example: Modify content — remove lines with "Delete"
            if (!line.contains("Delete")) {
                contentBuilder.append(line).append(System.lineSeparator());
            }
        }
        reader.close();

        contentBuilder.toString().getBytes();



        ByteArrayOutputStream baos=new ByteArrayOutputStream();

       // baos.write();



    }
}
