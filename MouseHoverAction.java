package click;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\drivers & jar\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://learn-automation.com/disable-chrome-notifications-selenium-webdriver/ ");
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Automation Tools'][1]")))
		.pause(Duration.ofSeconds(2))
		.moveToElement(driver.findElement(By.xpath("(//span[text()='Selenium'])[1]")))
		.pause(Duration.ofSeconds(2))
		.click(driver.findElement(By.xpath("(//span[text()='Selenium Basic'])[1]")))
		.build().perform();
		//driver.close();
	}

}
