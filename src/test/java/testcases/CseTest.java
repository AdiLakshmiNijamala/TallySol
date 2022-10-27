package testcases;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import org.testng.annotations.Test;

import testbaseFile.TestBaseFile;


public class CseTest extends TestBaseFile{

	public WebDriver  driver;
	
	@BeforeTest
	public void startBrowser() throws IOException, InterruptedException {
		
		driver=initializeDriver();	
		System.out.println("For Checking");
	}
	@Test
	public void CseTestPage() throws InterruptedException {
		
		driver.findElement(By.xpath(loctrs.getProperty("cstmclick"))).click();
		
		driver.get("https://tally.force.com/s/cse-new");
		//driver.findElement(By.xpath(loctrs.getProperty("cseselect"))).click();
		
		Thread.sleep(1000);
		
		///Second Stage of testing///
		
		driver.findElement(By.xpath(loctrs.getProperty("Cmselect"))).click();
		driver.findElement(By.xpath(loctrs.getProperty("Next"))).click();
		driver.findElement(By.xpath(loctrs.getProperty("inputserial"))).sendKeys("753111414");
		driver.findElement(By.xpath(loctrs.getProperty("Next"))).click();
		
		Thread.sleep(3000);
		
		//Data Entering to Add CSE//
		
		//AccountName
		WebElement AccName = driver.findElement(By.xpath(loctrs.getProperty("AccountName")));
		System.out.println("AccountName is: " + AccName.getAttribute("value"));
		Thread.sleep(500);
		
		if(AccName.getAttribute("value").isEmpty() ) {
			
			
			System.out.println("We Entered the Data In AccountName");
			driver.findElement(By.xpath(loctrs.getProperty("AccountName"))).clear();
			driver.findElement(By.xpath(loctrs.getProperty("AccountName"))).sendKeys("SLR Pharma Pvt Ltd");
			
			
		}else {
			
			System.out.println("Already Data is there for AccountName");	
		}
		
		//ContactName
		
		WebElement Contactname = driver.findElement(By.xpath(loctrs.getProperty("Contactname")));
		System.out.println("Contact Name is: " + AccName.getAttribute("value"));
		Thread.sleep(500);
		
		if(Contactname.getAttribute("value").isEmpty() ) {
			
			
			System.out.println("We Entered the Data In Contactname");
			driver.findElement(By.xpath(loctrs.getProperty("Contactname"))).clear();
			driver.findElement(By.xpath(loctrs.getProperty("Contactname"))).sendKeys("SLR Pharma Pvt Ltd");
			
			
		}else {
			
			System.out.println("Already Data is there for Contact Name");	
		}

		//MobileName
		
	
		WebElement MobileNo = driver.findElement(By.xpath(loctrs.getProperty("MobileNo")));
		System.out.println("Mobile Number is: " + AccName.getAttribute("value"));
		Thread.sleep(500);
		
		if(MobileNo.getAttribute("value").isEmpty() ) {
			
			
			System.out.println("We Entered the Data In Mobile Number");
			driver.findElement(By.xpath(loctrs.getProperty("MobileNo"))).clear();
			driver.findElement(By.xpath(loctrs.getProperty("MobileNo"))).sendKeys("9133750444");
			
			
		}else {
			
			System.out.println("Already Data is there for Mobile Number");	
		}

		//EMailId
		
		WebElement Mailid = driver.findElement(By.xpath(loctrs.getProperty("Email")));
		System.out.println("Contact Name is: " + AccName.getAttribute("value"));
		Thread.sleep(500);
		
		if(Mailid.getAttribute("value").isEmpty() ) {
			
			
			System.out.println("We Entered the Data In EMail");
			driver.findElement(By.xpath(loctrs.getProperty("Email"))).clear();
			driver.findElement(By.xpath(loctrs.getProperty("Email"))).sendKeys("ntrtyresnlr@gmail.com");
			
			
		}else {
			
			System.out.println("Already Data is there for Email");	
		}

		//Destination
		
		
		WebElement Destination = driver.findElement(By.xpath(loctrs.getProperty("Designation")));
		System.out.println("Destination is: " + AccName.getAttribute("value"));
		Thread.sleep(500);
		
		if(Destination.getAttribute("value").isEmpty() ) {
			
			
			System.out.println("We Entered the Data In Destination");
			driver.findElement(By.xpath(loctrs.getProperty("Designation"))).clear();
			driver.findElement(By.xpath(loctrs.getProperty("Designation"))).sendKeys("Accountant");
			
			
		}else {
			
			System.out.println("Already Data is there for Destination");	
		}

		//Reason
		
		WebElement Reason=driver.findElement(By.xpath(loctrs.getProperty("reason")));

        Select s=new Select(Reason);

        s.selectByVisibleText("Others");
        
        driver.findElement(By.xpath(loctrs.getProperty("selectdate"))).click();
        
       List<WebElement> dates = driver.findElements(By.className("Day"));
        
        int count = driver.findElements(By.className("Day")).size();
        

        for(int i=0;i<count;i++)
        {
        String text=driver.findElements(By.className("Day")).get(i).getText();
        if(text.equalsIgnoreCase("23"))
        {
        driver.findElements(By.className("Day")).get(i).click();
        break;
        }

        }
        System.out.println(count);
        
       driver.findElement(By.xpath(loctrs.getProperty("Remarks"))).sendKeys("Already in new release,tally dout");
        
        driver.findElement(By.xpath(loctrs.getProperty("Next"))).click();
        driver.findElement(By.xpath(loctrs.getProperty("Finish"))).click();
        
	}
}











