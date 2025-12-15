package basics.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Rough {


    @Test
    public void Rought1() throws IOException {
        Workbook workbook=new XSSFWorkbook();
        Sheet sheet=workbook.createSheet("first");
        Row row=sheet.createRow(0);
        Cell cell=row.createCell(0);
        cell.setCellValue("some data");

        FileOutputStream fileOutputStream=new FileOutputStream("roughExcel.xls");
        workbook.write(fileOutputStream);

        workbook.close();
        fileOutputStream.close();
    }


    @Test
    public void Rough2() throws IOException {

        FileInputStream fis=new FileInputStream("roughExcel.xls");


        Workbook workbook=new XSSFWorkbook(fis);
        Sheet sheet=workbook.getSheetAt(0);

        int rowCount=sheet.getLastRowNum();

        for(int i=0;i<rowCount;i++){

          Row row=sheet.getRow(i);
          int totalCells=row.getLastCellNum();

        for(int j=0;j<totalCells;j++){

            DataFormatter df=new DataFormatter();
            System.out.println(row.getCell(j).getStringCellValue());
        }


        workbook.close();
        fis.close();
        }







    }
}
