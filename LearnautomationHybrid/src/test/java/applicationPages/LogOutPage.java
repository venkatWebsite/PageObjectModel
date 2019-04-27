package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.Utlity;

public class LogOutPage {
	
	
	WebDriver driver;
	
	public LogOutPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	
	@FindBy(xpath="//*[contains(text(),'Logout')]") WebElement logout;

	public void logOutFromApplication()
	{
		Utlity.switchFrameByNameAndId(driver, "mainpanel");
		logout.click();
		driver.switchTo().defaultContent();
	}
	
}
