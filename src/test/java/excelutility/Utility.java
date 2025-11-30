package excelutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Utility {

    // ✅ Read a specific cell value (row, column)
    public static String getCellValue(String xl, String sheetName, int r, int c) {
        try (FileInputStream fi = new FileInputStream(xl);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {

            XSSFSheet sh = wb.getSheet(sheetName);
            if (sh == null) return "";

            if (sh.getRow(r) == null || sh.getRow(r).getCell(c) == null)
                return "";

            XSSFCell cell = sh.getRow(r).getCell(c);

            if (cell.getCellType() == CellType.STRING)
                return cell.getStringCellValue().trim();
            else if (cell.getCellType() == CellType.NUMERIC)
                return String.valueOf((long) cell.getNumericCellValue()); // avoids .0
            else
                return cell.toString().trim();

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    // ✅ Get total number of rows in the sheet
    public static int getRowCount(String xl, String sheetName) {
        try (FileInputStream fi = new FileInputStream(xl);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {

            XSSFSheet sh = wb.getSheet(sheetName);
            if (sh == null) return 0;
            return sh.getPhysicalNumberOfRows();  // counts only non-empty rows

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }}

	
