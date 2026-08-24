package basics.files_separator_windows_mac;

import java.io.File;

public class FilesSeparatorDemo {

    public static void main(String[] args) {

        String path = "C:\\Users\\Sumit\\Downloads\\test.pdf"; //Windows

        //Mac
        //String path = "/Users/sumit/Downloads/test.pdf";

        //Solution
        String pathGlobal = System.getProperty("user.home")
                + File.separator
                + "Downloads"
                + File.separator
                + "test.pdf";


        System.out.println(pathGlobal);//C:\Users\sumit\Downloads\test.pdf  this would work on windows and mac


        String downloadDir =
                System.getProperty("user.home")
                        + File.separator
                        + "Downloads"; //C:\Users\sumit\Downloads



    }
}
