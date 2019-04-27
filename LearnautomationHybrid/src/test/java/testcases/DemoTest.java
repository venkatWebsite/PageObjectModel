package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DemoTest extends BaseClass{

	
	@Test
	public void test1()
	{
		logger=report.createTest("Google Test");
		
		driver.get("http://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");
		
		logger.pass("Google test passed");
	}
	
	@Test
	public void test2()
	{
		logger=report.createTest("yahoo Test");
		
		driver.get("http://www.yahoo.com");
	
		logger.pass("yahoo test passed");
	}
	
	
}
