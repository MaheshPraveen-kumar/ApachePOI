package ApachePoI;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class A5_1_BaseClass {
	
	public ChromeDriver driver;
	public String excelfilename;
	
	@DataProvider(name="frechEditData")
	public String[][] sendData() throws IOException
	{
		A5_2_1ReadExcelDynamicFile read=new A5_2_1ReadExcelDynamicFile();
		//String[][] data = read.readExcel("EditLead");
		String[][] data = read.readExcel(excelfilename);
		return data;
	}
	
	@BeforeMethod
	public void startApp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
	}

	@AfterMethod
	public void closeApplication()
	{
		driver.close();
	}
}
