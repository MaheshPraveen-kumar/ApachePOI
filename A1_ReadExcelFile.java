package ApachePoI;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class A1_ReadExcelFile 
{
	
	public static void main(String[] args) throws IOException 
	{
		//1. to open workbook and set the location
		XSSFWorkbook wb=new XSSFWorkbook("./DataPOI/CreateLead.xlsx");
		//2. go inside the worksheet
		XSSFSheet sheet = wb.getSheet("Sheet1");
		//3.go inside the row
		XSSFRow row = sheet.getRow(1);
		//4. go inside the cell
		XSSFCell cell = row.getCell(0);
		String stringCellValue = cell.getStringCellValue();
		System.out.println(stringCellValue);
		// to close the work book
		wb.close();
	}
}
