package Flipkart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class attribute4 {
	public static void main(String[] args) throws InterruptedException {
		// open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		// Locate element and get attribute value and property value
		WebElement e = driver.findElement(By.name("q"));
		System.out.println(e.getAttribute("maxlength")); // HTML attribute
		System.out.println(e.getAttribute("clientHeight")); // HTML property
		// get value of an attribute of element given by developer in page source only
		System.out.println(e.getDomAttribute("maxlength")); // HTML attribute
		// get value of a property of element added by browser only
		System.out.println(e.getDomProperty("clientHeight")); // HTML property
		// Close site
		driver.close();
	}

}
