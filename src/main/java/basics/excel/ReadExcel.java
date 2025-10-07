package basics.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("Users.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet("Users");

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                DataFormatter df = new DataFormatter();
                String value = df.formatCellValue(cell); // handles all types
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        workbook.close();
        fis.close();
    }




    @Test
    public void test() throws IOException {

        Workbook workbook=new XSSFWorkbook(new FileInputStream("Users.xlsx"));

        Sheet sheet=workbook.getSheet("Users");
        int rowCount= sheet.getLastRowNum();

        for(int i=0;i<rowCount;i++){
            Row row= sheet.getRow(i);
            for(int j=0;j<row.getLastCellNum();j++){
                String data=row.getCell(j).getStringCellValue();
                System.out.print(data+ " ");
            }
            System.out.println("");
        }
        workbook.close();
    }
}





