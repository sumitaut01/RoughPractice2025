package myproject.tests;


import demo.threadlocal.DriverManager;
import myproject.Reporters.ExtentLogger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.time.Duration;

public class Test1 extends  BaseTest{
    @Test(groups = "smoke")
    public void googleTest() {

        ExtentLogger.logInfo("Test Execution started");
        System.out.println("Env: " + System.getProperty("env"));
        System.out.println("Base URL: " + System.getProperty("baseUrl"));
        System.out.println("DB URL: " + System.getProperty("dbUrl"));
        //mvn clean test -Puat
        //Env: uat
        //Base URL: https://uat.example.com
        //DB URL: jdbc:postgresql://uat-db:5432/testdb
        DriverManager.getDriver().get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        ExtentLogger.logInfo("title is "+DriverManager.getDriver().getTitle());
    }

    @Test
    public void facebookTest() {
        DriverManager.getDriver().get("https://www.facebook.com");
        ExtentLogger.logInfo("title is "+DriverManager.getDriver().getTitle());
        System.out.println("Title: " + driver.getTitle());
        Assert.fail(); // failing forcefully
    }

    @Test
    public void RoughSeleniumAmazon(){

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //
        By txtSearchBox=By.xpath("//input[@id='twotabsearchtextbox']");

        driver.findElement(txtSearchBox).sendKeys("iphone");
        driver.findElement(txtSearchBox).submit();
        String sWindowHandle=driver.getWindowHandle();

        By lnkSearchResults=By.xpath("//span[contains(text(),'iPhone')]/parent::h2/parent::a");

        System.out.println("current tile" +driver.getTitle());
        for(WebElement lnk: driver.findElements(lnkSearchResults)){

            System.out.println(lnk.getText());
            lnk.click();


            By txtProductTitleSpan=By.xpath("//span[@id='productTitle']");
            System.out.println(driver.getTitle());

            for(String s: driver.getWindowHandles()){

                System.out.println(s);
                System.out.println(driver.getTitle());
              if(!s.equals(sWindowHandle)){
                  driver.switchTo().window(s);
                  driver.findElement(txtProductTitleSpan).getText();
                  driver.close();

                  driver.switchTo().window(sWindowHandle);
              }

            }
        }
        driver.close();
        driver.quit();
    }


    @Test
    public void TestExcelCreate() throws IOException {
        Workbook workBook=new XSSFWorkbook();
        workBook.createSheet("MyWorkBook").createRow(0).createCell(0).setCellValue("Suumit");
        workBook.write(new FileOutputStream(new File("myExcel.xlsx")));
        workBook.close();
    }


    @Test
    public void TestExcelReadWrite() throws IOException {
        Workbook workBook=new XSSFWorkbook(new FileInputStream(new File("myExcel.xlsx")));

        Sheet sheet=workBook.getSheet("MyWorkBook");
        sheet.createRow(1).createCell(1).setCellValue("Amit");
        sheet.createRow(1).createCell(1).setCellValue("Neha");

        //loop
        sheet=workBook.getSheet("MyWorkBook");

        int rows=sheet.getLastRowNum();
        for(int i=0;i<rows;i++){

            int cells=sheet.getRow(i).getLastCellNum();

            for(int j=0;j<cells;j++){

                Cell cell=sheet.getRow(i).getCell(j);
                DataFormatter df = new DataFormatter();
                String value = df.formatCellValue(cell); // handles all types
                System.out.print(value + "\t");


            }
            System.out.println("");

        }
        workBook.write(new FileOutputStream(new File("myExcel.xlsx")));
        workBook.close();
    }


}
