package ApachePoI;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class A4_ReadExcelDynamicRowcolum {

	public static void main(String[] args) throws IOException 
	{
		// to read data for multiple row with single Dynamic column  use for loop
		XSSFWorkbook wb=new XSSFWorkbook("./DataPOI/CreateLead.xlsx");	
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		System.out.println("exclude First row count: "+rowCount);
		
		// to count the first row
		int include_FirstRow = sheet.getPhysicalNumberOfRows();
		
		int cellCount = sheet.getRow(0).getLastCellNum();
		
		System.out.println("include First row count: "+include_FirstRow);
		System.out.println("NO.of.cell or column :"+cellCount);
		for (int i = 1; i <= rowCount; i++) 
			
		{
			for (int j = 0; j < cellCount; j++)
			{				
				String CellValue = sheet.getRow(i).getCell(j).getStringCellValue();				
				System.out.print(CellValue+ " ");
			}
			System.out.println(" ");
		}	
		wb.close();
				


	}

}
