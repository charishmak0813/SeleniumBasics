package Basics;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFile {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // Reading file


        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/testData/data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int totalRows = sheet.getLastRowNum();// till we have data.
        int totalCells =  sheet.getRow(1).getLastCellNum();
        for (int r = 0; r <= totalRows; r++) {
            XSSFRow currentRow = sheet.getRow(r);
            for (int c = 0; c < totalCells; c++) {
                XSSFCell currentCell = currentRow.getCell(c);
                System.out.print(currentCell.toString() +"\t");
            }
            System.out.println();
        }
        workbook.close();
        fis.close();

        // writing to Excel
        FileOutputStream file1 = new FileOutputStream(System.getProperty("user.dir")+"/path");
        XSSFWorkbook wb1 = new XSSFWorkbook();
        XSSFSheet sheet1 = wb1.createSheet("Data");
        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Java");
        wb1.write(file1);
        wb1.close();
        file1.close();
    }
}
