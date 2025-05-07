package BrowserControleres;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class backforwardrefresh1 {
	public static void main(String[] args) throws Exception {
		// Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch google
		driver.navigate().to("https://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		// goto facebook
		URL u = new URL("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.navigate().to(u);
		Thread.sleep(5000);
		// back to google
		driver.navigate().back();
		Thread.sleep(5000);
		// forward to facebook
		driver.navigate().forward();
		Thread.sleep(5000);
		// refresh facebook
		driver.navigate().refresh();
		Thread.sleep(5000);
		// close site
		// driver.close();
	}

}
