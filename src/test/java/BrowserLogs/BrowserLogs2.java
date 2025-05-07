package BrowserLogs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLogs2 {
	public static void main(String[] args) {
		// Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site using base URL
		long st = System.currentTimeMillis();
		driver.get("https://www.google.co.in"); // wait and get complete page source
		driver.manage().window().maximize();
		long et = System.currentTimeMillis();
		System.out.println(et - st);
	}

}
