package sampleTest;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CreateReport {

	
	@Test
	public void test1() throws IOException, Exception
	{
		
		ExtentHtmlReporter html=new ExtentHtmlReporter(new File("./Report/Selenium2.html"));
		
		ExtentReports report=new ExtentReports();
		
		report.attachReporter(html);
		
		ExtentTest test1=report.createTest("Login");
		
		test1.log(Status.INFO, "username entered");
		
		test1.log(Status.INFO, "Password entered");

		test1.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Chandani_50\\Desktop\\Demo.png").build());
		
		report.flush();
		
		
		ExtentTest test2=report.createTest("Logout");
		
		Thread.sleep(10000);
		
		test2.fail("Test Failed because of Some issue");
		
		test2.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Chandani_50\\Desktop\\Demo.png").build());
	
		report.flush();
		
		
		ExtentTest test3=report.createTest("Close Session");
		
		Thread.sleep(10000);
		
		test3.pass("Test passed ");
		
		report.flush();
		
	}
	
}
