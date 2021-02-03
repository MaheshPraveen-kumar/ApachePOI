package ApachePoI;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A5_2_3EditLead extends A5_1_BaseClass {

	@BeforeTest
	public void setfilename()
	{
		excelfilename="EditLead";
	}
	
	@Test(dataProvider = "frechEditData")
	public  void editLead(String ph,String cName ) throws InterruptedException 
	{
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(ph);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys(cName);
		driver.findElementByName("submitButton").click();
	}
	
/*	@DataProvider(name="frechEditData")
	public String[][] sendData() throws IOException
	{
		A5_2_1ReadExcelDynamicFile read=new A5_2_1ReadExcelDynamicFile();
		//String[][] data = read.readExcel("EditLead");
		String[][] data = read.readExcel(excelfilename);
		return data;
	}
	*/
		

	

}
