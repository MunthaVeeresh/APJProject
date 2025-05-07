package AutomationPractice2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebookloginpage3 {
	public static void main(String[] args) throws Exception {
		// Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site using base URL
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// Fill active element(EmailId)
		driver.switchTo().activeElement().sendKeys("abdulkalam", Keys.TAB);
		Thread.sleep(5000);
		// Fill active element(Password)
		driver.switchTo().activeElement().sendKeys("batch262", Keys.TAB, Keys.TAB);
		Thread.sleep(5000);
		// Click on active element
		driver.switchTo().activeElement().click();
	}

}
