package Flipkart;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class elements5 {
	public static void main(String[] args) throws InterruptedException {
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		// Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		// locate an element
		WebElement e = driver.findElement(By.name("identifier"));
		String x = e.getAccessibleName(); // internally SWD remembered name
		System.out.println(x);
		String y = e.getAriaRole(); // internally SWD remembered type
		System.out.println(y);
		// close site
		driver.close();
	}

}
