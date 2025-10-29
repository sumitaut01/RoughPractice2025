package basics.excelReader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public static void main(String[] args) throws IOException {


        FileInputStream fis=new FileInputStream("ReadExcel.xlsx");
        Workbook workbook=new XSSFWorkbook(fis);

        Sheet sheet =workbook.getSheet("Sheet1");

        int totalRows=sheet.getLastRowNum();
        System.out.println("totalRows are:"+totalRows);

        for(int i=0;i<totalRows;i++){

            Row row=sheet.getRow(i);
            int totalColinRow=row.getLastCellNum();
            for(int j=0;j<totalColinRow;j++){

                String data=row.getCell(j).getStringCellValue();
               // DataFormatter df=new DataFormatter();

                System.out.print(data+" ");
            }

            System.out.println(" ");


//totalRows are:3
//username password active
//sumit pwd yes
//amit pwd no

        }




    }




}
