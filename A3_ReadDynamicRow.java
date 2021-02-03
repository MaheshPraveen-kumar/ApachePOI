package ApachePoI;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class A3_ReadDynamicRow {

	public static void main(String[] args) throws IOException 
	{
// to read data for multiple row with single column use for loop
		XSSFWorkbook wb=new XSSFWorkbook("./DataPOI/CreateLead.xlsx");	
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		System.out.println("exclude First row count: "+rowCount);
		
		// to count the first row
		int include_FirstRow = sheet.getPhysicalNumberOfRows();
		
		System.out.println("include First row count: "+include_FirstRow);
		/*for (int i = 1; i <= rowCount; i++) 
		{
			String CellValue = sheet.getRow(i).getCell(0).getStringCellValue();
			XSSFRow row = sheet.getRow(i);			
			XSSFCell cell = row.getCell(0);
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
		}	*/
		wb.close();
		

	}

}
