package basics.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcel {
    public static void main(String[] args) throws IOException {
        Workbook workbook = new XSSFWorkbook();

        // Create a sheet
        Sheet sheet = workbook.createSheet("Users");

        // Create a row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Age");

        // Add data
        Row row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("Sumit");
        row1.createCell(1).setCellValue(30);

        Row row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("Amit");
        row2.createCell(1).setCellValue(28);

        // Write to file
        FileOutputStream fos = new FileOutputStream("Users.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();

        System.out.println("Excel file created successfully!");
    }
}
