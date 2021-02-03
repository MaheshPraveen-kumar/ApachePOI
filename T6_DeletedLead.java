package ApachePoI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class T6_DeletedLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");
		driver.findElementByXPath("//input[@id='password'][@class='inputLogin']").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		//next page crmsfa
		driver.findElementByXPath("//div[@id='label']").click();
		// next page click Lead
		driver.findElementByXPath("//a[text()='Leads']").click();
		
		//next page click in FindLead
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//span[text()='Phone']/..").click();
		//Enter the phone number 99 not Country code and area code
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("99");
		//click on FindLead Button before that sleep with 3sec
		 //driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		 Thread.sleep(3000);
	    WebElement leadid= driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
	    String BeforeDeleted=leadid.getText(); 
	    System.out.println("the before deletion the value of id is : "+BeforeDeleted);
	    driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
	    
	    
	    //Click DELETE BUTTON
	    driver.findElementByXPath("//a[@class='subMenuButtonDangerous']").click();
	    
	    //Click on Find Lead Tag
	    driver.findElementByXPath("//a[text()='Find Leads']").click();
	    driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
	    // click on leadId to check the Deleted Lead
	    driver.findElementByXPath("//input[@name='id']").sendKeys(BeforeDeleted);
	    driver.findElementByXPath("//button[text()='Find Leads']").click();
	    
	    //vertified the message " No RECORD IS DISPLAY" USE getPagesource()
	    Thread.sleep(1000);
	    boolean msg=driver.getPageSource().contains("No records to display");
	    
	    // now check;
	    if(msg==true)
	    {
	    	System.out.println("No records is display in PageSource Scree");
	    	
	    }
	    else
	    {
	    	System.out.println("Record is display Deletion is not successfully");
	    }
	    driver.close();
	    }
	  		
	}


