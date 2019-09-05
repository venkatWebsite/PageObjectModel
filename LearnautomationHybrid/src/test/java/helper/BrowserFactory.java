package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class BrowserFactory {

	
	public static WebDriver startSession(String browserName,String url)
	{
		Reporter.log("Starting "+browserName +" Waiting for browser to launch", true);
		
		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\.m2\\repository\\webdriver\\chromedriver\\win32\\75.0.3770.140\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chandani_50\\Desktop\\Feb\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			
		}else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Chandani_50\\Desktop\\Feb\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		else
		{
			Reporter.log("Sorry We only support Chrome, Firefox and IE- Please select only these options", true);
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Reporter.log("Application is up and running", true);
		return driver;
	}
	
	
	public static void closeSession(WebDriver driver)
	{
		Reporter.log("Trying to close the session ", true);
		driver.quit();
		Reporter.log("Session Closed", true);


	}
	
	
}
