package PracticeXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class java6 {
	public static void main(String[] args) throws InterruptedException {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site and locate an hidden element
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		// Locate an element, which is not visible in page
		WebElement e = driver.findElement(By.name("hiddenPassword"));
		// get size info
		int w = e.getSize().getWidth();
		int h = e.getSize().getHeight();
		System.out.println(w + " " + h); // as per source code, no exception
		// get location info
		int x = e.getLocation().getX();
		int y = e.getLocation().getY();
		System.out.println(x + " " + y); // 0 and 0 for hidden element, no exception
		// get rect info
		int w1 = e.getRect().getWidth();
		int h1 = e.getRect().getHeight();
		int x1 = e.getRect().getX();
		int y1 = e.getRect().getY();
		System.out.println(w1 + " " + h1 + " " + x1 + " " + y1);
		// Close site
		driver.close();
	}

}
