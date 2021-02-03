package ApachePoI;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class A5_2_1ReadExcelDynamicFile 
{
	public String[][] readExcel(String filename) throws IOException 
	{
		XSSFWorkbook wb=new XSSFWorkbook("./DataPOI/"+filename+".xlsx");	
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		System.out.println("exclude First row count: "+rowCount);
		int cellCount = sheet.getRow(0).getLastCellNum();
		System.out.println("NO.of.cell or column :"+cellCount);
		
		// Read Data From Excel to do dynamic
		String[][] data =new String[rowCount][cellCount];
		for (int i = 1; i <= rowCount; i++) 
			
		{
			for (int j = 0; j < cellCount; j++)
			{				
				String CellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				// i want to save it as 0
				data[i-1][j]=CellValue;
				System.out.print(CellValue+ " ");
			}
			
		}	
		wb.close();
		return data;
				


	}
}
