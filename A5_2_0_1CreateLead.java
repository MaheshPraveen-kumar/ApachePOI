package ApachePoI;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class A5_2_0_1CreateLead extends A5_1_BaseClass {

	@DataProvider(name="feachData")
	public String[][] SendtData() throws IOException
	{
		A5_2_0ReadExcel read=new A5_2_0ReadExcel();
		String[][] data = read.readExcel();
		return data;
				
	}
	
	@Test(dataProvider = "feachData")
	public void creatLead(String cName,String fName,String lname) throws InterruptedException
	{
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		  WebElement company= driver.findElementById("createLeadForm_companyName");
		  company.sendKeys(cName);
		  driver.findElementById("createLeadForm_firstName").sendKeys(fName);
		  driver.findElementById("createLeadForm_lastName").sendKeys(lname);
		  
		 
		  
		  //enter the country value as India using Visible Text 
		  WebElement country =driver.findElementById("createLeadForm_generalCountryGeoId"); 
		  Select dropcountry= new Select(country); 
		  dropcountry.selectByVisibleText("India");
		  Thread.sleep(500);
		  System.out.println("closing createLead");
		  driver.findElementByName("submitButton").click();
	}
	

}
