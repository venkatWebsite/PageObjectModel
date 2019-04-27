package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//a[text()='Companies']") WebElement users;
	
	public void addUser()
	{
		driver.switchTo().frame("mainpanel");
		users.click();
	}
	
}
