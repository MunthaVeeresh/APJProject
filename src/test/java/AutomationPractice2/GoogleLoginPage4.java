package AutomationPractice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLoginPage4 {
	public static void main(String[] args) throws Exception {
		// Open initial browser window
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch google site
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		// Create new tab
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(5000);
		// Collect window handle values(strings) of those browser windows/tabs
		Set<String> s = driver.getWindowHandles(); // sequential set
		List<String> a = new ArrayList<String>(s); // random list
		// switch to new tab(2nd)
		driver.switchTo().window(a.get(1));
		// Launch gmail site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		// Create new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		// Recollect window handle values(strings) of those browser windows/tabs
		s = driver.getWindowHandles(); // sequential set
		a = new ArrayList<String>(s); // random list
		// switch to new window(3rd)
		driver.switchTo().window(a.get(2));
		// Launch yahoo site
		driver.get("http://www.yahoomail.com");
		Thread.sleep(5000);
		// close all windows/tabs
		driver.quit();
	}
}
