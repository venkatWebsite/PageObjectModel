package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dataProvider.DataProviderFactory;
import helper.Utlity;

public class HomePage {
	
	WebDriver driver;

	
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement loginButton;

	public void verifyHomePageTitle()
	{		
		Utlity.verifyTitleContains(driver, "CRM software");	
	}
	
	public void loginAsAdmin() throws Exception
	{
		username.sendKeys(DataProviderFactory.getExcel().getStringCellData("CRMProLogin", 0, 0));
		
		password.sendKeys(DataProviderFactory.getExcel().getStringCellData("CRMProLogin", 0, 1));
		
		Thread.sleep(5000);
		
		loginButton.click();
		
		Utlity.verifyTitleIs(driver, "CRMPRO");
	}
		
}
