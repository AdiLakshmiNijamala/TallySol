package testbaseFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestBaseFile {

	public static WebDriver  driver;
	public static Properties prop;
	public static Properties loctrs;
	
	public WebDriver initializeDriver() throws IOException, InterruptedException {
	
	prop= new Properties();
	FileInputStream filename = new FileInputStream("E:\\Testing\\Workspace\\TallyAutomation\\src\\test\\resources\\properties\\testconfig.properties");
	
	prop.load(filename);
	
	loctrs= new Properties();
	FileInputStream locators = new FileInputStream("E:\\Testing\\Workspace\\TallyAutomation\\src\\test\\resources\\properties\\locators.properties");
	
	loctrs.load(locators);

	
	String browserName = prop.getProperty("browser");
	System.out.println(browserName);
	
	if (browserName.contains("chrome"))	
	{
		//we need to execute the chrome driver
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\Workspace\\TallyAutomation\\src\\test\\resources\\executable\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	driver.get(prop.getProperty("testbaseurl"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.findElement(By.xpath(loctrs.getProperty("lgnbtn"))).click();
	driver.findElement(By.xpath(loctrs.getProperty("username"))).sendKeys("tallynellore@gmail.com");
	driver.findElement(By.xpath(loctrs.getProperty("pswdbtn"))).sendKeys("Lakshminlr@123");
	driver.findElement(By.xpath(loctrs.getProperty("Sgnbtn"))).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(loctrs.getProperty("NlrlctnSelect"))).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(loctrs.getProperty("cktDashboard"))).click();
	String PrflName= driver.findElement(By.xpath(loctrs.getProperty("profilename"))).getText();
	System.out.println(PrflName);
	
	if(PrflName=="SIVA") {
		
		System.out.println("We are in Owners DashBoard");
	}else {
		
		System.out.println("We are in " + PrflName + " DashBoard");	
	}
	return driver;
	
	}
	
	@AfterTest
	public void endbrowser() {
		
		driver.close();
	}
}
