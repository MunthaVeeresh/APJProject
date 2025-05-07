package Flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class login7 {
	public static void main(String[] args) throws InterruptedException {
		//open browser
				WebDriverManager.chromedriver().setup();
				RemoteWebDriver driver=new ChromeDriver();
				//Launch site 
				driver.get("chrome://settings/");
				Thread.sleep(5000); 
				//This Element is inside of nested shadow DOM.
				driver.findElement(By.tagName("settings-ui")).getShadowRoot()
				      .findElement(By.id("toolbar")).getShadowRoot()
				      .findElement(By.id("search")).getShadowRoot()
				      .findElement(By.id("searchInput")).sendKeys("abdulkalam");
	}

}
