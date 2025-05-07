package AutomationPractice2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PageLoadTimeOut9 {
	public static void main(String[] args) {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		Duration d = driver.manage().timeouts().getPageLoadTimeout();
		System.out.println(d.getSeconds());
		// Launch site
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.gmail.com");
		// close site
		driver.close();
	}

}
