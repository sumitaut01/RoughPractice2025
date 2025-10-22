package basics.filehandling;

import java.io.*;
import java.util.Arrays;

import java.io.*;
import java.util.Arrays;

public class InputStreamDemo {
    public static void main(String[] args) {
        File file = new File("pom.xml");

        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = inputStream.readAllBytes(); // Read entire file
            System.out.println(Arrays.toString(bytes));
        } catch (Exception e) {
            System.out.println("Some Exception: " + e.getMessage());
        }
    }
}
