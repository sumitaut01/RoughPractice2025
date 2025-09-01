package basics.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteExcel {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("Users.xlsx");
        Workbook workbook = new XSSFWorkbook(fis);
        fis.close();

        Sheet sheet = workbook.getSheet("Users");

        // Create new row and add data
        int lastRow = sheet.getLastRowNum() + 1;
        Row newRow = sheet.createRow(lastRow);
        newRow.createCell(0).setCellValue("Rohit");
        newRow.createCell(1).setCellValue(26);

        // Write changes back
        FileOutputStream fos = new FileOutputStream("Users.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();

        System.out.println("Data added successfully!");
    }
}
