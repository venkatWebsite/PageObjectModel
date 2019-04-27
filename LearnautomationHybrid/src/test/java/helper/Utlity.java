package helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utlity 
{
   	
	public static String captureScreenshot(WebDriver driver)
	{
	
		String pathOfScreenShot=System.getProperty("user.dir")+"\\Screenshots\\LearnAutomation"+getCurrentTime()+".png";
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		try
		{
			FileHandler.copy(src,new File(pathOfScreenShot));
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
			System.out.println("Screenshot capturing failed");
		}
		
		return pathOfScreenShot;
	}
	
	
	public static String getCurrentTime()
	{
		
		DateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		
		Date date=new Date();
		
		return dateFormat.format(date);
		
		
	}
	
	
	public static void verifyTitleContains(WebDriver driver, String expectedTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains(expectedTitle));
	}
	
	public static void verifyTitleIs(WebDriver driver, String expectedTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs(expectedTitle));
	}
	
	
	public static void switchFrameByNameAndId(WebDriver driver, String nameOrId)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
	}
	
	public static void acceptAlert(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.alertIsPresent()).accept();
		
	}
	public static void dismissAlert(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
		
	}
	public static void getAlertTextAndVerify(WebDriver driver,String expectedText)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);

		String actualText=wait.until(ExpectedConditions.alertIsPresent()).getText();
		
		Assert.assertEquals(actualText, expectedText);
		
	}
	
	public static void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
}
