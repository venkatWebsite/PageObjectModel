package testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dataProvider.DataProviderFactory;
import helper.BrowserFactory;
import helper.Utlity;

public class BaseClass {

	
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger;
	

	
	@BeforeSuite
	public void setupProject()
	{
		
		Reporter.log("Setting up Report for the Project", true);
		
		ExtentHtmlReporter html=new ExtentHtmlReporter(new File("./Report/LearnAutomation_"+Utlity.getCurrentTime()+".html"));
		
		report=new ExtentReports();
		
		report.attachReporter(html);
		
		Reporter.log("Report instance is ready", true);

	}
	
/*	@BeforeClass
	public void setupTest()
	{  
		driver=BrowserFactory.startSession(DataProviderFactory.getConfig().getPropertyValue("Browser"),
				DataProviderFactory.getConfig().getStagingURL());		
	}
	*/
	
	@Parameters("appBrowser")
	@BeforeClass
	public void setupTest(String browser)
	{  
		driver=BrowserFactory.startSession(browser,DataProviderFactory.getConfig().getStagingURL());		
	}
	
	@AfterClass
	public void tearDownTest()
	{
		BrowserFactory.closeSession(driver);	
	}
	
	
	
	@AfterMethod
	public void tearDownProject(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed");
		}
		else
		{
			try {
				logger.fail("Test Failed "+result.getThrowable().getMessage(), 
						MediaEntityBuilder.createScreenCaptureFromPath(Utlity.captureScreenshot(driver)).build());
			} catch (IOException e) {
				
			}
		}
		report.flush();
		Reporter.log("Adding the test result to the report", true);

	}
	
	
}
