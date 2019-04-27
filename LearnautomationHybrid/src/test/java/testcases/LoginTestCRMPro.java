package testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import applicationPages.HomePage;
import applicationPages.LogOutPage;
import helper.Utlity;

public class LoginTestCRMPro extends BaseClass{
	HomePage home;
	LogOutPage logout;
	
	@Test
	public void loginAsAdmin() throws Exception
	{
		home=PageFactory.initElements(driver, HomePage.class);	
		
		logout=PageFactory.initElements(driver, LogOutPage.class);	
		
		logger=report.createTest("Login and Logout for application");
		
		home.verifyHomePageTitle();
		
		logger.pass("User is landled on correct page");
		
		home.loginAsAdmin();
		
		try 
		{
			logger.pass("User is able to login",MediaEntityBuilder.createScreenCaptureFromPath(Utlity.captureScreenshot(driver)).build());
		} catch (IOException e) {
			
		}
		
		logout.logOutFromApplication();
		
		home.verifyHomePageTitle();

		logger.pass("User is able to logOut");
	}
	
	
	
}
