package PracticeXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

public class java5 {
	public static void main(String[] args) throws InterruptedException {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		// Locate an visible element, which is either enabled or disabled or
		// covered by another element like banner in page
		// We will get correct output
		WebElement e = driver.findElement(By.name("q"));
		// Get width, height, x & y-coordinates
		int w = e.getSize().getWidth();
		int h = e.getSize().getHeight();
		System.out.println(w + " " + h);
		int x = e.getLocation().getX();
		int y = e.getLocation().getY();
		System.out.println(x + " " + y);
		int w1 = e.getRect().getWidth();
		int h1 = e.getRect().getHeight();
		int x1 = e.getRect().getX();
		int y1 = e.getRect().getY();
		System.out.println(w1 + " " + h1 + " " + x1 + " " + y1);
		// close site
		driver.close();
	}

}
