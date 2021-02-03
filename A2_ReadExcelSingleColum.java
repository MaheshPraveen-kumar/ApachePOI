package ApachePoI;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class A2_ReadExcelSingleColum {

	public static void main(String[] args) throws IOException 
	{
		// to read data for multiple row with single column use for loop
		XSSFWorkbook wb=new XSSFWorkbook("./DataPOI/CreateLead.xlsx");	
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		for (int i = 0; i <= 2; i++) 
		{
			String CellValue = sheet.getRow(i).getCell(0).getStringCellValue();
		/*	XSSFRow row = sheet.getRow(i);			
			XSSFCell cell = row.getCell(0);
			String CellValue = cell.getStringCellValue();*/
			System.out.println(CellValue);  
		}	
		wb.close();
	}

}
