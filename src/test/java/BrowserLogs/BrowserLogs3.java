package BrowserLogs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLogs3 {
	public static void main(String[] args) {
		// Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site using base URL
		long st = System.currentTimeMillis();
		driver.navigate().to("https://www.google.co.in");// no wait for page source
		driver.manage().window().maximize();
		long et = System.currentTimeMillis();
		System.out.println(et - st);
	}

}
