package Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class page6 {
	public static void main(String[] args) throws InterruptedException {
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site 
		driver.get("https://books-pwakit.appspot.com");
		driver.manage().window().maximize();
		Thread.sleep(5000); 
		//Element under a single shadow DOM.
		driver.findElement(By.xpath("//book-app[@apptitle='BOOKS']"))
		      .getShadowRoot()
		      .findElement(By.id("input")).sendKeys("abdul kalam");
	}

}
