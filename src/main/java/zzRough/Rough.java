package zzRough;

import com.aventstack.extentreports.AnalysisTypeConfigurable;
import myproject.enums.BrowserType;
import org.apache.groovy.json.internal.Chr;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static zzRough.ExcelReader.CreateExcel;
import static zzRough.ExcelReader.xReadExcel;

public class Rough implements  Serializable {
    @Test
    public void Test1() {
        String str = " This is it";
        String ptn = "t";
        Pattern p = Pattern.compile(ptn);
        Matcher m = p.matcher(str.toLowerCase());
        int count = 0;
        while (m.find()) {
            count++;
        }
        System.out.println(count);
    }

    @Test
    public void rev() {
        int num = 1245;
        int rev = Integer.MIN_VALUE;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        System.out.println(rev);//4345
    }

    @Test
    public void secondMaxFromArray() {
        int arr[] = {3, 6, 5, 2, 8};

        int max = 0;
        int smax = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                smax = max;
                max = arr[i];
            } else {
                if (smax < arr[i]) {
                    smax = arr[i];
                }
            }
        }

        System.out.println(max + " " + smax);//8/6

    }

    //segregate 0 and 1
    @Test
    public void test() {

        int arr[] = {0, 1, 0, 1, 1, 0};
        int j = arr[0];
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        System.out.println(Arrays.toString(arr));

    }


    @Test
    public void window() {

        int[] arr = {1, 4, 5, 2, 3};
        int k = 3;
        int len = arr.length;
        int max = 0;
        int curr = 0;
        int i = 0;
        int j = 0;
        for (i = 0; i <= len - k; i++) {
            System.out.println("i is " + i);
            for (j = i; j < i + k; j++) {
                System.out.println("j is " + j + "value picked is " + arr[j]);
                curr = curr + arr[j];
            }
            System.out.println("i is " + i + " current sum is " + curr);
            max = Math.max(curr, max);
            System.out.println("i is " + i + " max sum is " + max);
            curr = 0;
        }
    }


    @Test
    public void sliding_window() {

        int[] arr = {1, 4, 5, 2, 3};
        int k = 3;
        int len = arr.length;
        int max = 0;
        int curr = 0;

        for (int i = 0; i < k; i++) {
            max += arr[i];
            System.out.println("intial max sum " + max);
        }

        for (int j = k; j < len; j++) {
            curr = max + arr[j] - arr[j - k];
            max = Math.max(max, curr);
        }
        System.out.println(max);//11
    }


    @Test
    public void ChapterCountMap() {

        String st = "sumitraut";
        int[] data = new int[256]; //0 to 255
        for (int i = 0; i < st.length(); i++) {
            data[(int) st.charAt(i)]++;
        }


        for (int j = 0; j < data.length; j++) {
            if (data[j] != 0) {
                char c = (char) j;
                int count = data[j];
                System.out.println(c + " " + count);
            }
        }
    }

    @Test
    public void enumTest() {

        enum myEnum {
            QA("qaurl"),
            UAT("uaturl");
            String url;

            myEnum(String str) {
                this.url = str;
            }

            public String getStr() {
                return url;
            }
        }
        myEnum qa = myEnum.QA;
        System.out.println(qa.getStr());//qaurl

    }

    @Test
    public void dummy() {

        for (int i = 0; i < 256; i++) {
            System.out.println((char) i);
        }

    }


    @Test
    public void Streams() {

        ArrayList<String> str = new ArrayList<>();
        str.add("sumit");

        Supplier<List<String>> sup = () -> str;
        sup.get().stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

//SUMIT


    }


    class P implements Serializable {
        int age;
        String name;

        public P(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    @Test
    public void RoughX() throws IOException, ClassNotFoundException {

        //Serialation
        P p = new P(35, "Sumit");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("P.ser"));
        objectOutputStream.writeObject(p);


        //Desri

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("P.ser"));
        P px = (P) inputStream.readObject();

        System.out.println(px.age + " " + px.name); //35 Sumit


    }



    //main


    public static void main(String[] args) throws Exception {


        CreateExcel();
        xReadExcel();
        DriverManagerTL.getDriver().get("http://www.google.com");
        DriverManagerTL.unload();
        }
    }









interface  DriverManager{
    WebDriver getDriver();
}


class ChromeDriverManager implements  DriverManager{
    @Override
    public  WebDriver getDriver() {
        return new ChromeDriver();
    }
}


enum BrowserTypeX{
    CHROME,
    EDGE
}

class DriverFactory{
     static WebDriver getDriver(BrowserTypeX browserType) throws Exception {
         BrowserTypeX type = BrowserTypeX.valueOf("CHROME");


         if (type == BrowserTypeX.CHROME) {
             return new ChromeDriverManager().getDriver();
         } else if (type == BrowserTypeX.EDGE) {
//            driver=new EdgeDriverManager().getDriver();
         } else {
             throw new Exception("Invalid Browser Type Provided");
         }
         return null;
     }
     }
 class DriverManagerTL {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void setDriver(BrowserTypeX browserType) throws Exception {
        WebDriver driver = DriverFactory.getDriver(browserType);
        driverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void unload() {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}


class ExcelReader{


    static void xReadExcel(){



    }

    static void CreateExcel() throws IOException {

        String fileName="CreateExcel.xlsx";
        FileOutputStream fileOutputStream=new FileOutputStream(fileName);
        Workbook workbook=new XSSFWorkbook();
        Sheet sheet=workbook.createSheet("First");
        Row row=sheet.createRow(0);
        Cell cell=row.createCell(0);
        cell.setCellValue("sumit");
        workbook.write(fileOutputStream);
        fileOutputStream.close();







    }


    static void ReadExcel() throws IOException {
        String fileName="CreateExcel.xlsx";
        FileInputStream fileInputStream=new FileInputStream(fileName);

        Workbook workbook=new XSSFWorkbook(fileInputStream);
        String s=workbook.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
        System.out.println(s);
    }





}


















