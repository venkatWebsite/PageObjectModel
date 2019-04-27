package unitTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import helper.BrowserFactory;

public class TestBrowserFactory {
	
	
	@Test
	public void testChromeBrowser()
	{
		WebDriver driver=BrowserFactory.startSession("Chrome","https://classic.crmpro.com/index.html");
		Assert.assertFalse(driver.equals(null));
		BrowserFactory.closeSession(driver);
	}
	
	@Test
	public void testFirefoxBrowser()
	{
		WebDriver driver=BrowserFactory.startSession("Firefox","https://classic.crmpro.com/index.html");
		Assert.assertFalse(driver.equals(null));
		BrowserFactory.closeSession(driver);
	}

	
	@Test
	public void testIEBrowser()
	{
		WebDriver driver=BrowserFactory.startSession("IE","https://classic.crmpro.com/index.html");
		Assert.assertFalse(driver.equals(null));
		BrowserFactory.closeSession(driver);
	}


}
