//package selenium.misc;
//import org.openqa.selenium.PrintsPage;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.print.PrintOptions;
//
//import java.io.FileOutputStream;
//import java.util.Base64;
//
//
//
//    public class SavePageAsPDF {
//        public static void main(String[] args) throws Exception {
//            ChromeDriver driver = new ChromeDriver();
//            driver.get("https://www.selenium.dev");
//
//            PrintOptions printOptions = new PrintOptions();
//            String base64PDF = ((PrintsPage) driver).print(printOptions);
//
//            byte[] pdf = Base64.getDecoder().decode(base64PDF);
//            try (FileOutputStream fos = new FileOutputStream("output.pdf")) {
//                fos.write(pdf);
//            }
//
//            driver.quit();
//        }
//    }
//
//
//
