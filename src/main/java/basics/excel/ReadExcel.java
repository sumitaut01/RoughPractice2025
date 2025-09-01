package basics.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
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
}
