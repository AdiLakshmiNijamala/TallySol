package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testbaseFile.TestBaseFile;

public class AccountSerach extends TestBaseFile{

	@BeforeTest
	public void startBrowser() throws IOException, InterruptedException {
		
		driver=initializeDriver();	
	}

	@Test
	public void accountSerach() throws InterruptedException {
		
		
		driver.findElement(By.xpath(loctrs.getProperty("cstmclick"))).click();
		//driver.findElement(By.xpath(loctrs.getProperty("accserach"))).click();
		driver.get("https://tally.force.com/s/account-search");
		
		
		driver.findElement(By.xpath(loctrs.getProperty("accserial"))).click();
		driver.findElement(By.xpath(loctrs.getProperty("accserial"))).sendKeys("753111414");
		driver.findElement(By.id(loctrs.getProperty("accserachbtn"))).click();
		Thread.sleep(500);
		
	}

}
